package yaboichips.soap;

import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import yaboichips.soap.common.network.SoapServer2ClientPacket;


import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ForgeNetworkHandler {
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel SIMPLE_CHANNEL = NetworkRegistry.newSimpleChannel(
        new ResourceLocation(Soap.MOD_ID, "network"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    public static void init() {
        int idx = 0;
        for (Map.Entry<String, SoapServer2ClientPacket.Handler<?>> entry : SoapServer2ClientPacket.S2C_PACKETS.entrySet()) {
            registerMessage(idx++, entry.getValue());
        }
    }

    public static <T extends SoapServer2ClientPacket> void registerMessage(int idx, SoapServer2ClientPacket.Handler<T> handler) {
        SIMPLE_CHANNEL.registerMessage(idx, handler.clazz(), handler.write(), handler.read(), (t, contextSupplier) -> handle(t, contextSupplier, handler.handle()));
    }

    public static void sendToPlayer(ServerPlayer playerEntity, Object objectToSend) {
        SIMPLE_CHANNEL.sendTo(objectToSend, playerEntity.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void sendToAllPlayers(List<ServerPlayer> playerEntities, Object objectToSend) {
        for (ServerPlayer playerEntity : playerEntities) {
            SIMPLE_CHANNEL.sendTo(objectToSend, playerEntity.connection.getConnection(), NetworkDirection.PLAY_TO_CLIENT);
        }
    }

    public static void sendToServer(Object objectToSend) {
        SIMPLE_CHANNEL.sendToServer(objectToSend);
    }

    public static <T extends SoapServer2ClientPacket> void handle(T packet, Supplier<NetworkEvent.Context> ctx, SoapServer2ClientPacket.Handle<T> handle) {
        NetworkEvent.Context context = ctx.get();
        if (context.getDirection().getReceptionSide().isClient()) {
            context.enqueueWork(() -> {
                Client.clientHandle(packet, handle);
            });
        } else {
            ServerPlayer sender = context.getSender();
            assert sender != null;
            handle.handle(packet, sender.level);
        }
        context.setPacketHandled(true);
    }

    private static class Client {
        private static <T extends SoapServer2ClientPacket> void clientHandle(T packet, SoapServer2ClientPacket.Handle<T> handle) {
            handle.handle(packet, Minecraft.getInstance().level);
        }
    }
}