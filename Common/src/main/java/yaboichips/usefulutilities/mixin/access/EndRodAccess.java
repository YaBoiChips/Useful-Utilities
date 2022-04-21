package yaboichips.usefulutilities.mixin.access;

import net.minecraft.world.level.block.EndRodBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(EndRodBlock.class)
public interface EndRodAccess {

    @Invoker("<init>")
    static EndRodBlock create(BlockBehaviour.Properties properties) {
        throw new Error("Mixin did not apply!");
    }
}
