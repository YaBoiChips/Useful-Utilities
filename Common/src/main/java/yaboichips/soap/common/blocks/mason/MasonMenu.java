package yaboichips.soap.common.blocks.mason;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import yaboichips.soap.core.SoapMenus;
import yaboichips.soap.core.SoapRecipeTypes;

public class MasonMenu extends AbstractFurnaceMenu {
    public MasonMenu(int slot, Inventory inv) {
        super(SoapMenus.MASON_MENU, SoapRecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv);
    }

    public MasonMenu(int slot, Inventory inv, Container container, ContainerData data) {
        super(SoapMenus.MASON_MENU, SoapRecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv, container, data);
    }
}
