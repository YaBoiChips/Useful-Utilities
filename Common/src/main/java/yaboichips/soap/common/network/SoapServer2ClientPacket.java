package yaboichips.soap.common.network;

import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface SoapServer2ClientPacket {

    Map<String, Handler<?>> S2C_PACKETS = Util.make(new HashMap<>(), map -> {
        map.put("send_sounds", new Handler<>(MimicSoundPacket.class, MimicSoundPacket::write, MimicSoundPacket::read, MimicSoundPacket::handle));
    });


    void write(FriendlyByteBuf buf);

    void handle(Level level);

    record Handler<T extends SoapServer2ClientPacket>(Class<T> clazz, BiConsumer<T, FriendlyByteBuf> write,
                                           Function<FriendlyByteBuf, T> read,
                                           BiConsumer<T, Level> handle) {
    }
}
