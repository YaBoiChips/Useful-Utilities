package corgitaco.modid.mixin;

import corgitaco.modid.ModID;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MixinCommonExample {
    
    @Inject(method = "createLevels", at = @At("HEAD"))
    private void example(CallbackInfo ci) {
        ModID.LOGGER.info("Hello from create levels!");
    }
    
}
