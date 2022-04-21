package yaboichips.usefulutilities.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import yaboichips.usefulutilities.common.entities.DragonsBreathEntity;
import yaboichips.usefulutilities.common.entities.TurtleBoat;
import yaboichips.usefulutilities.util.Register;

public class UUEntities {

    public static final EntityType<DragonsBreathEntity> DRAGON_BREATH = EntityType.Builder.<DragonsBreathEntity>of(DragonsBreathEntity::new, MobCategory.AMBIENT).build("dragons_breath_entity");
    public static final EntityType<TurtleBoat> TURTLE_BOAT = EntityType.Builder.<TurtleBoat>of(TurtleBoat::new, MobCategory.AMBIENT).sized(1.375F, 0.5625F).clientTrackingRange(10).build("turtle_boat");

    public static void register(Register<EntityType<?>> entity){
        entity.register("dragons_breath_entity", DRAGON_BREATH);
        entity.register("turtle_boat", TURTLE_BOAT);
    }
}
