package yaboichips.soap.common.blocks.large_furnace;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import yaboichips.soap.core.SoapMenus;
import yaboichips.soap.core.SoapRecipeTypes;

public class LargeFurnaceMenu extends AbstractFurnaceMenu {
    public LargeFurnaceMenu(int slot, Inventory inv) {
        super(SoapMenus.LARGE_FURNACE_MENU, SoapRecipeTypes.LARGE_FURNACE, RecipeBookType.FURNACE, slot, inv);
    }

    public LargeFurnaceMenu(int slot, Inventory inv, Container container, ContainerData data) {
        super(SoapMenus.LARGE_FURNACE_MENU, SoapRecipeTypes.LARGE_FURNACE, RecipeBookType.FURNACE, slot, inv, container, data);
    }
}
