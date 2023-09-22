package yaboichips.soap.mixin.common;


import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DispenseItemBehavior.class)
public interface MixinDispenseItemBehavior {

    @Inject(method = "bootStrap", at = @At("HEAD"))
    private static void addSapling(CallbackInfo ci) {
        DispenseItemBehavior sapling = new OptionalDispenseItemBehavior() {
            protected ItemStack execute(BlockSource blockSource, ItemStack stack) {
                Level level = blockSource.getLevel();
                BlockPos pos = blockSource.getPos().relative(blockSource.getBlockState().getValue(DispenserBlock.FACING));
                if (stack.getItem() instanceof BlockItem sapling) {
                    if (sapling.getBlock() instanceof SaplingBlock sapBlock) {
                        if (sapBlock.canSurvive(level.getBlockState(pos), level, pos) && level.getBlockState(pos).isAir()) {
                            if (!level.isClientSide) {
                                level.setBlock(pos, sapling.getBlock().defaultBlockState(), 3);
                                level.gameEvent(null, GameEvent.BLOCK_PLACE, pos);
                            }
                            stack.shrink(1);
                            this.setSuccess(true);
                        }
                    }
                } else {
                    this.setSuccess(ArmorItem.dispenseArmor(blockSource, stack));
                }

                return stack;

            }
        };

        DispenserBlock.registerBehavior(Items.OAK_SAPLING, sapling);
        DispenserBlock.registerBehavior(Items.DARK_OAK_SAPLING, sapling);
        DispenserBlock.registerBehavior(Items.ACACIA_SAPLING, sapling);
        DispenserBlock.registerBehavior(Items.SPRUCE_SAPLING, sapling);
        DispenserBlock.registerBehavior(Items.BIRCH_SAPLING, sapling);
        DispenserBlock.registerBehavior(Items.JUNGLE_SAPLING, sapling);

    }

}
