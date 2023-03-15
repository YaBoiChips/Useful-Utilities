package yaboichips.soap.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import yaboichips.soap.Soap;
import yaboichips.soap.client.model.GremlinModel;
import yaboichips.soap.common.entities.Gremlin;

public class GremlinRenderer extends GeoEntityRenderer<Gremlin> {
    public GremlinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GremlinModel());
        this.shadowRadius = 0.5F;
    }

    @Override
    public ResourceLocation getTextureLocation(Gremlin instance) {
        return new ResourceLocation(Soap.MOD_ID, "textures/entity/gremlin.png");
    }

    @Override
    public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        if (bone.getName().equals("RArm")) {
            stack.pushPose();
            stack.mulPose(Vector3f.XP.rotationDegrees(15));
            stack.mulPose(Vector3f.YP.rotationDegrees(0));
            stack.mulPose(Vector3f.ZP.rotationDegrees(3f));
            stack.translate(0.033D, 0.38D, -0.45D);
            stack.scale(0.70f, 0.70f, 0.70f);
            Minecraft.getInstance().getItemRenderer().renderStatic(mainHand, ItemTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, packedLightIn, packedOverlayIn, stack, this.rtb, 1);
            stack.popPose();
            bufferIn = rtb.getBuffer(RenderType.entityTranslucent(whTexture));
        }
        super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
