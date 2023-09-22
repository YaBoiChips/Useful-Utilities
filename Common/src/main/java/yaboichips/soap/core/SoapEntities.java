package yaboichips.soap.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.Snowball;
import yaboichips.soap.common.entities.DragonsBreathEntity;
import yaboichips.soap.common.entities.Gremlin;
import yaboichips.soap.common.entities.PieProjectile;
import yaboichips.soap.util.Register;

public class SoapEntities {

    public static final EntityType<DragonsBreathEntity> DRAGON_BREATH = EntityType.Builder.<DragonsBreathEntity>of(DragonsBreathEntity::new, MobCategory.AMBIENT).build("dragons_breath_entity");
    public static final EntityType<Gremlin> GREMLIN = EntityType.Builder.of(Gremlin::new, MobCategory.MISC).sized(0.5F, 1F).build("gremlin");
    public static final EntityType<PieProjectile> PIE = EntityType.Builder.<PieProjectile>of(PieProjectile::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10).build("pie_projectile");


    public static void register(Register<EntityType<?>> entity){
        entity.register("dragons_breath_entity", DRAGON_BREATH);
        entity.register("gremlin", GREMLIN);
        entity.register("pie_projectile", PIE);
    }
}
