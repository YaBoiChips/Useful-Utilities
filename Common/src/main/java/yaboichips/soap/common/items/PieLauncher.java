package yaboichips.soap.common.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import yaboichips.soap.common.entities.PieProjectile;
import yaboichips.soap.core.SoapItems;

import java.util.function.Predicate;

public class PieLauncher extends ProjectileWeaponItem {

    public static final Predicate<ItemStack> PIES = (pies) -> pies.is(Items.PUMPKIN_PIE);

    public PieLauncher(Properties $$0) {
        super($$0);
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return PIES;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        int slot = player.getInventory().findSlotMatchingItem(Items.PUMPKIN_PIE.getDefaultInstance());
//        int slot2 = player.getInventory().findSlotMatchingItem(SoapItems.SWEET_BERRY_PIE.getDefaultInstance());
//        ItemStack itemstack2 = player.getInventory().items.get(player.getInventory().findSlotMatchingItem(SoapItems.SWEET_BERRY_PIE.getDefaultInstance()));
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
        if (player.getMainHandItem().is(SoapItems.DARK_OAK_PANEL) && slot != -1) {
            ItemStack itemStack = player.getInventory().getItem(slot);
            if (!level.isClientSide) {
                PieProjectile pie = new PieProjectile(this, level, player);
                pie.moveTo(player.position().add(0, 1, 0));
                pie.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(pie);
            }
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild && itemStack.is(Items.PUMPKIN_PIE)) {
                itemStack.shrink(1);
            }
//        }
//        else if (itemstack2 == SoapItems.SWEET_BERRY_PIE.getDefaultInstance() && slot2 != -1) {
//            if (!level.isClientSide) {
//                PieProjectile pie = new PieProjectile(this, level, player);
//                pie.setItem(itemstack2);
//                pie.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
//                level.addFreshEntity(pie);
//            }
//            player.awardStat(Stats.ITEM_USED.get(this));
//            if (!player.getAbilities().instabuild) {
//                itemstack2.shrink(1);
//            }
//        } else{
//            return InteractionResultHolder.fail(itemstack);
//        }
        }

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

    @Override
    public int getDefaultProjectileRange() {
        return 4;
    }
}
