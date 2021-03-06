package yaboichips.usefulutilities;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import yaboichips.usefulutilities.core.*;

import static yaboichips.usefulutilities.UsefulUtilities.createLocation;

public class UsefulUtilitiesFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        UUBlocks.register((name, block) -> Registry.register(Registry.BLOCK, createLocation(name), block));
        UUTab.init(FabricItemGroupBuilder.build(createLocation(UsefulUtilities.MOD_ID), () -> new ItemStack(UUItems.MASON_OVEN)));
        UUItems.register((name, items) -> Registry.register(Registry.ITEM, createLocation(name), items));
        UURecipeTypes.MASON = RecipeType.register("mason");
        UUEntities.register((name, entityType) -> Registry.register(Registry.ENTITY_TYPE, createLocation(name), entityType));
        UUMenus.register((name, menus) -> Registry.register(Registry.MENU, createLocation(name), menus));
        UURecipeSerializers.register((name, recipeSerializer) -> Registry.register(Registry.RECIPE_SERIALIZER, createLocation(name), recipeSerializer));
        UUTileEntities.register((name, te) -> Registry.register(Registry.BLOCK_ENTITY_TYPE, createLocation(name), te));


        UsefulUtilities.init();
    }


}
