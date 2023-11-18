package yaboichips.soap.core;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import yaboichips.soap.common.blocks.calibratedhopper.ItemCalibratorBlock;
import yaboichips.soap.common.blocks.hopper.CopperHopper;
import yaboichips.soap.common.blocks.large_furnace.LargeFurnaceBlock;
import yaboichips.soap.common.blocks.mason.MasonOven;
import yaboichips.soap.common.blocks.mimic.MimicBlock;
import yaboichips.soap.mixin.access.*;
import yaboichips.soap.util.Register;

import java.util.HashMap;


public class SoapBlocks {

    public static HashMap<String, Block> BLOCKS = new HashMap<>();

    public static final Block PAPER_WALL = createBlock("paper_wall", new Block(BlockBehaviour.Properties.of(Material.BAMBOO).sound(SoundType.BAMBOO).noOcclusion().strength(0.5f)));
    public static final Block ACACIA_PANEL = createBlock("acacia_panel", createPlankType());
    public static final Block OAK_PANEL = createBlock("oak_panel", createPlankType());
    public static final Block DARK_OAK_PANEL = createBlock("dark_oak_panel",createPlankType());
    public static final Block SPRUCE_PANEL = createBlock("spruce_panel",createPlankType());
    public static final Block BIRCH_PANEL = createBlock("birch_panel",createPlankType());
    public static final Block JUNGLE_PANEL = createBlock("jungle_panel",createPlankType());
    public static final Block MANGROVE_PANEL = createBlock("mangrove_panel",createPlankType());
    public static final Block WARPED_PANEL = createBlock("warped_panel",createNetherPlankType());
    public static final Block CRIMSON_PANEL = createBlock("crimson_panel",createNetherPlankType());

    public static final Block STAINED_PLANKS = createBlock("stained_planks", createPlankType());
    public static final Block STAINED_STAIRS = createBlock("stained_stairs", createWoodStair(STAINED_PLANKS.defaultBlockState));
    public static final Block STAINED_SLAB = createBlock("stained_slab", createWoodSlab());
    public static final Block STAINED_FENCE = createBlock("stained_fence", createFence());
    public static final Block STAINED_FENCE_GATE = createBlock("stained_fence_gate", createFenceGate());
//    public static final Block STAINED_DOOR = createDoor());
    public static final Block STAINED_TRAPDOOR = createBlock("stained_trapdoor", createTrapDoor());
    public static final Block STAINED_PRESSURE_PLATE = createBlock("stained_pressure_plate", createWoodPressurePlate());

    public static final Block ANGELIC_PLANKS = createBlock("angelic_planks", createPlankType());
    public static final Block ANGELIC_STAIRS = createBlock("angelic_stairs", createWoodStair(ANGELIC_PLANKS.defaultBlockState));
    public static final Block ANGELIC_SLAB = createBlock("angelic_slab", createWoodSlab());
    public static final Block ANGELIC_FENCE = createBlock("angelic_fence", createFence());
    public static final Block ANGELIC_FENCE_GATE = createBlock("angelic_fence_gate", createFenceGate());
    public static final Block ANGELIC_DOOR = createBlock("angelic_door", createDoor());
    public static final Block ANGELIC_TRAPDOOR = createBlock("angelic_trapdoor", createTrapDoor());
    public static final Block ANGELIC_PRESSURE_PLATE = createBlock("angelic_pressure_plate", createWoodPressurePlate());
    public static final Block ANGELIC_LOG = createBlock("angelic_log", createLog());
    public static final Block ANGELIC_WOOD = createBlock("angelic_wood", createLog());


