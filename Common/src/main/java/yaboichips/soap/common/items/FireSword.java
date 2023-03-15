package yaboichips.soap.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class FireSword extends SwordItem {
    public FireSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (playerIn.isOnGround()) {
            if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
                BlockPos pos = playerIn.blockPosition();
                float f = (float) Math.min(6, 3);
                for (BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-f, 0.0, -f), pos.offset(f, 0.0, f))) {
                    if (BlockPos.betweenClosed(pos.offset(-f, -1.0, -f), pos.offset(f, -1.0, f)) != Blocks.AIR) {
                        BlockState blockstate = playerIn.level.getBlockState(blockpos);
                        if (blockstate == Blocks.AIR.defaultBlockState() || blockstate == Blocks.GRASS.defaultBlockState() || blockstate == Blocks.TALL_GRASS.defaultBlockState())
                            worldIn.setBlockAndUpdate(blockpos, Blocks.FIRE.defaultBlockState());
                        playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 220);
                        SoundEvent soundevent = SoundEvents.FIRECHARGE_USE;
                        worldIn.playSound(playerIn, playerIn.blockPosition(), soundevent, SoundSource.AMBIENT, 0.5f, 1.0f);
                    }
                }
            }
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setSecondsOnFire(6);
        return super.hurtEnemy(stack, target, attacker);
    }
}
