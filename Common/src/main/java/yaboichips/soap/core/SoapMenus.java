package yaboichips.soap.core;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import yaboichips.soap.common.blocks.mason.MasonMenu;
import yaboichips.soap.mixin.access.MenuTypeAccess;
import yaboichips.soap.util.Register;

public class SoapMenus {

    public static final MenuType<MasonMenu> MASON_MENU = registerMenu(MasonMenu::new);


    private static <T extends AbstractContainerMenu> MenuType<T> registerMenu(MenuType.MenuSupplier<T> builder) {
        return MenuTypeAccess.create(builder);
    }

    public static void register(Register<MenuType<?>> menu){
        menu.register("mason", MASON_MENU);
    }
}