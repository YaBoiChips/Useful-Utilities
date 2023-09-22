package yaboichips.soap.client.model;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import yaboichips.soap.Soap;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceTE;

public class LargeFurnaceModel<T extends LargeFurnaceTE> extends AnimatedGeoModel<T> {
    @Override
    public ResourceLocation getModelResource(LargeFurnaceTE object) {
        return new ResourceLocation(Soap.MOD_ID, "geo/large_furnace.geo.json");

    }

    @Override
    public ResourceLocation getTextureResource(LargeFurnaceTE object) {
        return new ResourceLocation(Soap.MOD_ID, "textures/block/large_furnace.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LargeFurnaceTE animatable) {
        return null;
    }
}
