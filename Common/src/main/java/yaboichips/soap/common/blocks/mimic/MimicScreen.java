package yaboichips.soap.common.blocks.mimic;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import yaboichips.soap.common.network.MimicSoundPacket;
import yaboichips.soap.util.ModPlatform;

import java.util.ArrayList;
import java.util.List;

public class MimicScreen extends Screen {
    public int x;
    public int y = 30;

    public int scrollAmount = 0;

    public MimicTE mimic;

    public List<Button> BUTTONS = new ArrayList<>();

    public MimicScreen(MimicTE mimic) {
        super(Component.literal("Play Sound"));
        this.mimic = mimic;
    }

    @Override
    public void tick() {
        super.tick();
    }

    public void init() {
        Registry.SOUND_EVENT.forEach((soundEvent) -> {
            BUTTONS.add(new Button((this.width / 2) - 75, y, 150, 20, Component.translatable("subtitles." + soundEvent.getLocation().getPath()), (onPress) -> {
                this.minecraft.player.playSound(soundEvent, 1, 1);
                ModPlatform.INSTANCE.sendToServer(new MimicSoundPacket(this.mimic, soundEvent.getLocation().getNamespace(), soundEvent.getLocation().getPath()));
            }));
            this.y = this.y + 25;
        });
        BUTTONS.forEach(this::addRenderableWidget);
        this.addRenderableWidget(new Button(10, 150, 20, 20, Component.literal("↓"), (onPress) -> {
            this.scrollAmount += 1;
            BUTTONS.forEach((button -> button.y -= 100));
        }));
        this.addRenderableWidget(new Button(10, 120, 20, 20, Component.literal("↑"), (onPress) -> {
            if (this.scrollAmount > 0) {
                this.scrollAmount -= 1;
                BUTTONS.forEach((button -> button.y += 100));
            }
        }));
    }

    @Override
    public void resize(Minecraft p_96575_, int p_96576_, int p_96577_) {
        super.resize(p_96575_, p_96576_, p_96577_);
        this.init(p_96575_, p_96576_, p_96577_);
    }

    public void render(PoseStack p_99406_, int p_99407_, int p_99408_, float p_99409_) {
        this.renderBackground(p_99406_);
        drawCenteredString(p_99406_, this.font, this.title, this.width / 2, 10, 16777215);
        super.render(p_99406_, p_99407_, p_99408_, p_99409_);
    }

    public boolean isPauseScreen() {
        return false;
    }
}
