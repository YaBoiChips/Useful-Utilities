package yaboichips.soap.mixin.common;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.ZombieVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Zombie.class)
public class MixinZombie extends Monster {
    public MixinZombie(EntityType<? extends Monster> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand $$1) {
        ItemStack stack = player.getMainHandItem();
        if (this.getType() == EntityType.ZOMBIE) {
            if (stack.getItem() == Items.POISONOUS_POTATO) {
                Level world = player.level;
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                world.playSound(null, this, SoundEvents.GENERIC_EAT, SoundSource.AMBIENT, 1, 1);
                int i = player.getRandom().nextInt(5);
                if (i == 3) {
                    if (!world.isClientSide) {
                        ZombieVillager zv = EntityType.ZOMBIE_VILLAGER.create(world);
                        zv.moveTo(this.position());
                        zv.setPos(this.position());
                        zv.setBaby(this.isBaby());
                        world.playSound(null, this, SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.AMBIENT, 1, 1);
                        world.addFreshEntity(zv);
                        this.remove(Entity.RemovalReason.DISCARDED);
                    }
                }
            }
        }
        return InteractionResult.SUCCESS;
    }
}
