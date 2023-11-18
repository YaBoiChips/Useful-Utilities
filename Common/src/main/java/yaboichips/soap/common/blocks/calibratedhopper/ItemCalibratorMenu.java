package yaboichips.soap.common.blocks.calibratedhopper;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import yaboichips.soap.core.SoapMenus;

import java.util.Optional;

public class ItemCalibratorMenu extends AbstractContainerMenu {
    private final Container hopper;
    public final Slot slot;

    public ItemCalibratorMenu(int $$0, Inventory $$1) {
        this($$0, $$1, new SimpleContainer(1));
    }

    public ItemCalibratorMenu(int $$0, Inventory inventory, Container container) {
        super(SoapMenus.CALIBRATED_HOPPER_MENU, $$0);
        this.hopper = container;
        checkContainerSize(container, 1);
        container.startOpen(inventory.player);

        this.slot = this.addSlot(new CalibratedSlot(container, 0, 44 + (2 * 18), 20){
        });

        for (int $$5 = 0; $$5 < 3; ++$$5) {
            for (int $$6 = 0; $$6 < 9; ++$$6) {
                this.addSlot(new Slot(inventory, $$6 + $$5 * 9 + 9, 8 + $$6 * 18, $$5 * 18 + 51));
            }
        }

        for (int $$7 = 0; $$7 < 9; ++$$7) {
            this.addSlot(new Slot(inventory, $$7, 8 + $$7 * 18, 109));
        }
    }

    @Override
    public boolean stillValid(Player $$0) {
        return this.hopper.stillValid($$0);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player $$0, int $$1) {
        ItemStack $$2 = ItemStack.EMPTY;
        Slot $$3 = this.slots.get($$1);
        if ($$3.hasItem()) {
            ItemStack $$4 = $$3.getItem();
            $$2 = $$4.copy();
            if ($$1 < this.hopper.getContainerSize()) {
                if (!this.moveItemStackTo($$4, this.hopper.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo($$4, 0, this.hopper.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if ($$4.isEmpty()) {
                $$3.set(ItemStack.EMPTY);
            } else {
                $$3.setChanged();
            }
        }

        return $$2;
    }

    @Override
    public void removed(@NotNull Player player) {
        super.removed(player);
        this.hopper.stopOpen(player);
    }

    public static class CalibratedSlot extends Slot {

        public CalibratedSlot(Container $$0, int $$1, int $$2, int $$3) {
            super($$0, $$1, $$2, $$3);
        }

        @Override
        public Optional<ItemStack> tryRemove(int $$0, int $$1, Player $$2) {
            return Optional.of(ItemStack.EMPTY);
        }

        @Override
        public @NotNull ItemStack remove(int $$0) {
            if (this.getItem().getCount() > 1) {
                return super.remove($$0);
            }
            else return ItemStack.EMPTY;
        }

    }
}
