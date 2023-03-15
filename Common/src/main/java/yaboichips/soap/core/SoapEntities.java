package yaboichips.soap.core;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import yaboichips.soap.common.entities.DragonsBreathEntity;
import yaboichips.soap.common.entities.Gremlin;
import yaboichips.soap.util.Register;

public class SoapEntities {

    public static final EntityType<DragonsBreathEntity> DRAGON_BREATH = EntityType.Builder.<DragonsBreathEntity>of(DragonsBreathEntity::new, MobCategory.AMBIENT).build("dragons_breath_entity");
    public static final EntityType<Gremlin> GREMLIN = EntityType.Builder.of(Gremlin::new, MobCategory.MISC).sized(0.5F, 1F).build("gremlin");

    public static void register(Register<EntityType<?>> entity){
        entity.register("dragons_breath_entity", DRAGON_BREATH);
        entity.register("gremlin", GREMLIN);
    }
}
