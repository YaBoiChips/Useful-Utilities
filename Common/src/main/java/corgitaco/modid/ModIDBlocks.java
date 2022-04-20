package corgitaco.modid;

import corgitaco.modid.util.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class ModIDBlocks {
    
    private static final Collection<RegistryObject<Block>> BLOCKS = new ArrayList<>();
    
    public static final Block BLOCK_1 = register(new Block(BlockBehaviour.Properties.of(Material.CACTUS)), "block1");
    
    private static <T extends Block> T register(T block, String id) {
        BLOCKS.add(new RegistryObject<>(block, id));
        return block;
    }
    
    public static void init(Consumer<Collection<RegistryObject<Block>>> registryStrategy) {
        registryStrategy.accept(BLOCKS);
    }
}