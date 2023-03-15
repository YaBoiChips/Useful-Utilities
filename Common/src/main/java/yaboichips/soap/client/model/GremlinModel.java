package yaboichips.soap.client.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;
import yaboichips.soap.Soap;
import yaboichips.soap.common.entities.Gremlin;

import javax.annotation.Nullable;

public class GremlinModel extends AnimatedGeoModel<Gremlin> {
    @Override
    public void setLivingAnimations(Gremlin entity, Integer uniqueID, @Nullable AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }

    @Override
    public ResourceLocation getModelResource(Gremlin object) {
        return new ResourceLocation(Soap.MOD_ID, "geo/gremlin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Gremlin object) {
        return new ResourceLocation(Soap.MOD_ID, "textures/entity/gremlin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Gremlin animatable) {
        return new ResourceLocation(Soap.MOD_ID, "animations/gremlin.animation.json");
    }
}
