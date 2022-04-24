package yaboichips.usefulutilities;

import net.fabricmc.api.ClientModInitializer;
import yaboichips.usefulutilities.client.renderers.UVCutoutRenders;
import yaboichips.usefulutilities.mixin.client.ItemBlockRenderTypeAccess;

public class UsefulUtilitiesFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        UVCutoutRenders.renderCutOuts(blockRenderTypeMap -> ItemBlockRenderTypeAccess.getTYPE_BY_BLOCK().putAll(blockRenderTypeMap));

    }
}
