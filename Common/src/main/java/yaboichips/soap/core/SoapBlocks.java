package yaboichips.soap.core;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import yaboichips.soap.common.blocks.hopper.CopperHopper;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceBlock;
import yaboichips.soap.common.blocks.mason.MasonOven;
import yaboichips.soap.common.blocks.mimic.MimicBlock;
import yaboichips.soap.mixin.access.EndRodAccess;
import yaboichips.soap.mixin.access.StairBlockAccess;
import yaboichips.soap.util.Register;


public class SoapBlocks {

    public static final Block PAPER_WALL = new Block(BlockBehaviour.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).noOcclusion().strength(0.5f));
    public static final Block ACACIA_PANEL = createPlankType();
    public static final Block OAK_PANEL = createPlankType();
    public static final Block DARK_OAK_PANEL = createPlankType();
    public static final Block SPRUCE_PANEL = createPlankType();
    public static final Block BIRCH_PANEL = createPlankType();
    public static final Block JUNGLE_PANEL = createPlankType();
    public static final Block MANGROVE_PANEL = createPlankType();
    public static final Block WARPED_PANEL = createNetherPlankType();
    public static final Block CRIMSON_PANEL = createNetherPlankType();

    public static final Block CALCITE_PANEL = new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE));
    public static final Block PRISMARINE_PANEL = new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE));
    public static final Block PURPUR_PANEL = new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK));
    public static final Block STONE_PANEL = createStoneType();
    public static final Block DEEPSLATE_PANEL = createDeepslateType();

    public static final Block COPPER_HOPPER = new CopperHopper(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion());
    public static final Block MASON_OVEN = new MasonOven(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE));
    public static final Block LARGE_FURNACE = new LargeFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE));
    public static final Block MIMIC = new MimicBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK));

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

    public static Block createPlankType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    }

    public static Block createSandType() {
        return new SandBlock(0, BlockBehaviour.Properties.copy(Blocks.SAND));
    }

    public static Block createGravelType() {
        return new GravelBlock(BlockBehaviour.Properties.copy(Blocks.GRAVEL));
    }

    public static Block createBrickType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS));
    }

    public static Block createNetherPlankType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.WARPED_PLANKS));
    }

    public static Block createStoneType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.STONE));
    }

    public static Block createDeepslateType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS));
    }

    public static void register(Register<Block> blocks) {
        blocks.register("copper_hopper", COPPER_HOPPER);
        blocks.register("amethyst_lantern", AMETHYST_LANTERN);
        blocks.register("amethyst_end_rod", AMETHYST_END_ROD);
        blocks.register("copper_chain", COPPER_CHAIN);
        blocks.register("mason_oven", MASON_OVEN);
        blocks.register("large_furnace", LARGE_FURNACE);
        blocks.register("mimic", MIMIC);
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
        blocks.register("paper_wall", PAPER_WALL);
        blocks.register("acacia_panel", ACACIA_PANEL);
        blocks.register("oak_panel", OAK_PANEL);
        blocks.register("dark_oak_panel", DARK_OAK_PANEL);
        blocks.register("spruce_panel", SPRUCE_PANEL);
        blocks.register("birch_panel", BIRCH_PANEL);
        blocks.register("jungle_panel", JUNGLE_PANEL);
        blocks.register("mangrove_panel", MANGROVE_PANEL);
        blocks.register("warped_panel", WARPED_PANEL);
        blocks.register("crimson_panel", CRIMSON_PANEL);
        blocks.register("calcite_panel", CALCITE_PANEL);
        blocks.register("prismarine_panel", PRISMARINE_PANEL);
        blocks.register("purpur_panel", PURPUR_PANEL);
        blocks.register("stone_panel", STONE_PANEL);
        blocks.register("deepslate_panel", DEEPSLATE_PANEL);
    }
}