package yaboichips.soap.common.entities;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import yaboichips.soap.common.items.PieLauncher;
import yaboichips.soap.core.SoapEntities;

public class PieProjectile extends ThrowableItemProjectile {

    public PieLauncher launcher;

    public PieProjectile(EntityType<? extends ThrowableItemProjectile> $$0, Level $$1) {
        super($$0, $$1);
    }

    public PieProjectile(Level $$0, LivingEntity $$1) {
        super(SoapEntities.PIE, $$1, $$0);
    }

    public PieProjectile(PieLauncher launcher, Level $$2, LivingEntity $$1){
        super(SoapEntities.PIE, $$1, $$2);
        this.launcher = launcher;
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }


    private ParticleOptions getParticle() {
        ItemStack $$0 = this.getItemRaw();
        return $$0.isEmpty() ? ParticleTypes.DRIPPING_LAVA : new ItemParticleOption(ParticleTypes.ITEM, $$0);
    }

    public void handleEntityEvent(byte $$0) {
        if ($$0 == 3) {
            ParticleOptions $$1 = this.getParticle();
            for(int $$2 = 0; $$2 < 8; ++$$2) {
                this.level.addParticle($$1, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult $$0) {
        super.onHitEntity($$0);
        Entity $$1 = $$0.getEntity();
        $$1.hurt(DamageSource.thrown(this, this.getOwner()), 1f);
    }

    protected void onHit(HitResult $$0) {
        super.onHit($$0);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }
}
