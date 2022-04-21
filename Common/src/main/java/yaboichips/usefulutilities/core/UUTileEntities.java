package yaboichips.usefulutilities.core;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import yaboichips.usefulutilities.UsefulUtilities;
import yaboichips.usefulutilities.common.blocks.hopper.CopperHopperTE;
import yaboichips.usefulutilities.common.blocks.mason.MasonOvenTE;
import yaboichips.usefulutilities.mixin.access.BlockEntityTypeBuilderAccess;
import yaboichips.usefulutilities.util.Register;

public class UUTileEntities {


    public static final BlockEntityType<CopperHopperTE> COPPER_HOPPER = createEntity("copper_hopper", BlockEntityType.Builder.of(CopperHopperTE::new, UUBlocks.COPPER_HOPPER));
    public static final BlockEntityType<MasonOvenTE> MASON_OVEN = createEntity("mason_oven", BlockEntityType.Builder.of(MasonOvenTE::new, UUBlocks.MASON_OVEN));


    private static <T extends BlockEntity> BlockEntityType<T> createEntity(String key, BlockEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).getValidBlocks().isEmpty()) {
            UsefulUtilities.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object) key);
        }
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        return builder.build(type);
    }

    public static void register(Register<BlockEntityType<?>> entityType){
        entityType.register("copper_hopper", COPPER_HOPPER);
        entityType.register("mason_oven", MASON_OVEN);
    }
}

