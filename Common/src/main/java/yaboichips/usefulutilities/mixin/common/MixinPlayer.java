package yaboichips.usefulutilities.mixin.common;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import yaboichips.usefulutilities.core.UUItems;

@Mixin(Player.class)
public class MixinPlayer extends LivingEntity {

    protected MixinPlayer(EntityType<? extends LivingEntity> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "eat", at = @At("RETURN"))
    public void doNightVision(Level world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir){
        ItemStack item = this.getMainHandItem();
        if (item.is(Items.GLOW_BERRIES) && this.getItemBySlot(EquipmentSlot.HEAD).is(UUItems.COPPER_HELMET) && !this.hasEffect(MobEffects.NIGHT_VISION)) {
            this.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 1, false, false));
            this.level.playSound(null, this.blockPosition(), SoundEvents.BEACON_POWER_SELECT, SoundSource.NEUTRAL, 1, 1);
        }
    }

    @Shadow
    public Iterable<ItemStack> getArmorSlots() {
        throw new IllegalStateException("Mixin failed to shadow getArmorSlots()");
    }

    @Shadow
    public ItemStack getItemBySlot(EquipmentSlot var1) {
        throw new IllegalStateException("Mixin failed to shadow getItemBySlot()");
    }

    @Shadow
    public void setItemSlot(EquipmentSlot var1, ItemStack var2) {
        throw new IllegalStateException("Mixin failed to shadow setItemSlot()");

    }

    @Shadow
    public HumanoidArm getMainArm() {
        throw new IllegalStateException("Mixin failed to shadow getMainArm()");
    }
}
