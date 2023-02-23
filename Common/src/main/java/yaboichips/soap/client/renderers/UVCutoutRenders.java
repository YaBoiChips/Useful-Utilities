package yaboichips.soap.client.renderers;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import yaboichips.soap.core.SoapBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UVCutoutRenders {
    public static void renderCutOuts(Consumer<Map<Block, RenderType>> mapConsumer) {
        Map<Block, RenderType> map = new HashMap<>();

        map.put(SoapBlocks.AMETHYST_LANTERN, RenderType.cutoutMipped());
        map.put(SoapBlocks.COPPER_CHAIN, RenderType.cutoutMipped());
        map.put(SoapBlocks.COPPER_HOPPER, RenderType.cutoutMipped());

        mapConsumer.accept(map);


    }
}
