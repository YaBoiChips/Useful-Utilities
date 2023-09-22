package yaboichips.soap.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;
import yaboichips.soap.client.model.LargeFurnaceModel;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceTE;

public class LargeFurnaceTERendererForge extends GeoBlockRenderer<LargeFurnaceTE> {

    public LargeFurnaceTERendererForge(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new LargeFurnaceModel<>());
    }

    @Override
    public RenderType getRenderType(LargeFurnaceTE animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        return RenderType.entityTranslucent(getTextureLocation(animatable));
    }

    @Override
    public void render(@NotNull BlockEntity blockEntity, float v, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int i, int i1) {
        this.render((LargeFurnaceTE) blockEntity, v, poseStack, multiBufferSource, i);
    }
}
