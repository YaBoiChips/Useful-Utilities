package yaboichips.usefulutilities.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import yaboichips.usefulutilities.common.entities.DragonsBreathEntity;
import yaboichips.usefulutilities.util.Register;

public class UUEntities {

    public static final EntityType<DragonsBreathEntity> DRAGON_BREATH = EntityType.Builder.<DragonsBreathEntity>of(DragonsBreathEntity::new, MobCategory.AMBIENT).build("dragons_breath_entity");

    public static void register(Register<EntityType<?>> entity){
        entity.register("dragons_breath_entity", DRAGON_BREATH);
    }
}
