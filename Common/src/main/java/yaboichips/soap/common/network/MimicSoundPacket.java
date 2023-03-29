package yaboichips.soap.common.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import yaboichips.soap.common.blocks.mimic.MimicTE;

public class MimicSoundPacket implements SoapServer2ClientPacket{

    private static MimicTE tile;
    private final String namespace;
    private final String sound;

    public MimicSoundPacket(MimicTE tile, String namespace, String sound){
        MimicSoundPacket.tile = tile;
        this.namespace = namespace;
        this.sound = sound;
    }

    public static MimicSoundPacket read(FriendlyByteBuf buf){
        return new MimicSoundPacket(tile, buf.readUtf(), buf.readUtf());
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeUtf(namespace);
            buf.writeUtf(sound);
        } catch (Exception e) {
            throw new IllegalStateException("MimicSoundPacket could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        tile.setSound(sound);
        tile.setNamespace(namespace);
    }
}
