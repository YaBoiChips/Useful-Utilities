package yaboichips.soap.common.blocks.large_furnace;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.BlastingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class LargeFurnaceScreen extends AbstractFurnaceScreen<LargeFurnaceMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/blast_furnace.png");

    public LargeFurnaceScreen(LargeFurnaceMenu menu, Inventory inv, Component string) {
        super(menu, new BlastingRecipeBookComponent(), inv, string, TEXTURE);
    }
}
