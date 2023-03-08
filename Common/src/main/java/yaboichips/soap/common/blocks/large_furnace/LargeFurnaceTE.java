package yaboichips.soap.common.blocks.large_furnace;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import yaboichips.soap.core.SoapRecipeTypes;
import yaboichips.soap.core.SoapTileEntities;

import javax.annotation.Nullable;

public class LargeFurnaceTE extends AbstractFurnaceBlockEntity {
    protected LargeFurnaceTE(BlockEntityType<?> $$0, BlockPos $$1, BlockState $$2, RecipeType<? extends AbstractCookingRecipe> $$3) {
        super($$0, $$1, $$2, $$3);
    }

    public LargeFurnaceTE(BlockPos pos, BlockState state) {
        this(SoapTileEntities.LARGE_FURNACE, pos, state, SoapRecipeTypes.LARGE_FURNACE);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.large_furnace");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int slot, @NotNull Inventory inv) {
        return new LargeFurnaceMenu(slot, inv, this, this.dataAccess);
    }


    public static void serverTick(Level level, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity blockEntity) {
        boolean lit = blockEntity.isLit();
        boolean b = false;
        if (blockEntity.isLit()) {
            --blockEntity.litTime;
        }

        ItemStack fuel = blockEntity.items.get(1);
        boolean hasCookItem = !blockEntity.items.get(0).isEmpty();
        boolean hasFuel = !fuel.isEmpty();
        if (blockEntity.isLit() || hasFuel && hasCookItem) {
            Recipe $$10;
            if (hasCookItem) {
                $$10 = blockEntity.quickCheck.getRecipeFor(blockEntity, level).orElse(null);
            } else {
                $$10 = null;
            }

            int $$11 = blockEntity.getMaxStackSize();
            if (!blockEntity.isLit() && canBurn($$10, blockEntity.items, $$11)) {
                blockEntity.litTime = blockEntity.getBurnDuration(fuel);
                blockEntity.litDuration = blockEntity.litTime;
                if (blockEntity.isLit()) {
                    b = true;
                    if (hasFuel) {
                        Item $$12 = fuel.getItem();
                        fuel.shrink(1);
                        if (fuel.isEmpty()) {
                            Item resultItem = $$12.getCraftingRemainingItem();
                            blockEntity.items.set(1, resultItem == null ? ItemStack.EMPTY : new ItemStack(resultItem));
                        }
                    }
                }
            }

            if (blockEntity.isLit() && canBurn($$10, blockEntity.items, $$11)) {
                ++blockEntity.cookingProgress;
                if (blockEntity.cookingProgress == blockEntity.cookingTotalTime) {
                    blockEntity.cookingProgress = 0;
                    blockEntity.cookingTotalTime = getTotalCookTime(level, blockEntity);
                    if (burn($$10, blockEntity.items, $$11)) {
                        blockEntity.setRecipeUsed($$10);
                    }

                    b = true;
                }
            } else {
                blockEntity.cookingProgress = 0;
            }
        } else if (!blockEntity.isLit() && blockEntity.cookingProgress > 0) {
            blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
        }

        if (lit != blockEntity.isLit()) {
            b = true;
            state = state.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (b) {
            setChanged(level, pos, state);
        }
    }
    public static boolean canBurn(@Nullable Recipe<?> recipe, NonNullList<ItemStack> items, int $$2) {
        if ((items.get(0).getCount() >= 8) && recipe != null) {
            ItemStack result = recipe.getResultItem();
            if (result.isEmpty()) {
                return false;
            } else {
                ItemStack output = items.get(2);
                if (output.isEmpty()) {
                    return true;
                } else if (!output.sameItem(result)) {
                    return false;
                } else if (output.getCount() < $$2 && output.getCount() < output.getMaxStackSize()) {
                    return true;
                } else {
                    return output.getCount() < result.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }

    public static boolean burn(@Nullable Recipe<?> recipe, NonNullList<ItemStack> items, int $$2) {
        if (recipe != null && canBurn(recipe, items, $$2)) {
            ItemStack ingredient = items.get(0);
            ItemStack result = recipe.getResultItem();
            ItemStack output = items.get(2);
            if (output.isEmpty()) {
                ItemStack counted = result.copy();
                counted.setCount(8);
                items.set(2, counted);
            } else if (output.is(result.getItem())) {
                output.grow(8);
            }

            if (ingredient.is(Blocks.WET_SPONGE.asItem()) && !((ItemStack)items.get(1)).isEmpty() && items.get(1).is(Items.BUCKET)) {
                items.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            ingredient.shrink(8);
            return true;
        } else {
            return false;
        }
    }
}
