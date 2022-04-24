package yaboichips.usefulutilities.client.renderers;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import yaboichips.usefulutilities.core.UUBlocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UVCutoutRenders {
    public static void renderCutOuts(Consumer<Map<Block, RenderType>> mapConsumer) {
        Map<Block, RenderType> map = new HashMap<>();

        map.put(UUBlocks.AMETHYST_LANTERN, RenderType.cutoutMipped());
        map.put(UUBlocks.COPPER_CHAIN, RenderType.cutoutMipped());
        map.put(UUBlocks.COPPER_HOPPER, RenderType.cutoutMipped());

        mapConsumer.accept(map);


    }
}
