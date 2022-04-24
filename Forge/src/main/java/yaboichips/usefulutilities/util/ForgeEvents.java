package yaboichips.usefulutilities.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yaboichips.usefulutilities.common.entities.TurtleBoat;
import yaboichips.usefulutilities.core.UUItems;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public void makeZombieVillager(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getPlayer();
        if (event.getTarget() instanceof Zombie zombie) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == Items.POISONOUS_POTATO) {
                Level world = player.level;
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                world.playSound(null, zombie, SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 1 ,1);
                int i = player.getRandom().nextInt(5);
                if (i == 3) {
                    ZombieVillager zv = EntityType.ZOMBIE_VILLAGER.create(world);
                    zv.setPos(zombie.position());
                    zv.setBaby(zombie.isBaby());
                    world.playSound(null, zombie, SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.AMBIENT, 1 ,1);
                    world.addFreshEntity(zv);
                    zombie.remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }
    }

    @SubscribeEvent
    public void doNightVision(LivingEntityUseItemEvent.Finish event) {
        if (event.getEntityLiving() instanceof Player player) {
            if (event.getResultStack().getItem() == Items.GLOW_BERRIES) {
                if (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == UUItems.COPPER_HELMET && !player.hasEffect(MobEffects.NIGHT_VISION)) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1000, 1, false, false));
                    player.level.playSound(player, player.blockPosition(), SoundEvents.BEACON_POWER_SELECT, SoundSource.NEUTRAL, 1, 1);
                }
            }
        }
    }

    @SubscribeEvent
    public void doLlamaSpit(PlayerInteractEvent.EntityInteract event) {
        Player player = event.getPlayer();
        if (event.getTarget() instanceof Llama) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == Items.GLASS_BOTTLE) {
                turnBottleIntoPot(stack, player, UUItems.LLAMA_SPIT.getDefaultInstance());
                player.level.playSound(player, player.blockPosition(), SoundEvents.LLAMA_SPIT, SoundSource.NEUTRAL, 0.5F, 0.5F);
            }
        }
        if (event.getTarget() instanceof Boat boat) {
            ItemStack stack = player.getMainHandItem();
            if (stack.getItem() == Items.SCUTE) {
                Level world = boat.level;
                TurtleBoat turtleBoat = new TurtleBoat(world, boat.getX(), boat.getY(), boat.getZ());
                turtleBoat.setModBoatType(turtleBoat.getTypeFromVanilla(boat.getBoatType()));
                turtleBoat.setYRot(boat.getYRot());
                world.addFreshEntity(turtleBoat);
                boat.remove(Entity.RemovalReason.DISCARDED);
                stack.shrink(1);
            }
        }
    }

    private ItemStack turnBottleIntoPot(ItemStack stack, Player player, ItemStack result) {
        player.awardStat(Stats.ITEM_USED.get(player.getMainHandItem().getItem()));
        return ItemUtils.createFilledResult(stack, player, result);
    }
}
