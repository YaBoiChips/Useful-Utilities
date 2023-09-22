package yaboichips.soap.mixin.access;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(DoorBlock.class)
public interface DoorBlockAccess {

    @Invoker("<init>")
    static DoorBlock create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
