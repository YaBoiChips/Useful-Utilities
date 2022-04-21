package yaboichips.usefulutilities.util.jei;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import yaboichips.usefulutilities.UsefulUtilities;
import yaboichips.usefulutilities.common.blocks.mason.MasonMenu;
import yaboichips.usefulutilities.core.UUBlocks;
import yaboichips.usefulutilities.core.UURecipeTypes;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;


@JeiPlugin
public class JEIIntegration implements IModPlugin {

    private static final Comparator<Recipe<?>> BY_ID = Comparator.comparing(Recipe::getId);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(UsefulUtilities.MOD_ID, "main");
    }

    private static <T extends Recipe<C>, C extends Container> Collection<T> sortRecipes(RecipeType<T> type, Comparator<? super T> comparator) {
        @SuppressWarnings("unchecked")
        Collection<T> recipes = (Collection<T>) UURecipeTypes.getRecipes(Minecraft.getInstance().level, type).values();
        List<T> list = new ArrayList<>(recipes);
        list.sort(comparator);
        return list;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(sortRecipes(UURecipeTypes.MASON, BY_ID), MasonRecipeCategory.UID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IJeiHelpers jeiHelpers = registration.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
        registration.addRecipeCategories(
                new MasonRecipeCategory(guiHelper, 100));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(UUBlocks.MASON_OVEN), MasonRecipeCategory.UID);
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(MasonMenu.class, MasonRecipeCategory.UID, 0, 1, 3, 36);

    }
}
