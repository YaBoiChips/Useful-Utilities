package yaboichips.usefulutilities.core;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import yaboichips.usefulutilities.common.entities.TurtleBoat;
import yaboichips.usefulutilities.common.items.ThrowableDragonsBreath;
import yaboichips.usefulutilities.common.items.TravelersBoots;
import yaboichips.usefulutilities.common.items.TurtleBoatItem;
import yaboichips.usefulutilities.util.Register;

import static yaboichips.usefulutilities.common.entities.TurtleBoat.ModType.*;
import static yaboichips.usefulutilities.core.UUTab.TAB;


public class UUItems {

    public static final Item COPPER_HOPPER = createBlockItem(UUBlocks.COPPER_HOPPER);
    public static final Item MASON_OVEN = createBlockItem(UUBlocks.MASON_OVEN);

    public static final Item TUFF_SLAB = createBlockItem(UUBlocks.TUFF_SLAB);
    public static final Item TUFF_STAIRS = createBlockItem(UUBlocks.TUFF_STAIRS);
    public static final Item TUFF_WALL = createBlockItem(UUBlocks.TUFF_WALL);
    public static final Item POLISHED_TUFF = createBlockItem(UUBlocks.POLISHED_TUFF);
    public static final Item POLISHED_TUFF_SLAB = createBlockItem(UUBlocks.POLISHED_TUFF_SLAB);
    public static final Item POLISHED_TUFF_STAIRS = createBlockItem(UUBlocks.POLISHED_TUFF_STAIRS);
    public static final Item POLISHED_TUFF_WALL = createBlockItem(UUBlocks.POLISHED_TUFF_WALL);
    public static final Item TUFF_BRICKS = createBlockItem(UUBlocks.TUFF_BRICKS);
    public static final Item TUFF_BRICK_SLAB = createBlockItem(UUBlocks.TUFF_BRICK_SLAB);
    public static final Item TUFF_BRICK_STAIRS = createBlockItem(UUBlocks.TUFF_BRICK_STAIRS);
    public static final Item TUFF_BRICK_WALL = createBlockItem(UUBlocks.TUFF_BRICK_WALL);


    public static final Item CALCITE_SLAB = createBlockItem(UUBlocks.CALCITE_SLAB);
    public static final Item CALCITE_STAIRS = createBlockItem(UUBlocks.CALCITE_STAIRS);
    public static final Item CALCITE_WALL = createBlockItem(UUBlocks.CALCITE_WALL);
    public static final Item POLISHED_CALCITE = createBlockItem(UUBlocks.POLISHED_CALCITE);
    public static final Item POLISHED_CALCITE_SLAB = createBlockItem(UUBlocks.POLISHED_CALCITE_SLAB);
    public static final Item POLISHED_CALCITE_STAIRS = createBlockItem(UUBlocks.POLISHED_CALCITE_STAIRS);
    public static final Item POLISHED_CALCITE_WALL = createBlockItem(UUBlocks.POLISHED_CALCITE_WALL);

    public static final Item CALCITE_BRICKS = createBlockItem(UUBlocks.CALCITE_BRICKS);
    public static final Item CALCITE_BRICK_SLAB = createBlockItem(UUBlocks.CALCITE_BRICK_SLAB);
    public static final Item CALCITE_BRICK_STAIRS = createBlockItem(UUBlocks.CALCITE_BRICK_STAIRS);
    public static final Item CALCITE_BRICK_WALL = createBlockItem(UUBlocks.CALCITE_BRICK_WALL);


    public static final Item COPPER_BOOTS = createArmorItem(UUArmors.COPPER, EquipmentSlot.FEET);
    public static final Item COPPER_LEGGINGS = createArmorItem(UUArmors.COPPER, EquipmentSlot.LEGS);
    public static final Item COPPER_CHESTPLATE = createArmorItem(UUArmors.COPPER, EquipmentSlot.CHEST);
    public static final Item COPPER_HELMET = createArmorItem(UUArmors.COPPER, EquipmentSlot.HEAD);

    public static final Item RAW_LLAMA = createFoodItem(UUFoods.RAW_LLAMA);
    public static final Item CHARKI = createFoodItem(UUFoods.CHARKI);
    public static final Item RAW_GOAT = createFoodItem(UUFoods.RAW_GOAT);
    public static final Item COOKED_GOAT = createFoodItem(UUFoods.COOKED_GOAT);

    public static final Item HORSE_BONE = new Item(new Item.Properties().tab(TAB).craftRemainder(Items.BONE));
    public static final Item FOX_FUR = createItem();
    public static final Item LLAMA_SPIT = createItem();
    public static final Item THROWABLE_DRAGONS_BREATH = new ThrowableDragonsBreath(new Item.Properties().tab(TAB));

