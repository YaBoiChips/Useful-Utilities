package yaboichips.soap.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.WeatheringCopperFullBlock;
import net.minecraft.world.level.block.WeatheringCopperSlabBlock;
import net.minecraft.world.level.block.WeatheringCopperStairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ThrownPotion.class)
public abstract class MixinThrownPotion extends ThrowableItemProjectile {


    public MixinThrownPotion(EntityType<? extends ThrowableItemProjectile> type, Level world) {
        super(type, world);
    }

    @Inject(method = "onHitBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/projectile/ThrownPotion;dowseFire(Lnet/minecraft/core/BlockPos;)V", ordinal = 0))
    public void onHitBlock(BlockHitResult result, CallbackInfo ci) {
        BlockPos pos = result.getBlockPos();
        Direction direction = result.getDirection();
        BlockPos blockpos1 = pos.relative(direction);
        oxidiseBlock(pos);
        oxidiseBlock(blockpos1);
    }

    private void oxidiseBlock(BlockPos blockpos) {
        BlockState blockstate = this.level.getBlockState(blockpos);
        if (blockstate.getBlock() instanceof WeatheringCopperFullBlock block) {
            level.setBlock(blockpos, WeatheringCopper.getNext(block).orElse(block).defaultBlockState(), 2);
        }
        if (blockstate.getBlock() instanceof WeatheringCopperSlabBlock block) {
            level.setBlock(blockpos, WeatheringCopper.getNext(block).orElse(block).defaultBlockState(), 2);
        }
        if (blockstate.getBlock() instanceof WeatheringCopperStairBlock block) {
            level.setBlock(blockpos, WeatheringCopper.getNext(block).orElse(block).defaultBlockState(), 2);
        }
    }
}