    public static final Block CALCITE_PANEL = createBlock("calcite_panel",new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block PRISMARINE_PANEL = createBlock("prismarine_panel",new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE)));
    public static final Block PURPUR_PANEL = createBlock("purpur_panel",new Block(BlockBehaviour.Properties.copy(Blocks.PURPUR_BLOCK)));
    public static final Block STONE_PANEL = createBlock("stone_panel",createStoneType());
    public static final Block DEEPSLATE_PANEL = createBlock("deepslate_panel",createDeepslateType());

    public static final Block COPPER_HOPPER = createBlock("copper_hopper", new CopperHopper(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion()));
    public static final Block ITEM_CALIBRATOR = createBlock("item_calibrator", new ItemCalibratorBlock(BlockBehaviour.Properties.copy(Blocks.HOPPER).noOcclusion()));

    public static final Block MASON_OVEN = createBlock("mason_oven", new MasonOven(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE)));
    public static final Block LARGE_FURNACE = createBlock("large_furnace", new LargeFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.BLAST_FURNACE).noOcclusion()));
    public static final Block MIMIC = createBlock("mimic", new MimicBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)));

    public static final Block COPPER_CHAIN = createBlock("copper_chain", new ChainBlock(BlockBehaviour.Properties.copy(Blocks.CHAIN)));
    public static final Block AMETHYST_LANTERN = createBlock("amethyst_lantern", new LanternBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).noOcclusion()));
    public static final Block AMETHYST_END_ROD = createBlock("amethyst_end_rod", EndRodAccess.create(BlockBehaviour.Properties.copy(Blocks.END_ROD)));

    public static final Block TUFF_SLAB = createBlock("tuff_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_STAIRS = createBlock("tuff_stairs", StairBlockAccess.create(Blocks.TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_WALL = createBlock("tuff_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF = createBlock("polished_tuff", new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_SLAB = createBlock("polished_tuff_slab",new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_STAIRS = createBlock("polished_tuff_stairs",StairBlockAccess.create(POLISHED_TUFF.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block POLISHED_TUFF_WALL = createBlock("polished_tuff_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICKS = createBlock("tuff_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICK_SLAB = createBlock("tuff_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICK_STAIRS = createBlock("tuff_brick_stairs", StairBlockAccess.create(TUFF_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.TUFF)));
    public static final Block TUFF_BRICK_WALL = createBlock("tuff_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.TUFF)));

    public static final Block CALCITE_SLAB = createBlock("calcite_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_STAIRS = createBlock("calcite_stairs", StairBlockAccess.create(Blocks.CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_WALL = createBlock("calcite_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE = createBlock("polished_calcite", new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE_SLAB = createBlock("polished_calcite_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE_STAIRS = createBlock("polished_calcite_stairs", StairBlockAccess.create(POLISHED_CALCITE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block POLISHED_CALCITE_WALL = createBlock("polished_calcite_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICKS = createBlock("calcite_bricks", new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICK_SLAB = createBlock("calcite_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICK_STAIRS = createBlock("calcite_brick_stairs", StairBlockAccess.create(CALCITE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final Block CALCITE_BRICK_WALL = createBlock("calcite_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(Blocks.CALCITE)));


    public static Block createPlankType() {
        return new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS));
    }

    public static Block createWoodSlab() {
        return new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB));
    }

    public static Block createWoodStair(BlockState block) {
        return StairBlockAccess.create(block, BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS));
    }

    public static Block createFence() {
        return new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE));
    }

    public static Block createFenceGate() {
        return new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE));
    }

    public static Block createWoodPressurePlate() {
        return PressurePlateBlockAccess.create(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE));
    }

    public static Block createDoor() {
        return DoorBlockAccess.create(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR));
    }

    public static Block createTrapDoor() {
        return TrapDoorBlockAccess.create(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR));
    }
    public static Block createLog(){
        return new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG));
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

    public static Block createBlock(String id, Block block){
        BLOCKS.put(id, block);
        return block;
    }


    public static void register(Register<Block> blocks) {
        BLOCKS.forEach(blocks::register);
//        blocks.register("copper_hopper", COPPER_HOPPER);
//        blocks.register("amethyst_lantern", AMETHYST_LANTERN);
//        blocks.register("amethyst_end_rod", AMETHYST_END_ROD);
//        blocks.register("copper_chain", COPPER_CHAIN);
//        blocks.register("mason_oven", MASON_OVEN);
//        blocks.register("large_furnace", LARGE_FURNACE);
//        blocks.register("mimic", MIMIC);
//        blocks.register("tuff_slab", TUFF_SLAB);
//        blocks.register("tuff_stairs", TUFF_STAIRS);
//        blocks.register("tuff_wall", TUFF_WALL);
//        blocks.register("polished_tuff", POLISHED_TUFF);
//        blocks.register("polished_tuff_slab", POLISHED_TUFF_SLAB);
//        blocks.register("polished_tuff_stairs", POLISHED_TUFF_STAIRS);
//        blocks.register("polished_tuff_wall", POLISHED_TUFF_WALL);
//        blocks.register("tuff_bricks", TUFF_BRICKS);
//        blocks.register("tuff_brick_slab", TUFF_BRICK_SLAB);
//        blocks.register("tuff_brick_stairs", TUFF_BRICK_STAIRS);
//        blocks.register("tuff_brick_wall", TUFF_BRICK_WALL);
//        blocks.register("calcite_slab", CALCITE_SLAB);
//        blocks.register("calcite_stairs", CALCITE_STAIRS);
//        blocks.register("calcite_wall", CALCITE_WALL);
//        blocks.register("polished_calcite", POLISHED_CALCITE);
//        blocks.register("polished_calcite_slab", POLISHED_CALCITE_SLAB);
//        blocks.register("polished_calcite_stairs", POLISHED_CALCITE_STAIRS);
//        blocks.register("polished_calcite_wall", POLISHED_CALCITE_WALL);
//        blocks.register("calcite_bricks", CALCITE_BRICKS);
//        blocks.register("calcite_brick_slab", CALCITE_BRICK_SLAB);
//        blocks.register("calcite_brick_stairs", CALCITE_BRICK_STAIRS);
//        blocks.register("calcite_brick_wall", CALCITE_BRICK_WALL);
//        blocks.register("paper_wall", PAPER_WALL);
//        blocks.register("acacia_panel", ACACIA_PANEL);
//        blocks.register("oak_panel", OAK_PANEL);
//        blocks.register("dark_oak_panel", DARK_OAK_PANEL);
//        blocks.register("spruce_panel", SPRUCE_PANEL);
//        blocks.register("birch_panel", BIRCH_PANEL);
//        blocks.register("jungle_panel", JUNGLE_PANEL);
//        blocks.register("mangrove_panel", MANGROVE_PANEL);
//        blocks.register("warped_panel", WARPED_PANEL);
//        blocks.register("crimson_panel", CRIMSON_PANEL);
//        blocks.register("calcite_panel", CALCITE_PANEL);
//        blocks.register("prismarine_panel", PRISMARINE_PANEL);
//        blocks.register("purpur_panel", PURPUR_PANEL);
//        blocks.register("stone_panel", STONE_PANEL);
//        blocks.register("deepslate_panel", DEEPSLATE_PANEL);
//        blocks.register("stained_planks", STAINED_PLANKS);
//        blocks.register("stained_stairs", STAINED_STAIRS);
//        blocks.register("stained_slab", STAINED_SLAB);
//        blocks.register("stained_fence", STAINED_FENCE);
//        blocks.register("stained_fence_gate", STAINED_FENCE_GATE);
//        blocks.register("stained_door", STAINED_DOOR);
//        blocks.register("stained_trapdoor", STAINED_TRAPDOOR);
//        blocks.register("stained_pressure_plate", STAINED_PRESSURE_PLATE);
//        blocks.register("angelic_planks", ANGELIC_PLANKS);
//        blocks.register("angelic_stairs", ANGELIC_STAIRS);
//        blocks.register("angelic_slab", ANGELIC_SLAB);
//        blocks.register("angelic_fence", ANGELIC_FENCE);
//        blocks.register("angelic_fence_gate", ANGELIC_FENCE_GATE);
//        blocks.register("angelic_door", ANGELIC_DOOR);
//        blocks.register("angelic_trapdoor", ANGELIC_TRAPDOOR);
//        blocks.register("angelic_pressure_plate", ANGELIC_PRESSURE_PLATE);
    }
}