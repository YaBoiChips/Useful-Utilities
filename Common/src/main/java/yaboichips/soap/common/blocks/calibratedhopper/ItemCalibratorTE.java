package yaboichips.soap.common.blocks.calibratedhopper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yaboichips.soap.core.SoapTileEntities;

import java.util.stream.IntStream;

public class ItemCalibratorTE extends RandomizableContainerBlockEntity implements WorldlyContainer {
    private NonNullList<ItemStack> items;

    public ItemCalibratorTE(BlockPos blockPos, BlockState blockState) {
        super(SoapTileEntities.ITEM_CALIBRATOR, blockPos, blockState);
        this.items = NonNullList.withSize(1, ItemStack.EMPTY);
    }


    @Override
    public void load(@NotNull CompoundTag $$0) {
        super.load($$0);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable($$0)) {
            ContainerHelper.loadAllItems($$0, this.items);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag $$0) {
        super.saveAdditional($$0);
        if (!this.trySaveLootTable($$0)) {
            ContainerHelper.saveAllItems($$0, this.items);
        }
    }


    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> stacks) {
        this.items = stacks;
    }


    public int getContainerSize() {
        return 1;
    }


    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.item_calibrator");
    }


    @Override
    protected @NotNull AbstractContainerMenu createMenu(int i, @NotNull Inventory inv) {
        return new ItemCalibratorMenu(i, inv, this);
    }

    @Override
    public int @NotNull [] getSlotsForFace(Direction direction) {
        return new int[]{0};
    }


    @Override
    public boolean canPlaceItemThroughFace(int var1, ItemStack var2, @Nullable Direction var3) {
        return true;
    }

    @Override
    public boolean canTakeItemThroughFace(int var1, ItemStack stack, Direction var3) {
        return true;
    }

}
