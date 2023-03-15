package yaboichips.soap.util;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

public class SoapConstants {

    public static void pushLooking(Player player, float force){
        float f7 = player.getYRot();
        float f = player.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
        f1 = f1 * (force / f4);
        f2 = f2 * (force / f4);
        f3 = f3 * (force / f4);
        player.push(f1, f2, f3);
    }

    public static void pushLooking(Player player, float y, float force){
        float f7 = player.getYRot();
        float f = player.getXRot();
        float f1 = -Mth.sin(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f2 = -Mth.sin(f * ((float) Math.PI / 180F));
        float f3 = Mth.cos(f7 * ((float) Math.PI / 180F)) * Mth.cos(f * ((float) Math.PI / 180F));
        float f4 = Mth.sqrt(f1 * f1 + f2 * f2 + f3 * f3);
        f1 = f1 * (force / f4);
        f2 = f2 * (force / f4);
        f3 = f3 * (force / f4);
        player.push(f1, y, f3);
    }
}
