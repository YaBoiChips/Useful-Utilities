package yaboichips.soap;

import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Soap {
    public static final String MOD_ID = "soap";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
    }

    public static void clientLoad() {
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}