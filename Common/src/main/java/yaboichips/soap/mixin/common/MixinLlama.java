package yaboichips.soap.mixin.common;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.horse.AbstractChestedHorse;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import yaboichips.soap.core.SoapItems;

@Mixin(Llama.class)
public class MixinLlama extends AbstractChestedHorse {

    protected MixinLlama(EntityType<? extends AbstractChestedHorse> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() == Items.GLASS_BOTTLE) {
            turnBottleIntoPot(stack, player, SoapItems.LLAMA_SPIT.getDefaultInstance());
            player.level.playSound(player, player.blockPosition(), SoundEvents.LLAMA_SPIT, SoundSource.NEUTRAL, 0.5F, 0.5F);
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private ItemStack turnBottleIntoPot(ItemStack stack, Player player, ItemStack result) {
        player.awardStat(Stats.ITEM_USED.get(player.getMainHandItem().getItem()));
        return ItemUtils.createFilledResult(stack, player, result);
    }
}
