package yaboichips.soap.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Blocks;
import yaboichips.soap.core.SoapRecipeSerializers;
import yaboichips.soap.core.SoapRecipeTypes;


public class LargeFurnaceRecipe extends AbstractCookingRecipe {
    public LargeFurnaceRecipe(RecipeType<LargeFurnaceRecipe> largeFurnace, ResourceLocation location, String id, Ingredient ingredient, ItemStack result, float p_43797_, int p_43798_) {
        super(SoapRecipeTypes.LARGE_FURNACE, location, id, ingredient, result, p_43797_, p_43798_);
    }

    public LargeFurnaceRecipe(ResourceLocation resourceLocation, String s, Ingredient ingredient, ItemStack itemStack, float v, int i) {
        this(SoapRecipeTypes.LARGE_FURNACE, resourceLocation, s, ingredient, itemStack, v, i);

    }

    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.FURNACE);
    }

    public RecipeSerializer<?> getSerializer() {
        return SoapRecipeSerializers.LARGE_FURNACE;
    }
}
