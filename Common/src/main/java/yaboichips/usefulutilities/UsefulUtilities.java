package yaboichips.usefulutilities;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsefulUtilities {
    public static final String MOD_ID = "usefulutilities";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    
    
    public static void init() {
    }

    public static void clientLoad(){
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}