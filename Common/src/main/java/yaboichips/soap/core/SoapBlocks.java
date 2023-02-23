package yaboichips.soap.core;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import yaboichips.soap.common.blocks.hopper.CopperHopper;
import yaboichips.soap.common.blocks.mason.MasonOven;
import yaboichips.soap.mixin.access.EndRodAccess;
import yaboichips.soap.mixin.access.StairBlockAccess;
import yaboichips.soap.util.Register;


public class SoapBlocks {

    public static final Block COPPER_HOPPER = new CopperHopper(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion());
    public static final Block MASON_OVEN = new MasonOven(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE));

    public static final Block COPPER_CHAIN = new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN));
    public static final Block AMETHYST_LANTERN = new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).noOcclusion());
    public static final Block AMETHYST_END_ROD = EndRodAccess.create(BlockBehaviour.Properties.copy(Blocks.END_ROD));

    public static final Block TUFF_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_STAIRS = StairBlockAccess.create(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block POLISHED_TUFF = new Block(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block POLISHED_TUFF_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block POLISHED_TUFF_STAIRS = StairBlockAccess.create(POLISHED_TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block POLISHED_TUFF_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_BRICKS = new Block(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_STAIRS = StairBlockAccess.create(TUFF_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF));
    public static final Block TUFF_BRICK_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF));

    public static final Block CALCITE_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_STAIRS = StairBlockAccess.create(Blocks.CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE = new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_STAIRS = StairBlockAccess.create(POLISHED_CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block POLISHED_CALCITE_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICKS = new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_SLAB = new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_STAIRS = StairBlockAccess.create(CALCITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block CALCITE_BRICK_WALL = new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE));

    public static void register(Register<Block> blocks) {
        blocks.register("copper_hopper", COPPER_HOPPER);
        blocks.register("amethyst_lantern", AMETHYST_LANTERN);
        blocks.register("amethyst_end_rod", AMETHYST_END_ROD);
        blocks.register("copper_chain", COPPER_CHAIN);
        blocks.register("mason_oven", MASON_OVEN);
        blocks.register("tuff_slab", TUFF_SLAB);
        blocks.register("tuff_stairs", TUFF_STAIRS);
        blocks.register("tuff_wall", TUFF_WALL);
        blocks.register("polished_tuff", POLISHED_TUFF);
        blocks.register("polished_tuff_slab", POLISHED_TUFF_SLAB);
        blocks.register("polished_tuff_stairs", POLISHED_TUFF_STAIRS);
        blocks.register("polished_tuff_wall", POLISHED_TUFF_WALL);
        blocks.register("tuff_bricks", TUFF_BRICKS);
        blocks.register("tuff_brick_slab", TUFF_BRICK_SLAB);
        blocks.register("tuff_brick_stairs", TUFF_BRICK_STAIRS);
        blocks.register("tuff_brick_wall", TUFF_BRICK_WALL);
        blocks.register("calcite_slab", CALCITE_SLAB);
        blocks.register("calcite_stairs", CALCITE_STAIRS);
        blocks.register("calcite_wall", CALCITE_WALL);
        blocks.register("polished_calcite", POLISHED_CALCITE);
        blocks.register("polished_calcite_slab", POLISHED_CALCITE_SLAB);
        blocks.register("polished_calcite_stairs", POLISHED_CALCITE_STAIRS);
        blocks.register("polished_calcite_wall", POLISHED_CALCITE_WALL);
        blocks.register("calcite_bricks", CALCITE_BRICKS);
        blocks.register("calcite_brick_slab", CALCITE_BRICK_SLAB);
        blocks.register("calcite_brick_stairs", CALCITE_BRICK_STAIRS);
        blocks.register("calcite_brick_wall", CALCITE_BRICK_WALL);
    }
}