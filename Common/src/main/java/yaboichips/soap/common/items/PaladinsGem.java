package yaboichips.soap.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PaladinsGem extends Item {
    public PaladinsGem(Properties $$0) {
        super($$0);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(@NotNull final Level world, @NotNull final Player player, @NotNull final InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.getCooldowns().addCooldown(this, 1000);
        world.playSound(player, player.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.NEUTRAL, 1, 1);
        if (!world.isClientSide){
            for(MobEffectInstance effect : player.getActiveEffects()){
                if (effect.getEffect().getCategory().equals(MobEffectCategory.HARMFUL)){
                    player.removeEffect(effect.getEffect());
                }
            }
        }
        return InteractionResultHolder.success(stack);
    }
}
