package yaboichips.soap.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlassCutters extends DiggerItem {

    public GlassCutters(float $$0, float $$1, Tier $$2, TagKey<Block> $$3, Properties $$4) {
        super($$0, $$1, $$2, $$3, $$4);
    }

    @Override
    public boolean mineBlock(ItemStack $$0, Level level, BlockState state, BlockPos pos, LivingEntity $$4) {
        if (state.getBlock() instanceof GlassBlock){
            level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), state.getBlock().asItem().getDefaultInstance()));
        }
        return super.mineBlock($$0, level, state, pos, $$4);
    }
}
