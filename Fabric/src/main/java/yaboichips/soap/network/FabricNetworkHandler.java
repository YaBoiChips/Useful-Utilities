package yaboichips.soap.network;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import yaboichips.soap.Soap;
import yaboichips.soap.common.network.SoapServer2ClientPacket;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class FabricNetworkHandler {

    private static final String PACKET_LOCATION = Soap.MOD_ID;

    private static final Map<Class<?>, BiConsumer<?, FriendlyByteBuf>> ENCODERS = new ConcurrentHashMap<>();
    private static final Map<Class<?>, ResourceLocation> PACKET_IDS = new ConcurrentHashMap<>();

    public static void init() {
        SoapServer2ClientPacket.S2C_PACKETS.forEach(FabricNetworkHandler::register);
    }

    private static <T extends SoapServer2ClientPacket> void register(String path, SoapServer2ClientPacket.Handler<T> handler) {
        registerMessage(path, handler.clazz(), handler.write(), handler.read(), handler.handle());
    }

    private static <T extends SoapServer2ClientPacket> void registerMessage(String id, Class<T> clazz,
                                                           BiConsumer<T, FriendlyByteBuf> encode,
                                                           Function<FriendlyByteBuf, T> decode,
                                                           SoapServer2ClientPacket.Handle<T> handler) {
        ENCODERS.put(clazz, encode);
        PACKET_IDS.put(clazz, new ResourceLocation(PACKET_LOCATION, id));


        if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
            ClientProxy.registerClientReceiver(id, decode, handler);
        }
        ServerProxy.registerServerReceiver(id, decode, handler);

    }

    public static <MSG extends SoapServer2ClientPacket> void sendToServer(MSG packet) {
        ResourceLocation packetId = PACKET_IDS.get(packet.getClass());
        @SuppressWarnings("unchecked")
        BiConsumer<MSG, FriendlyByteBuf> encoder = (BiConsumer<MSG, FriendlyByteBuf>) ENCODERS.get(packet.getClass());
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        encoder.accept(packet, buf);
        ClientPlayNetworking.send(packetId, buf);
    }
        public static <MSG> void sendToPlayer(ServerPlayer player, MSG packet) {
        ResourceLocation packetId = PACKET_IDS.get(packet.getClass());
        @SuppressWarnings("unchecked")
        BiConsumer<MSG, FriendlyByteBuf> encoder = (BiConsumer<MSG, FriendlyByteBuf>) ENCODERS.get(packet.getClass());
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        encoder.accept(packet, buf);
        ServerPlayNetworking.send(player, packetId, buf);
    }

    public static <MSG> void sendToAllPlayers(List<ServerPlayer> players, MSG packet) {
        ResourceLocation packetId = PACKET_IDS.get(packet.getClass());
        @SuppressWarnings("unchecked")
        BiConsumer<MSG, FriendlyByteBuf> encoder = (BiConsumer<MSG, FriendlyByteBuf>) ENCODERS.get(packet.getClass());
        FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
        encoder.accept(packet, buf);

        players.forEach(player -> {
            ServerPlayNetworking.send(player, packetId, buf);
        });
    }

    public record ClientProxy() {

        public static <T extends SoapServer2ClientPacket> void registerClientReceiver(String id, Function<FriendlyByteBuf, T> decode,
                                                                     SoapServer2ClientPacket.Handle<T> handler) {
            ClientPlayNetworking.registerGlobalReceiver(new ResourceLocation(PACKET_LOCATION, id), (client, listener, buf, responseSender) -> {
                buf.retain();
                client.execute(() -> {
                    T packet = decode.apply(buf);
                    ClientLevel level = client.level;
                    if (level != null) {
                        try {
                            handler.handle(packet, level);
                        } catch (Throwable throwable) {
                            throw throwable;
                        }
                    }
                    buf.release();
                });
            });
        }
    }
    public static class ServerProxy {
        private static <T extends SoapServer2ClientPacket> void registerServerReceiver(String id, Function<FriendlyByteBuf, T> decode, SoapServer2ClientPacket.Handle<T> handler) {
            ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(PACKET_LOCATION, id), (server, player, handler1, buf, responseSender) -> {
                buf.retain();
                server.execute(() -> {
                    T packet = decode.apply(buf);
                    ServerLevel level = player.getLevel();
                    if (level != null) {
                        try {
                            handler.handle(packet, level);
                        } catch (Throwable throwable) {
                            throw throwable;
                        }
                    }
                    buf.release();
                });
            });
        }
    }
}