package yaboichips.usefulutilities.mixin.common;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(BottleItem.class)
public class MixinBottleItem {

    @Inject(method = "use", at = @At("RETURN"))
    private void use(Level world, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        HitResult hitresult = getPlayerPOVHitResult(world, player, ClipContext.Block.COLLIDER);
        if (hitresult.getType() == HitResult.Type.BLOCK) {
            BlockPos blockpos = ((BlockHitResult) hitresult).getBlockPos();
            BlockState state = world.getBlockState(blockpos);
            if (state == Blocks.CRYING_OBSIDIAN.defaultBlockState()){
                turnBottleIntoPot(player.getMainHandItem(), player, PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.AWKWARD));
                int i = world.random.nextInt(3);
                if (i == 2){
                    world.setBlock(blockpos, Blocks.OBSIDIAN.defaultBlockState(), 2);
                }
            }
        }
    }

    private ItemStack turnBottleIntoPot(ItemStack stack, Player player, ItemStack result) {
        player.awardStat(Stats.ITEM_USED.get(player.getMainHandItem().getItem()));
        player.level.playSound(player, player.blockPosition(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1, 1);
        return ItemUtils.createFilledResult(stack, player, result);
    }

    private static BlockHitResult getPlayerPOVHitResult(Level world, Player player, ClipContext.Block context) {
        float f = player.getXRot();
        float f1 = player.getYRot();
        Vec3 vec3 = player.getEyePosition();
        float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
        float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
        float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
        float f6 = f3 * f4;
        float f7 = f2 * f4;
        double d0 = 4;
        Vec3 vec31 = vec3.add((double)f6 * d0, (double)f5 * d0, (double)f7 * d0);
        return world.clip(new ClipContext(vec3, vec31, context, ClipContext.Fluid.ANY, player));
    }
}