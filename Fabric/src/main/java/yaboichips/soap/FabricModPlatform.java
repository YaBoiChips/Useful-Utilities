package yaboichips.soap;

import com.google.auto.service.AutoService;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import yaboichips.soap.common.network.SoapServer2ClientPacket;
import yaboichips.soap.network.FabricNetworkHandler;
import yaboichips.soap.util.ModPlatform;

import java.nio.file.Path;

@AutoService(ModPlatform.class)
public class FabricModPlatform implements ModPlatform {
    public static final Event<TagsUpdatedEvent> TAGS_UPDATED_EVENT = EventFactory.createArrayBacked(TagsUpdatedEvent.class, callbacks -> world -> {
        for (final var sub : callbacks) {
            sub.onTagsUpdated(world);
        }
    });

    @Override
    public Path configPath() {
        return FabricLoader.getInstance().getConfigDir().resolve(Soap.MOD_ID);
    }

    @Override
    public boolean isModLoaded(String isLoaded) {
        return FabricLoader.getInstance().isModLoaded(isLoaded);
    }

    @Override
    public <P extends SoapServer2ClientPacket> void sendToClient(ServerPlayer player, P packet) {
        FabricNetworkHandler.sendToPlayer(player, packet);
    }

    @Override
    public <P extends SoapServer2ClientPacket> void sendToServer(P packet) {
        FabricNetworkHandler.sendToServer(packet);
    }

    @Override
    public boolean isClientEnvironment() {
        return FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT;
    }

    @Override
    public Platform modPlatform() {
        return Platform.FABRIC;
    }

    @Override
    public boolean hasLoadErrors() {
        return false;
    }

    @Override
    public void addTagsUpdatedListener(TagsUpdatedEvent event) {
        TAGS_UPDATED_EVENT.register(event);
    }

    @Override
    public boolean canTreeGrowWithEvent(Level level, RandomSource source, BlockPos pos) {
        return true;
    }

    @Override
    public ResourceLocation getResourceLocation(String namespace, String sound) {
        return new ResourceLocation(namespace, sound);
    }

}
