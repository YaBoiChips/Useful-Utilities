package yaboichips.soap;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import yaboichips.soap.common.entities.Gremlin;
import yaboichips.soap.core.*;
import yaboichips.soap.network.FabricNetworkHandler;

import static yaboichips.soap.Soap.createLocation;

public class SoapFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        SoapBlocks.register((name, block) -> Registry.register(Registry.BLOCK, createLocation(name), block));
        SoapTab.init(FabricItemGroupBuilder.build(createLocation(Soap.MOD_ID), () -> new ItemStack(SoapItems.MASON_OVEN)));
        SoapItems.register((name, items) -> Registry.register(Registry.ITEM, createLocation(name), items));
        SoapRecipeTypes.MASON = RecipeType.register("mason");
        SoapEntities.register((name, entityType) -> Registry.register(Registry.ENTITY_TYPE, createLocation(name), entityType));
        SoapMenus.register((name, menus) -> Registry.register(Registry.MENU, createLocation(name), menus));
        SoapRecipeSerializers.register((name, recipeSerializer) -> Registry.register(Registry.RECIPE_SERIALIZER, createLocation(name), recipeSerializer));
        SoapTileEntities.register((name, te) -> Registry.register(Registry.BLOCK_ENTITY_TYPE, createLocation(name), te));
        registerEntityAttributes();
        FabricNetworkHandler.init();
        Soap.init();

    }

    public static void registerEntityAttributes() {
        FabricDefaultAttributeRegistry.register(SoapEntities.GREMLIN, Gremlin.createAttributes());
    }
}
