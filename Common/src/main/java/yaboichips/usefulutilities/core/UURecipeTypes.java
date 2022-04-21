package yaboichips.usefulutilities.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import yaboichips.usefulutilities.common.MasonRecipe;
import yaboichips.usefulutilities.mixin.access.RecipeManagerAccess;

import java.util.Map;

public class UURecipeTypes {

    public static RecipeType<MasonRecipe> MASON = null;

    public static <C extends Container, T extends Recipe<C>> Map<ResourceLocation, Recipe<C>> getRecipes(Level world, RecipeType<T> type) {
        return ((RecipeManagerAccess) world.getRecipeManager()).getUVRecipes(type);
    }
}