    public static final Item AMETHYST_LANTERN = createBlockItem(UUBlocks.AMETHYST_LANTERN);
    public static final Item AMETHYST_END_ROD = createBlockItem(UUBlocks.AMETHYST_END_ROD);
    public static final Item COPPER_CHAIN = createBlockItem(UUBlocks.COPPER_CHAIN);
    public static final Item OAK_TURTLE_BOAT = createBoatItem(OAK_TURTLE);
    public static final Item BIRCH_TURTLE_BOAT = createBoatItem(BIRCH_TURTLE);
    public static final Item DARK_OAK_TURTLE_BOAT = createBoatItem(DARK_OAK_TURTLE);
    public static final Item ACACIA_TURTLE_BOAT = createBoatItem(ACACIA_TURTLE);
    public static final Item SPRUCE_TURTLE_BOAT = createBoatItem(SPRUCE_TURTLE);
    public static final Item JUNGLE_TURTLE_BOAT = createBoatItem(JUNGLE_TURTLE);
    public static final Item TRAVELERS_BOOTS = new TravelersBoots(UUArmors.TRAVELERS, EquipmentSlot.FEET, new Item.Properties().tab(TAB));

    public static BlockItem createBlockItem(Block block) {
        return new BlockItem(block, new Item.Properties().tab(TAB));
    }

    public static void register(Register<Item> item) {
        item.register("copper_hopper", COPPER_HOPPER);
        item.register("amethyst_lantern", AMETHYST_LANTERN);
        item.register("amethyst_end_rod", AMETHYST_END_ROD);
        item.register("copper_chain", COPPER_CHAIN);
        item.register("mason_oven", MASON_OVEN);
        item.register("tuff_slab", TUFF_SLAB);
        item.register("tuff_stairs", TUFF_STAIRS);
        item.register("tuff_wall", TUFF_WALL);
        item.register("polished_tuff", POLISHED_TUFF);
        item.register("polished_tuff_slab", POLISHED_TUFF_SLAB);
        item.register("polished_tuff_stairs", POLISHED_TUFF_STAIRS);
        item.register("polished_tuff_wall", POLISHED_TUFF_WALL);
        item.register("tuff_bricks", TUFF_BRICKS);
        item.register("tuff_brick_slab", TUFF_BRICK_SLAB);
        item.register("tuff_brick_stairs", TUFF_BRICK_STAIRS);
        item.register("tuff_brick_wall", TUFF_BRICK_WALL);
        item.register("calcite_slab", CALCITE_SLAB);
        item.register("calcite_stairs", CALCITE_STAIRS);
        item.register("calcite_wall", CALCITE_WALL);
        item.register("polished_calcite", POLISHED_CALCITE);
        item.register("polished_calcite_slab", POLISHED_CALCITE_SLAB);
        item.register("polished_calcite_stairs", POLISHED_CALCITE_STAIRS);
        item.register("polished_calcite_wall", POLISHED_CALCITE_WALL);
        item.register("calcite_bricks", CALCITE_BRICKS);
        item.register("calcite_brick_slab", CALCITE_BRICK_SLAB);
        item.register("calcite_brick_stairs", CALCITE_BRICK_STAIRS);
        item.register("calcite_brick_wall", CALCITE_BRICK_WALL);
        item.register("copper_boots", COPPER_BOOTS);
        item.register("copper_leggings", COPPER_LEGGINGS);
        item.register("copper_chestplate", COPPER_CHESTPLATE);
        item.register("copper_helmet", COPPER_HELMET);
        item.register("raw_llama", RAW_LLAMA);
        item.register("charki", CHARKI);
        item.register("raw_goat", RAW_GOAT);
        item.register("cooked_goat", COOKED_GOAT);
        item.register("horse_bone", HORSE_BONE);
        item.register("fox_fur", FOX_FUR);
        item.register("llama_spit", LLAMA_SPIT);
        item.register("throwable_dragons_breath", THROWABLE_DRAGONS_BREATH);
        item.register("oak_turtle_boat", OAK_TURTLE_BOAT);
        item.register("birch_turtle_boat", BIRCH_TURTLE_BOAT);
        item.register("dark_oak_turtle_boat", DARK_OAK_TURTLE_BOAT);
        item.register("acacia_turtle_boat", ACACIA_TURTLE_BOAT);
        item.register("spruce_turtle_boat", SPRUCE_TURTLE_BOAT);
        item.register("jungle_turtle_boat", JUNGLE_TURTLE_BOAT);
        item.register("travelers_boots", TRAVELERS_BOOTS);

    }

    public static Item createItem() {
        return new Item(new Item.Properties().tab(TAB));
    }

    public static Item createBoatItem(TurtleBoat.ModType type) {
        return new TurtleBoatItem(type, new Item.Properties().stacksTo(1));
    }

    public static Item createArmorItem(ArmorMaterial material, EquipmentSlot slot) {
        return new ArmorItem(material, slot, new Item.Properties().tab(TAB));
    }

    public static Item createFoodItem(FoodProperties food) {
        return new Item(new Item.Properties().tab(TAB).food(food));
    }

}