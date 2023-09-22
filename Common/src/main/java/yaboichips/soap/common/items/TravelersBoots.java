package yaboichips.soap.common.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TravelersBoots extends ArmorItem {
    public TravelersBoots(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int $$3, boolean $$4) {
        if (entity instanceof Player player) {
            if (player.getItemBySlot(EquipmentSlot.FEET) == stack) {
                if (player.isSprinting()) {
                    player.maxUpStep = 1.0f;
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, 1, false, false, false));
                }
                else {
                    player.maxUpStep = 0.6f;
                }
            }
            super.inventoryTick(stack, level, player, $$3, $$4);
        }
    }
}
