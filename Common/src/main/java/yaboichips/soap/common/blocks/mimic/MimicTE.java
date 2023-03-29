package yaboichips.soap.common.blocks.mimic;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import yaboichips.soap.core.SoapTileEntities;

public class MimicTE extends BlockEntity {

    private String sound;
    private String namespace;


    public MimicTE(BlockPos $$1, BlockState $$2) {
        super(SoapTileEntities.MIMIC, $$1, $$2);
    }


    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putString("Sound", sound);
        tag.putString("Namespace", namespace);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.sound = tag.getString("Sound");
        this.namespace = tag.getString("Namespace");
    }


    public static void tick(Level level, BlockPos pos, BlockState state, MimicTE te) {
        System.out.println("Sound = " + te.sound);
        System.out.println("Namespace = " + te.namespace);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
