package yaboichips.soap.core;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import yaboichips.soap.Soap;
import yaboichips.soap.common.blocks.hopper.CopperHopperTE;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceTE;
import yaboichips.soap.common.blocks.mason.MasonOvenTE;
import yaboichips.soap.mixin.access.BlockEntityTypeBuilderAccess;
import yaboichips.soap.util.Register;

public class SoapTileEntities {


    public static final BlockEntityType<CopperHopperTE> COPPER_HOPPER = createEntity("copper_hopper", BlockEntityType.Builder.of(CopperHopperTE::new, SoapBlocks.COPPER_HOPPER));
    public static final BlockEntityType<MasonOvenTE> MASON_OVEN = createEntity("mason_oven", BlockEntityType.Builder.of(MasonOvenTE::new, SoapBlocks.MASON_OVEN));
    public static final BlockEntityType<LargeFurnaceTE> LARGE_FURNACE = createEntity("large_furnace", BlockEntityType.Builder.of(LargeFurnaceTE::new, SoapBlocks.LARGE_FURNACE));


    private static <T extends BlockEntity> BlockEntityType<T> createEntity(String key, BlockEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).getValidBlocks().isEmpty()) {
            Soap.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", key);
        }
        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        return builder.build(type);
    }

    public static void register(Register<BlockEntityType<?>> entityType){
        entityType.register("copper_hopper", COPPER_HOPPER);
        entityType.register("mason_oven", MASON_OVEN);
        entityType.register("large_furnace", LARGE_FURNACE);
    }
}

