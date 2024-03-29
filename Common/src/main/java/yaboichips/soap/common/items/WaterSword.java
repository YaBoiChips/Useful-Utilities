package yaboichips.soap.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import yaboichips.soap.util.SoapConstants;

public class WaterSword extends SwordItem {
    public WaterSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int i = target.getRandom().nextInt(10);
        if (i >= 9) {
            if (attacker.isInWaterOrRain()) {
                target.push(0, -1.3, 0);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (playerIn.isInWater()) {
            if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
                SoapConstants.pushLooking(playerIn, 5.2f);
                playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 30);
                playerIn.startAutoSpinAttack(20);
                worldIn.playSound(playerIn, playerIn.blockPosition(), SoundEvents.TRIDENT_RIPTIDE_3, SoundSource.AMBIENT, 1.0f, 1.0f);
            }
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }
}