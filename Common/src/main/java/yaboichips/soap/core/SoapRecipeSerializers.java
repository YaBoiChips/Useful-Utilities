package yaboichips.soap.core;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import yaboichips.soap.common.LargeFurnaceRecipe;
import yaboichips.soap.common.MasonRecipe;
import yaboichips.soap.util.Register;


public class SoapRecipeSerializers {


    public static final RecipeSerializer<MasonRecipe> MASON = new SimpleCookingSerializer<>(MasonRecipe::new, 100);
    public static final RecipeSerializer<LargeFurnaceRecipe> LARGE_FURNACE = new SimpleCookingSerializer<LargeFurnaceRecipe>(LargeFurnaceRecipe::new, 100);


    public static void register(Register<RecipeSerializer<?>> recipe){
        recipe.register("mason", MASON);
        recipe.register("large_furnace", LARGE_FURNACE);
    }
}
