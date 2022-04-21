package yaboichips.usefulutilities.core;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import yaboichips.usefulutilities.common.MasonRecipe;
import yaboichips.usefulutilities.util.Register;


public class UURecipeSerializers {


    public static final RecipeSerializer<MasonRecipe> MASON = new SimpleCookingSerializer<>(MasonRecipe::new, 100);


    public static void register(Register<RecipeSerializer<?>> recipe){
        recipe.register("mason", MASON);
    }
}
