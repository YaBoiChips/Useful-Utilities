package yaboichips.usefulutilities.common.blocks.mason;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import yaboichips.usefulutilities.core.UUMenus;
import yaboichips.usefulutilities.core.UURecipeTypes;

public class MasonMenu extends AbstractFurnaceMenu {
    public MasonMenu(int slot, Inventory inv) {
        super(UUMenus.MASON_MENU, UURecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv);
    }

    public MasonMenu(int slot, Inventory inv, Container container, ContainerData data) {
        super(UUMenus.MASON_MENU, UURecipeTypes.MASON, RecipeBookType.BLAST_FURNACE, slot, inv, container, data);
    }
}
