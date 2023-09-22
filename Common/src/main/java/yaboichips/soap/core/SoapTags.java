package yaboichips.soap.core;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class SoapTags {

    public static final TagKey<Block> GLASS = create("glass");



    private static TagKey<Block> create(String string) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(string));
    }
}

