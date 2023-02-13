package yaboichips.usefulutilities;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class UsefulUtilities {
    public static final String MOD_ID = "usefulutilities";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
    }

    public static void clientLoad() {
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

}