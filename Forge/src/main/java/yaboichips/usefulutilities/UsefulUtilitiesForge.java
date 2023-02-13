package yaboichips.usefulutilities;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import yaboichips.usefulutilities.client.renderers.UVCutoutRenders;
import yaboichips.usefulutilities.core.*;

@Mod(UsefulUtilities.MOD_ID)
public class UsefulUtilitiesForge {

    public UsefulUtilitiesForge() {
        UsefulUtilities.init();
        UUTab.init(new CreativeModeTab("usefulutilities.usefulutilities") {
            @Override
            public ItemStack makeIcon() {
                return UUItems.MASON_OVEN.getDefaultInstance();
            }
        });
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::doClientThings);
        bootStrap(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientThings(final FMLClientSetupEvent event) {
        UVCutoutRenders.renderCutOuts(blockRenderTypeMap -> blockRenderTypeMap.forEach(ItemBlockRenderTypes::setRenderLayer));
    }

    private void bootStrap(IEventBus eventBus) {
        eventBus.addListener(this::registerBlocks);
        eventBus.addListener(this::registerItems);
        eventBus.addListener(this::registerEntity);
        eventBus.addListener(this::registerMenu);
        eventBus.addListener(this::registerRecipeType);
        eventBus.addListener(this::registerRecipes);
        eventBus.addListener(this::registerBlockEntities);
    }

    public void registerBlocks(RegisterEvent event) {
        UUBlocks.register((name, block) -> event.register(ForgeRegistries.Keys.BLOCKS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerItems(RegisterEvent event) {
        UUItems.register((name, block) -> event.register(ForgeRegistries.Keys.ITEMS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerEntity(RegisterEvent event) {
        UUEntities.register((name, block) -> event.register(ForgeRegistries.Keys.ENTITY_TYPES, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerMenu(RegisterEvent event) {
        UUMenus.register((name, block) -> event.register(ForgeRegistries.Keys.MENU_TYPES, registry -> {
            registry.register(name, block);
        }));
    }
    public void registerRecipeType(RegisterEvent event) {
        UURecipeTypes.register((name, recipe) -> event.register(ForgeRegistries.Keys.RECIPE_TYPES, registry -> {
            registry.register(name, recipe);
        }));
    }

    public void registerRecipes(RegisterEvent event) {
        UURecipeSerializers.register((name, block) -> event.register(ForgeRegistries.Keys.RECIPE_SERIALIZERS, registry -> {
            registry.register(name, block);
        }));
    }

    public void registerBlockEntities(RegisterEvent event) {
        UUTileEntities.register((name, block) -> event.register(ForgeRegistries.Keys.BLOCK_ENTITY_TYPES, registry -> {
            registry.register(name, block);
        }));
    }
}