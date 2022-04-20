package corgitaco.modid;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class ModIDFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ModIDBlocks.init((registryObjects) -> registryObjects.forEach(registryObject -> Registry.register(Registry.BLOCK, new ResourceLocation(ModID.MOD_ID, registryObject.id()), registryObject.object())));
        
        ModID.init();
    }
}
