package corgitaco.modid.mixin;

import corgitaco.modid.ModID;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ServerChunkEvents.class, remap = false)
public class MixinFabricExample {
    
    @Inject(method = "lambda$static$0([Lnet/fabricmc/fabric/api/event/lifecycle/v1/ServerChunkEvents$Load;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/chunk/LevelChunk;)V", at = @At("HEAD"), remap = true)
    private static void example(CallbackInfo ci) {
        ModID.LOGGER.info("Hello from Fabric's Chunk Load Event!");
    }
}
