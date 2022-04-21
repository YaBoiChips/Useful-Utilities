package yaboichips.usefulutilities.mixin.access;

import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Boat.class)
public interface BoatEntityAccess {

    @Accessor
    void setLastYd(double lastYd);

    @Accessor("status")
    Boat.Status getStatusField();

    @Accessor
    boolean getInputLeft();

    @Accessor
    boolean getInputRight();

    @Accessor
    boolean getInputUp();

    @Accessor
    boolean getInputDown();

    @Accessor
    float getDeltaRotation();

    @Accessor
    void setDeltaRotation(float deltaRotation);

    @Invoker("floatBoat")
    void floatBoat();
}

