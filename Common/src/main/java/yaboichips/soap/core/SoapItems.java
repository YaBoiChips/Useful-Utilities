package yaboichips.soap.core;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import yaboichips.soap.common.items.*;
import yaboichips.soap.util.Register;

import java.util.HashMap;

import static yaboichips.soap.core.SoapTab.TAB;


public class SoapItems {

    public static HashMap<String, Item> ITEMS = new HashMap<>();

    public static final Item PAPER_WALL = createBlockItem(SoapBlocks.PAPER_WALL);
    public static final Item ACACIA_PANEL = createBlockItem(SoapBlocks.ACACIA_PANEL);
    public static final Item OAK_PANEL = createBlockItem(SoapBlocks.OAK_PANEL);
    public static final Item DARK_OAK_PANEL = createBlockItem(SoapBlocks.DARK_OAK_PANEL);
    public static final Item SPRUCE_PANEL = createBlockItem(SoapBlocks.SPRUCE_PANEL);
    public static final Item BIRCH_PANEL = createBlockItem(SoapBlocks.BIRCH_PANEL);
    public static final Item MANGROVE_PANEL = createBlockItem(SoapBlocks.MANGROVE_PANEL);
    public static final Item JUNGLE_PANEL = createBlockItem(SoapBlocks.JUNGLE_PANEL);
    public static final Item WARPED_PANEL = createBlockItem(SoapBlocks.WARPED_PANEL);
    public static final Item CRIMSON_PANEL = createBlockItem(SoapBlocks.CRIMSON_PANEL);
    public static final Item CALCITE_PANEL = createBlockItem(SoapBlocks.CALCITE_PANEL);
    public static final Item PRISMARINE_PANEL = createBlockItem(SoapBlocks.PRISMARINE_PANEL);
    public static final Item PURPUR_PANEL = createBlockItem(SoapBlocks.PURPUR_PANEL);
    public static final Item STONE_PANEL = createBlockItem(SoapBlocks.STONE_PANEL);
    public static final Item DEEPSLATE_PANEL = createBlockItem(SoapBlocks.DEEPSLATE_PANEL);

    public static final Item STAINED_PLANKS = createBlockItem(SoapBlocks.STAINED_PLANKS);
    public static final Item STAINED_SLAB = createBlockItem(SoapBlocks.STAINED_SLAB);
    public static final Item STAINED_STAIRS = createBlockItem(SoapBlocks.STAINED_STAIRS);
    //    public static final Item STAINED_DOOR = createBlockItem(SoapBlocks.STAINED_DOOR);
    public static final Item STAINED_TRAPDOOR = createBlockItem(SoapBlocks.STAINED_TRAPDOOR);
    public static final Item STAINED_PRESSURE_PLATE = createBlockItem(SoapBlocks.STAINED_PRESSURE_PLATE);
    public static final Item STAINED_FENCE = createBlockItem(SoapBlocks.STAINED_FENCE);
    public static final Item STAINED_FENCE_GATE = createBlockItem(SoapBlocks.STAINED_FENCE_GATE);

    public static final Item ANGELIC_PLANKS = createBlockItem(SoapBlocks.ANGELIC_PLANKS);
    public static final Item ANGELIC_SLAB = createBlockItem(SoapBlocks.ANGELIC_SLAB);
    public static final Item ANGELIC_STAIRS = createBlockItem(SoapBlocks.ANGELIC_STAIRS);
    public static final Item ANGELIC_DOOR = createBlockItem(SoapBlocks.ANGELIC_DOOR);
    public static final Item ANGELIC_TRAPDOOR = createBlockItem(SoapBlocks.ANGELIC_TRAPDOOR);
    public static final Item ANGELIC_PRESSURE_PLATE = createBlockItem(SoapBlocks.ANGELIC_PRESSURE_PLATE);
    public static final Item ANGELIC_FENCE = createBlockItem(SoapBlocks.ANGELIC_FENCE);
    public static final Item ANGELIC_FENCE_GATE = createBlockItem(SoapBlocks.ANGELIC_FENCE_GATE);
    public static final Item ANGELIC_LOG = createBlockItem(SoapBlocks.ANGELIC_LOG);
    public static final Item ANGELIC_WOOD = createBlockItem(SoapBlocks.ANGELIC_WOOD);

    public static final Item COPPER_HOPPER = createBlockItem(SoapBlocks.COPPER_HOPPER);
    public static final Item ITEM_CALIBRATOR = createBlockItem(SoapBlocks.ITEM_CALIBRATOR);
    public static final Item MASON_OVEN = createBlockItem(SoapBlocks.MASON_OVEN);
    public static final Item LARGE_FURNACE = createBlockItem(SoapBlocks.LARGE_FURNACE);
    public static final Item MIMIC = createBlockItem(SoapBlocks.MIMIC);

    public static final Item PALADINS_GEM = createItem("paladins_gem", new PaladinsGem(new Item.Properties().tab(TAB)));
    public static final Item GLASS_CUTTERS = createItem("glass_cutters", new GlassCutters(1, -2.8f, SoapTiers.GLASS, SoapTags.GLASS, new Item.Properties().tab(TAB)));

    public static final Item FIRE_SWORD = createItem("fire_sword", new FireSword(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().tab(TAB)));
    public static final Item WATER_SWORD = createItem("water_sword", new WaterSword(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().tab(TAB)));
    public static final Item AIR_SWORD = createItem("air_sword", new AirSword(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().tab(TAB)));
    public static final Item LIGHTNING_SWORD = createItem("lightning_sword", new LightningSword(Tiers.DIAMOND, 6, -2.4F, new Item.Properties().tab(TAB)));


