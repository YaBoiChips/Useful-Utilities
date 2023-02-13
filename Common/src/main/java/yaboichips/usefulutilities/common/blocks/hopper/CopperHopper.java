package yaboichips.usefulutilities.common.blocks.hopper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import yaboichips.usefulutilities.core.UUTileEntities;

public class CopperHopper extends HopperBlock {

    public static final DirectionProperty FACING = BlockStateProperties.FACING_HOPPER;
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;

    public CopperHopper(Properties properties) {
        super(properties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(ENABLED);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getClickedFace().getOpposite();
        if (direction == Direction.UP) {
            direction = Direction.DOWN;
        }
        return this.defaultBlockState().setValue(FACING, direction);
    }

    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        return Blocks.HOPPER.getShape(state, blockGetter, pos, context);
    }

    public VoxelShape getInteractionShape(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return Blocks.HOPPER.getInteractionShape(state, blockGetter, pos);
    }

    public void entityInside(BlockState p_54066_, Level p_54067_, BlockPos p_54068_, Entity p_54069_) {
        BlockEntity blockentity = p_54067_.getBlockEntity(p_54068_);
        if (blockentity instanceof CopperHopperTE te) {
            CopperHopperTE.entityInside(p_54067_, p_54068_, p_54066_, p_54069_, te);
        }

    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperHopperTE(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, UUTileEntities.COPPER_HOPPER, CopperHopperTE::pushItemsTick);
    }
}
