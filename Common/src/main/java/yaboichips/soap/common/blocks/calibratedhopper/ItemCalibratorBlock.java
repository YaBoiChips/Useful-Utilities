package yaboichips.soap.common.blocks.calibratedhopper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class ItemCalibratorBlock extends BaseEntityBlock implements WorldlyContainerHolder {

    public ItemCalibratorTE tile;

    public ItemCalibratorBlock(Properties $$0) {
        super($$0);
    }


    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return tile = new ItemCalibratorTE(pos, state);
    }


    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return makeShape();
    }

    public VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0, 0.1875, 0, 1, 0.5625, 1), BooleanOp.OR);
        return shape;
    }

    @Override
    public void setPlacedBy(Level $$0, BlockPos $$1, BlockState $$2, LivingEntity $$3, ItemStack $$4) {
        if ($$4.hasCustomHoverName()) {
            BlockEntity $$5 = $$0.getBlockEntity($$1);
            if ($$5 instanceof ItemCalibratorTE) {
                ((ItemCalibratorTE) $$5).setCustomName($$4.getHoverName());
            }
        }
    }


    @Override
    public InteractionResult use(BlockState $$0, Level $$1, BlockPos $$2, Player $$3, InteractionHand $$4, BlockHitResult $$5) {
        if ($$1.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity $$6 = $$1.getBlockEntity($$2);
            if ($$6 instanceof ItemCalibratorTE) {
                $$3.openMenu((ItemCalibratorTE) $$6);
            }

            return InteractionResult.CONSUME;
        }
    }

    @Override
    public void onRemove(BlockState $$0, Level $$1, BlockPos $$2, BlockState $$3, boolean $$4) {
        if (!$$0.is($$3.getBlock())) {
            BlockEntity $$5 = $$1.getBlockEntity($$2);
            if ($$5 instanceof ItemCalibratorTE) {
                Containers.dropContents($$1, $$2, (ItemCalibratorTE) $$5);
                $$1.updateNeighbourForOutputSignal($$2, this);
            }

            super.onRemove($$0, $$1, $$2, $$3, $$4);
        }
    }

    @Override
    public WorldlyContainer getContainer(BlockState var1, LevelAccessor var2, BlockPos var3) {
        if (tile.getItem(0).getCount() > 1) {
            return tile;
        } else {
            return new CalibratedContainer();
        }
    }

    static class CalibratedContainer extends SimpleContainer implements WorldlyContainer {

        public CalibratedContainer() {
            super();
        }

        @Override
        public int getMaxStackSize() {
            return 1;
        }

        @Override
        public int @NotNull [] getSlotsForFace(Direction direction) {
            return new int[]{0};
        }

        @Override
        public boolean canPlaceItemThroughFace(int $$0, ItemStack $$1, @javax.annotation.Nullable Direction $$2) {
            return true;
        }

        @Override
        public boolean canTakeItemThroughFace(int $$0, ItemStack $$1, Direction $$2) {
            return false;
        }
    }
}
