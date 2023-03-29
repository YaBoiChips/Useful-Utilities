package yaboichips.soap;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import yaboichips.soap.client.renderers.SoapRenderers;
import yaboichips.soap.client.renderers.UVCutoutRenders;
import yaboichips.soap.common.entities.DragonsBreathEntity;
import yaboichips.soap.common.entities.Gremlin;
import yaboichips.soap.core.*;

@Mod(Soap.MOD_ID)
public class SoapForge {

    public SoapForge() {
        Soap.init();
        SoapTab.init(new CreativeModeTab("soap.soap") {
            @Override
            public ItemStack makeIcon() {
                return SoapItems.MASON_OVEN.getDefaultInstance();
            }
        });
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        bootStrap(eventBus);
        eventBus.addListener(this::doClientThings);
        eventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientThings(final FMLClientSetupEvent event) {
        UVCutoutRenders.renderCutOuts(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ForgeNetworkHandler::init);
    }

    private void bootStrap(IEventBus eventBus) {
        eventBus.addListener(this::registerBlocks);
        eventBus.addListener(this::registerItems);
        eventBus.addListener(this::registerEntity);
        eventBus.addListener(this::registerMenu);
        eventBus.addListener(this::registerRecipeType);
        eventBus.addListener(this::registerRecipes);
        eventBus.addListener(this::registerBlockEntities);
        eventBus.addListener(this::createEntityAttributes);
        eventBus.addListener(this::registerEntityRenderers);
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event){
        SoapRenderers.register(event::registerEntityRenderer);
    }

    public void createEntityAttributes(final EntityAttributeCreationEvent event) {
        event.put(SoapEntities.GREMLIN, Gremlin.createAttributes().build());
    }

    public void registerBlocks(RegisterEvent event) {
        SoapBlocks.register((name, block) -> event.register(ForgeRegistries.Keys.BLOCKS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerItems(RegisterEvent event) {
        SoapItems.register((name, block) -> event.register(ForgeRegistries.Keys.ITEMS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerEntity(RegisterEvent event) {
        SoapEntities.register((name, block) -> event.register(ForgeRegistries.Keys.ENTITY_TYPES, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerMenu(RegisterEvent event) {
        SoapMenus.register((name, block) -> event.register(ForgeRegistries.Keys.MENU_TYPES, registry -> {
            registry.register(name, block);
        }));
    }
    public void registerRecipeType(RegisterEvent event) {
        SoapRecipeTypes.register((name, recipe) -> event.register(ForgeRegistries.Keys.RECIPE_TYPES, registry -> {
            registry.register(name, recipe);
        }));
    }

    public void registerRecipes(RegisterEvent event) {
        SoapRecipeSerializers.register((name, block) -> event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerBlockEntities(RegisterEvent event) {
        SoapTileEntities.register((name, block) -> event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, registry -> {
            registry.register(name, block);
        }));
    }
}