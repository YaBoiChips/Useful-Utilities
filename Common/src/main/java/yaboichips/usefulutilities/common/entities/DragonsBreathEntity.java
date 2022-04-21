package yaboichips.usefulutilities.common.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class DragonsBreathEntity extends ThrownPotion {
    public DragonsBreathEntity(EntityType<? extends DragonsBreathEntity> type, Level world) {
        super(type, world);
    }

    public DragonsBreathEntity(Level world, LivingEntity owner) {
        super(world, owner);
    }


    @Override
    protected void onHitBlock(BlockHitResult p_37541_) {
        super.onHitBlock(p_37541_);
        this.makeEffectCloud();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        this.makeEffectCloud();
    }

    public void makeEffectCloud() {
        AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level, this.getX(), this.getY(), this.getZ());
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            areaeffectcloud.setOwner((LivingEntity)entity);
        }
        areaeffectcloud.setParticle(ParticleTypes.DRAGON_BREATH);
        areaeffectcloud.setRadius(3.0F);
        areaeffectcloud.setDuration(600);
        areaeffectcloud.setRadiusPerTick((7.0F - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
        areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
        this.level.addFreshEntity(areaeffectcloud);
    }
}