    public static final Item TUFF_SLAB = createBlockItem(SoapBlocks.TUFF_SLAB);
    public static final Item TUFF_STAIRS = createBlockItem(SoapBlocks.TUFF_STAIRS);
    public static final Item TUFF_WALL = createBlockItem(SoapBlocks.TUFF_WALL);
    public static final Item POLISHED_TUFF = createBlockItem(SoapBlocks.POLISHED_TUFF);
    public static final Item POLISHED_TUFF_SLAB = createBlockItem(SoapBlocks.POLISHED_TUFF_SLAB);
    public static final Item POLISHED_TUFF_STAIRS = createBlockItem(SoapBlocks.POLISHED_TUFF_STAIRS);
    public static final Item POLISHED_TUFF_WALL = createBlockItem(SoapBlocks.POLISHED_TUFF_WALL);
    public static final Item TUFF_BRICKS = createBlockItem(SoapBlocks.TUFF_BRICKS);
    public static final Item TUFF_BRICK_SLAB = createBlockItem(SoapBlocks.TUFF_BRICK_SLAB);
    public static final Item TUFF_BRICK_STAIRS = createBlockItem(SoapBlocks.TUFF_BRICK_STAIRS);
    public static final Item TUFF_BRICK_WALL = createBlockItem(SoapBlocks.TUFF_BRICK_WALL);


    public static final Item CALCITE_SLAB = createBlockItem(SoapBlocks.CALCITE_SLAB);
    public static final Item CALCITE_STAIRS = createBlockItem(SoapBlocks.CALCITE_STAIRS);
    public static final Item CALCITE_WALL = createBlockItem(SoapBlocks.CALCITE_WALL);
    public static final Item POLISHED_CALCITE = createBlockItem(SoapBlocks.POLISHED_CALCITE);
    public static final Item POLISHED_CALCITE_SLAB = createBlockItem(SoapBlocks.POLISHED_CALCITE_SLAB);
    public static final Item POLISHED_CALCITE_STAIRS = createBlockItem(SoapBlocks.POLISHED_CALCITE_STAIRS);
    public static final Item POLISHED_CALCITE_WALL = createBlockItem(SoapBlocks.POLISHED_CALCITE_WALL);

    public static final Item CALCITE_BRICKS = createBlockItem(SoapBlocks.CALCITE_BRICKS);
    public static final Item CALCITE_BRICK_SLAB = createBlockItem(SoapBlocks.CALCITE_BRICK_SLAB);
    public static final Item CALCITE_BRICK_STAIRS = createBlockItem(SoapBlocks.CALCITE_BRICK_STAIRS);
    public static final Item CALCITE_BRICK_WALL = createBlockItem(SoapBlocks.CALCITE_BRICK_WALL);


    public static final Item COPPER_BOOTS = createArmorItem("copper_boots", SoapArmors.COPPER, EquipmentSlot.FEET);
    public static final Item COPPER_LEGGINGS = createArmorItem("copper_leggings", SoapArmors.COPPER, EquipmentSlot.LEGS);
    public static final Item COPPER_CHESTPLATE = createArmorItem("copper_chestplate", SoapArmors.COPPER, EquipmentSlot.CHEST);
    public static final Item COPPER_HELMET = createArmorItem("copper_helmet", SoapArmors.COPPER, EquipmentSlot.HEAD);

    public static final Item RAW_LLAMA = createFoodItem("raw_llama", SoapFoods.RAW_LLAMA);
    public static final Item CHARKI = createFoodItem("charki", SoapFoods.CHARKI);
    public static final Item RAW_GOAT = createFoodItem("raw_goat", SoapFoods.RAW_GOAT);
    public static final Item COOKED_GOAT = createFoodItem("cooked_goat", SoapFoods.COOKED_GOAT);

    public static final Item HORSE_BONE = createItem("horse_bone", new Item(new Item.Properties().tab(TAB).craftRemainder(Items.BONE)));
    public static final Item FOX_FUR = createItem("fox_fur");
    public static final Item LLAMA_SPIT = createItem("llama_spit");
    public static final Item SUNFLOWER_OIL = createItem("sunflower_oil");
    public static final Item THROWABLE_DRAGONS_BREATH = createItem("throwable_dragons_breath", new ThrowableDragonsBreath(new Item.Properties().tab(TAB)));

    public static final Item AMETHYST_LANTERN = createBlockItem(SoapBlocks.AMETHYST_LANTERN);
    public static final Item AMETHYST_END_ROD = createBlockItem(SoapBlocks.AMETHYST_END_ROD);
    public static final Item COPPER_CHAIN = createBlockItem(SoapBlocks.COPPER_CHAIN);
    public static final Item TRAVELERS_BOOTS = createItem("travelers_boots", new TravelersBoots(SoapArmors.TRAVELERS, EquipmentSlot.FEET, new Item.Properties().tab(TAB)));

    public static Item createBlockItem(Block block) {
        return createItem(Registry.BLOCK.getKey(block).getPath(), new BlockItem(block, new Item.Properties().tab(TAB)));

    }

    public static Item createItem(String id, Item item) {
        ITEMS.put(id, item);
        return item;
    }

    public static void register(Register<Item> item) {
        ITEMS.forEach(item::register);
    }

    public static Item createItem(String id) {
        return createItem(id, new Item(new Item.Properties().tab(TAB)));
    }


    public static Item createArmorItem(String id, ArmorMaterial material, EquipmentSlot slot) {
        return createItem(id, new ArmorItem(material, slot, new Item.Properties().tab(TAB)));
    }

    public static Item createFoodItem(String id, FoodProperties food) {
        return createItem(id, new Item(new Item.Properties().tab(TAB).food(food)));
    }
}