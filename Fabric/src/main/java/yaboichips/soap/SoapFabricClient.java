package yaboichips.soap;

import net.fabricmc.api.ClientModInitializer;
import yaboichips.soap.client.renderers.SoapRenderers;
import yaboichips.soap.client.renderers.UVCutoutRenders;
import yaboichips.soap.mixin.access.AccessEntityRenderers;
import yaboichips.soap.mixin.client.ItemBlockRenderTypeAccess;

public class SoapFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UVCutoutRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));
        SoapRenderers.register(AccessEntityRenderers::register);
    }
}
