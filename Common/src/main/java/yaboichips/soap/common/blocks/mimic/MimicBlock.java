package yaboichips.soap.common.blocks.mimic;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;
import yaboichips.soap.core.SoapTileEntities;

public class MimicBlock extends BaseEntityBlock {


    public MimicBlock(Properties $$0) {
        super($$0);
    }

    @Override
    public InteractionResult use(BlockState $$0, Level level, BlockPos pos, Player playerIn, InteractionHand $$4, BlockHitResult $$5) {
        if (playerIn instanceof LocalPlayer player) {
            if (level.getBlockEntity(pos) instanceof MimicTE tile) {
                player.minecraft.setScreen(new MimicScreen(tile));
            }
        }
        return super.use($$0, level, pos, playerIn, $$4, $$5);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos pos1, boolean b) {
        if (level.getBlockEntity(pos) instanceof MimicTE tile) {
            if (!level.isClientSide) {
                if (tile.getNamespace() != null && tile.getSound() != null) {
                    ResourceLocation soundLocation = new ResourceLocation(tile.getNamespace(), tile.getSound());
                    if (level.hasNeighborSignal(pos)) {
                        SoundEvent soundEvent = Registry.SOUND_EVENT.get(soundLocation);
                        if (soundEvent != null) {
                            level.playSound(null, pos, soundEvent, SoundSource.BLOCKS, 1, 1);
                        }
                    }
                }
            }
        }
        super.neighborChanged(state, level, pos, block, pos1, b);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, SoapTileEntities.MIMIC, MimicTE::tick);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MimicTE(blockPos, blockState);
    }
}
