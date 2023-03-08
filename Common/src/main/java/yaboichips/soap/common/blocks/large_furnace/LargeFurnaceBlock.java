package yaboichips.soap.common.blocks.large_furnace;

import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import yaboichips.soap.core.SoapTileEntities;

public class LargeFurnaceBlock extends AbstractFurnaceBlock {
    public LargeFurnaceBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockentity = world.getBlockEntity(pos);
        if (blockentity instanceof LargeFurnaceTE) {
            player.openMenu((MenuProvider) blockentity);
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LargeFurnaceTE(pos, state);
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, SoapTileEntities.LARGE_FURNACE, LargeFurnaceTE::serverTick);
    }
}
