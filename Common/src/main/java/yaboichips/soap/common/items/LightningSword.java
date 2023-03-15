package yaboichips.soap.common.items;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import yaboichips.soap.util.SoapConstants;

public class LightningSword extends SwordItem {
    public LightningSword(Tier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int i = target.getRandom().nextInt(10);
        Level world = attacker.getCommandSenderWorld();
        BlockPos blockpos = target.blockPosition();
        LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
        if (i >= 9) {
            lightningboltentity.moveTo(Vec3.atBottomCenterOf(blockpos));
            world.addFreshEntity(lightningboltentity);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
        ItemStack item = playerIn.getItemInHand(handIn);
        if (!playerIn.getCooldowns().isOnCooldown(item.getItem())) {
            SoapConstants.pushLooking(playerIn, 0, 4f);
            Level world = playerIn.level;
            LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity2 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity3 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity4 = EntityType.LIGHTNING_BOLT.create(world);
            LightningBolt lightningboltentity5 = EntityType.LIGHTNING_BOLT.create(world);
            lightningboltentity.moveTo(Vec3.atBottomCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity);
            lightningboltentity2.moveTo(Vec3.atBottomCenterOf(new BlockPos(playerIn.getX() + 5, playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity2);
            lightningboltentity3.moveTo(Vec3.atBottomCenterOf(new BlockPos(playerIn.getX() - 5, playerIn.getY(), playerIn.getZ())));
            world.addFreshEntity(lightningboltentity3);
            lightningboltentity4.moveTo(Vec3.atBottomCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ() + 5)));
            world.addFreshEntity(lightningboltentity4);
            lightningboltentity5.moveTo(Vec3.atBottomCenterOf(new BlockPos(playerIn.getX(), playerIn.getY(), playerIn.getZ() - 5)));
            world.addFreshEntity(lightningboltentity5);
            playerIn.getCooldowns().addCooldown(playerIn.getItemInHand(handIn).getItem(), 600);
            playerIn.clearFire();
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, item);
    }
}
