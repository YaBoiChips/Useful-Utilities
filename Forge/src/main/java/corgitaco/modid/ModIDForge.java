package corgitaco.modid;

import corgitaco.modid.util.RegistryObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.Collection;

@Mod(ModID.MOD_ID)
public class ModIDForge {

    public ModIDForge() {
        ModID.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModIDBlocks.init(blockObjects -> {
            eventBus.addGenericListener(Block.class, (RegistryEvent.Register<Block> event) -> register(event, blockObjects));
        });
    }

    private <T extends IForgeRegistryEntry<T>> void register(RegistryEvent.Register<T> event, Collection<RegistryObject<T>> collection) {
        for (RegistryObject<T> registryObject : collection) {
            event.getRegistry().register(registryObject.object().setRegistryName(new ResourceLocation(ModID.MOD_ID, registryObject.id())));
        }
    }
}