package yaboichips.usefulutilities.common.blocks.hopper;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.WorldlyContainerHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.HopperMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import yaboichips.usefulutilities.core.UUTileEntities;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CopperHopperTE extends RandomizableContainerBlockEntity implements Hopper {
    public static final int MOVE_ITEM_SPEED = 1;
    public static final int HOPPER_CONTAINER_SIZE = 1;
    private NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    private int cooldownTime = -1;
    private long tickedGameTime;

    public CopperHopperTE(BlockPos $$0, BlockState $$1) {
        super(UUTileEntities.COPPER_HOPPER, $$0, $$1);
    }

    public void load(CompoundTag $$0) {
        super.load($$0);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable($$0)) {
            ContainerHelper.loadAllItems($$0, this.items);
        }
    }

    protected void saveAdditional(CompoundTag $$0) {
        super.saveAdditional($$0);
        if (!this.trySaveLootTable($$0)) {
            ContainerHelper.saveAllItems($$0, this.items);
        }
    }

    public int getContainerSize() {
        return this.items.size();
    }

    public ItemStack removeItem(int $$0, int $$1) {
        this.unpackLootTable((Player)null);
        return ContainerHelper.removeItem(this.getItems(), $$0, $$1);
    }

    public void setItem(int $$0, ItemStack $$1) {
        this.unpackLootTable((Player)null);
        this.getItems().set($$0, $$1);
        if ($$1.getCount() > this.getMaxStackSize()) {
            $$1.setCount(this.getMaxStackSize());
        }

    }

    protected Component getDefaultName() {
        return new TranslatableComponent("container.hopper");
    }

    public static void pushItemsTick(Level level, BlockPos pos, BlockState state, CopperHopperTE te) {
            tryMoveItems(level, pos, state, te, () -> suckInItems(level, te));
    }

    private static boolean tryMoveItems(Level $$0, BlockPos $$1, BlockState $$2, CopperHopperTE $$3, BooleanSupplier $$4) {
        if ($$0.isClientSide) {
            return false;
        } else {
            if ($$2.getValue(HopperBlock.ENABLED)) {
                boolean $$5 = false;
                if (!$$3.isEmpty()) {
                    $$5 = ejectItems($$0, $$1, $$2, $$3);
                }

                if (!$$3.inventoryFull()) {
                    $$5 |= $$4.getAsBoolean();
                }

                if ($$5) {
                    setChanged($$0, $$1, $$2);
                    return true;
                }
            }

            return false;
        }
    }

    private boolean inventoryFull() {
        for(ItemStack $$0 : this.items) {
            if ($$0.isEmpty() || $$0.getCount() != $$0.getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    private static boolean ejectItems(Level $$0, BlockPos $$1, BlockState $$2, Container $$3) {
        Container $$4 = getAttachedContainer($$0, $$1, $$2);
        if ($$4 == null) {
            return false;
        } else {
            Direction $$5 = $$2.getValue(HopperBlock.FACING).getOpposite();
            if (isFullContainer($$4, $$5)) {
                return false;
            } else {
                for(int $$6 = 0; $$6 < $$3.getContainerSize(); ++$$6) {
                    if (!$$3.getItem($$6).isEmpty()) {
                        ItemStack $$7 = $$3.getItem($$6).copy();
                        ItemStack $$8 = addItem($$3, $$4, $$3.removeItem($$6, 1), $$5);
                        if ($$8.isEmpty()) {
                            $$4.setChanged();
                            return true;
                        }

                        $$3.setItem($$6, $$7);
                    }
                }

                return false;
            }
        }
    }

    private static IntStream getSlots(Container $$0, Direction $$1) {
        return $$0 instanceof WorldlyContainer ? IntStream.of(((WorldlyContainer)$$0).getSlotsForFace($$1)) : IntStream.range(0, $$0.getContainerSize());
    }

    private static boolean isFullContainer(Container $$0, Direction $$1) {
        return getSlots($$0, $$1).allMatch(($$1x) -> {
            ItemStack $$2 = $$0.getItem($$1x);
            return $$2.getCount() >= $$2.getMaxStackSize();
        });
    }

    private static boolean isEmptyContainer(Container $$0, Direction $$1) {
        return getSlots($$0, $$1).allMatch(($$1x) -> $$0.getItem($$1x).isEmpty());
    }

    public static boolean suckInItems(Level $$0, Hopper $$1) {
        Container $$2 = getSourceContainer($$0, $$1);
        if ($$2 != null) {
            Direction $$3 = Direction.DOWN;
            return isEmptyContainer($$2, $$3) ? false : getSlots($$2, $$3).anyMatch(($$3x) -> tryTakeInItemFromSlot($$1, $$2, $$3x, $$3));
        } else {
            for(ItemEntity $$4 : getItemsAtAndAbove($$0, $$1)) {
                if (addItem($$1, $$4)) {
                    return true;
                }
            }

            return false;
        }
    }

    private static boolean tryTakeInItemFromSlot(Hopper $$0, Container $$1, int $$2, Direction $$3) {
        ItemStack $$4 = $$1.getItem($$2);
        if (!$$4.isEmpty() && canTakeItemFromContainer($$1, $$4, $$2, $$3)) {
            ItemStack $$5 = $$4.copy();
            ItemStack $$6 = addItem($$1, $$0, $$1.removeItem($$2, 1), (Direction)null);
            if ($$6.isEmpty()) {
                $$1.setChanged();
                return true;
            }

            $$1.setItem($$2, $$5);
        }

        return false;
    }

    public static boolean addItem(Container $$0, ItemEntity $$1) {
        boolean $$2 = false;
        ItemStack $$3 = $$1.getItem().copy();
        ItemStack $$4 = addItem((Container)null, $$0, $$3, (Direction)null);
        if ($$4.isEmpty()) {
            $$2 = true;
            $$1.discard();
        } else {
            $$1.setItem($$4);
        }

        return $$2;
    }

    public static ItemStack addItem(Container $$0, Container $$1, ItemStack $$2, Direction $$3) {
        if ($$1 instanceof WorldlyContainer && $$3 != null) {
            WorldlyContainer $$4 = (WorldlyContainer)$$1;
            int[] $$5 = $$4.getSlotsForFace($$3);

            for(int $$6 = 0; $$6 < $$5.length && !$$2.isEmpty(); ++$$6) {
                $$2 = tryMoveInItem($$0, $$1, $$2, $$5[$$6], $$3);
            }
        } else {
            int $$7 = $$1.getContainerSize();

            for(int $$8 = 0; $$8 < $$7 && !$$2.isEmpty(); ++$$8) {
                $$2 = tryMoveInItem($$0, $$1, $$2, $$8, $$3);
            }
        }

        return $$2;
    }

    private static boolean canPlaceItemInContainer(Container $$0, ItemStack $$1, int $$2, Direction $$3) {
        if (!$$0.canPlaceItem($$2, $$1)) {
            return false;
        } else {
            return !($$0 instanceof WorldlyContainer) || ((WorldlyContainer)$$0).canPlaceItemThroughFace($$2, $$1, $$3);
        }
    }

    private static boolean canTakeItemFromContainer(Container $$0, ItemStack $$1, int $$2, Direction $$3) {
        return !($$0 instanceof WorldlyContainer) || ((WorldlyContainer)$$0).canTakeItemThroughFace($$2, $$1, $$3);
    }

    private static ItemStack tryMoveInItem(Container $$0, Container $$1, ItemStack $$2, int $$3, Direction $$4) {
        ItemStack $$5 = $$1.getItem($$3);
        if (canPlaceItemInContainer($$1, $$2, $$3, $$4)) {
            boolean $$6 = false;
            boolean $$7 = $$1.isEmpty();
            if ($$5.isEmpty()) {
                $$1.setItem($$3, $$2);
                $$2 = ItemStack.EMPTY;
                $$6 = true;
            } else if (canMergeItems($$5, $$2)) {
                int $$8 = $$2.getMaxStackSize() - $$5.getCount();
                int $$9 = Math.min($$2.getCount(), $$8);
                $$2.shrink($$9);
                $$5.grow($$9);
                $$6 = $$9 > 0;
            }

            if ($$6) {
                if ($$7 && $$1 instanceof CopperHopperTE) {
                    CopperHopperTE $$10 = (CopperHopperTE)$$1;
                    if (!$$10.isOnCustomCooldown()) {
                        int $$11 = 0;
                        if ($$0 instanceof CopperHopperTE) {
                            CopperHopperTE $$12 = (CopperHopperTE)$$0;
                            if ($$10.tickedGameTime >= $$12.tickedGameTime) {
                                $$11 = 1;
                            }
                        }

                        $$10.setCooldown(8 - $$11);
                    }
                }

                $$1.setChanged();
            }
        }

        return $$2;
    }

    
    private static Container getAttachedContainer(Level $$0, BlockPos $$1, BlockState $$2) {
        Direction $$3 = $$2.getValue(HopperBlock.FACING);
        return getContainerAt($$0, $$1.relative($$3));
    }

    
    private static Container getSourceContainer(Level $$0, Hopper $$1) {
        return getContainerAt($$0, $$1.getLevelX(), $$1.getLevelY() + 1.0D, $$1.getLevelZ());
    }

    public static List<ItemEntity> getItemsAtAndAbove(Level $$0, Hopper $$1) {
        return $$1.getSuckShape().toAabbs().stream().flatMap(($$2) -> $$0.getEntitiesOfClass(ItemEntity.class, $$2.move($$1.getLevelX() - 0.5D, $$1.getLevelY() - 0.5D, $$1.getLevelZ() - 0.5D), EntitySelector.ENTITY_STILL_ALIVE).stream()).collect(Collectors.toList());
    }

    
    public static Container getContainerAt(Level $$0, BlockPos $$1) {
        return getContainerAt($$0, (double)$$1.getX() + 0.5D, (double)$$1.getY() + 0.5D, (double)$$1.getZ() + 0.5D);
    }

    
    private static Container getContainerAt(Level $$0, double $$1, double $$2, double $$3) {
        Container $$4 = null;
        BlockPos $$5 = new BlockPos($$1, $$2, $$3);
        BlockState $$6 = $$0.getBlockState($$5);
        Block $$7 = $$6.getBlock();
        if ($$7 instanceof WorldlyContainerHolder) {
            $$4 = ((WorldlyContainerHolder)$$7).getContainer($$6, $$0, $$5);
        } else if ($$6.hasBlockEntity()) {
            BlockEntity $$8 = $$0.getBlockEntity($$5);
            if ($$8 instanceof Container) {
                $$4 = (Container)$$8;
                if ($$4 instanceof ChestBlockEntity && $$7 instanceof ChestBlock) {
                    $$4 = ChestBlock.getContainer((ChestBlock)$$7, $$6, $$0, $$5, true);
                }
            }
        }

        if ($$4 == null) {
            List<Entity> $$9 = $$0.getEntities((Entity)null, new AABB($$1 - 0.5D, $$2 - 0.5D, $$3 - 0.5D, $$1 + 0.5D, $$2 + 0.5D, $$3 + 0.5D), EntitySelector.CONTAINER_ENTITY_SELECTOR);
            if (!$$9.isEmpty()) {
                $$4 = (Container)$$9.get($$0.random.nextInt($$9.size()));
            }
        }

        return $$4;
    }

    private static boolean canMergeItems(ItemStack $$0, ItemStack $$1) {
        if (!$$0.is($$1.getItem())) {
            return false;
        } else if ($$0.getDamageValue() != $$1.getDamageValue()) {
            return false;
        } else if ($$0.getCount() > $$0.getMaxStackSize()) {
            return false;
        } else {
            return ItemStack.tagMatches($$0, $$1);
        }
    }

    public double getLevelX() {
        return (double)this.worldPosition.getX() + 0.5D;
    }

    public double getLevelY() {
        return (double)this.worldPosition.getY() + 0.5D;
    }

    public double getLevelZ() {
        return (double)this.worldPosition.getZ() + 0.5D;
    }

    private void setCooldown(int $$0) {
        this.cooldownTime = $$0;
    }

    private boolean isOnCooldown() {
        return this.cooldownTime > 0;
    }

    private boolean isOnCustomCooldown() {
        return this.cooldownTime > 8;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> $$0) {
        this.items = $$0;
    }

    public static void entityInside(Level $$0, BlockPos $$1, BlockState $$2, Entity $$3, CopperHopperTE $$4) {
        if ($$3 instanceof ItemEntity && Shapes.joinIsNotEmpty(Shapes.create($$3.getBoundingBox().move((double)(-$$1.getX()), (double)(-$$1.getY()), (double)(-$$1.getZ()))), $$4.getSuckShape(), BooleanOp.AND)) {
            tryMoveItems($$0, $$1, $$2, $$4, () -> addItem($$4, (ItemEntity)$$3));
        }

    }

    protected AbstractContainerMenu createMenu(int $$0, Inventory $$1) {
        return new HopperMenu($$0, $$1, this);
    }
}
