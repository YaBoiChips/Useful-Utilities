package yaboichips.soap.core;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import yaboichips.soap.common.blocks.calibratedhopper.ItemCalibratorMenu;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceMenu;
import yaboichips.soap.common.blocks.mason.MasonMenu;
import yaboichips.soap.mixin.access.MenuTypeAccess;
import yaboichips.soap.util.Register;

public class SoapMenus {

    public static final MenuType<MasonMenu> MASON_MENU = registerMenu(MasonMenu::new);
    public static final MenuType<LargeFurnaceMenu> LARGE_FURNACE_MENU = registerMenu(LargeFurnaceMenu::new);
    public static final MenuType<ItemCalibratorMenu> CALIBRATED_HOPPER_MENU = registerMenu(ItemCalibratorMenu::new);


    private static <T extends AbstractContainerMenu> MenuType<T> registerMenu(MenuType.MenuSupplier<T> builder) {
        return MenuTypeAccess.create(builder);
    }

    public static void register(Register<MenuType<?>> menu){
        menu.register("mason", MASON_MENU);
        menu.register("large_furnace", LARGE_FURNACE_MENU);
        menu.register("calibrated_hopper", CALIBRATED_HOPPER_MENU);

    }
}