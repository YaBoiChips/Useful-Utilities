package yaboichips.soap;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import yaboichips.soap.client.LargeFurnaceTERenderer;
import yaboichips.soap.client.renderers.SoapRenderers;
import yaboichips.soap.client.renderers.UVCutoutRenders;
import yaboichips.soap.core.SoapTileEntities;
import yaboichips.soap.mixin.access.AccessEntityRenderers;
import yaboichips.soap.mixin.client.ItemBlockRenderTypeAccess;

public class SoapFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UVCutoutRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));
        SoapRenderers.register(AccessEntityRenderers::register);
        BlockEntityRendererRegistry.register(SoapTileEntities.LARGE_FURNACE,
                (BlockEntityRendererProvider.Context rendererDispatcherIn) -> new LargeFurnaceTERenderer());

    }
}
