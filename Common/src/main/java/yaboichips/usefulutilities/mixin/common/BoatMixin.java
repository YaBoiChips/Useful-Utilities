package yaboichips.usefulutilities.mixin.common;


import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import yaboichips.usefulutilities.common.CustomBoat;

@Mixin(Boat.class)
public abstract class BoatMixin implements CustomBoat {

}
