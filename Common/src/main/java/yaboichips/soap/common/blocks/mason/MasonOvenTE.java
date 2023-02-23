package yaboichips.soap.common.blocks.mason;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import yaboichips.soap.core.SoapRecipeTypes;
import yaboichips.soap.core.SoapTileEntities;


public class MasonOvenTE extends AbstractFurnaceBlockEntity {
    public MasonOvenTE(BlockPos pos, BlockState state) {
        super(SoapTileEntities.MASON_OVEN, pos, state, SoapRecipeTypes.MASON);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.mason_oven");
    }

    protected int getBurnDuration(final ItemStack stack) {
        return super.getBurnDuration(stack) / 2;
    }

    @Override
    protected AbstractContainerMenu createMenu(int slot, Inventory inv) {
        return new MasonMenu(slot, inv, this, this.dataAccess);
    }
}
