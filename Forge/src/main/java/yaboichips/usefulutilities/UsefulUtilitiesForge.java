package yaboichips.usefulutilities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import yaboichips.usefulutilities.core.*;

@Mod(UsefulUtilities.MOD_ID)
public class UsefulUtilitiesForge {

    public UsefulUtilitiesForge() {
        UsefulUtilities.init();
        UUTab.init(new CreativeModeTab("usefulutilities.usefulutilities") {
            @Override
            public ItemStack makeIcon() {
                return UUItems.MASON_OVEN.getDefaultInstance();
            }
        });
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::doClientThings);
        bootStrap(eventBus);
    }

    private void doClientThings(final FMLClientSetupEvent event){
    }

    private void bootStrap(IEventBus eventBus) {
        eventBus.addGenericListener(Block.class, this::registerBlocks);
        eventBus.addGenericListener(Item.class, this::registerItems);
        eventBus.addGenericListener(EntityType.class, this::registerEntity);
        eventBus.addGenericListener(MenuType.class, this::registerMenu);
        eventBus.addGenericListener(RecipeSerializer.class, this::registerRecipes);
        eventBus.addGenericListener(BlockEntityType.class, this::registerBlockEntities);

    }

    public void registerBlocks(RegistryEvent.Register<Block> event){
        UUBlocks.register((name, block) -> event.getRegistry().register(block.setRegistryName(UsefulUtilities.createLocation(name))));
    }
    public void registerItems(RegistryEvent.Register<Item> event){
        UUItems.register((name, item) -> event.getRegistry().register(item.setRegistryName(UsefulUtilities.createLocation(name))));
        UURecipeTypes.MASON = RecipeType.register("mason");
    }
    public void registerEntity(RegistryEvent.Register<EntityType<?>> event){
        UUEntities.register((name, entity) -> event.getRegistry().register(entity.setRegistryName(UsefulUtilities.createLocation(name))));
    }
    public void registerMenu(RegistryEvent.Register<MenuType<?>> event){
        UUMenus.register((name, menu) -> event.getRegistry().register(menu.setRegistryName(UsefulUtilities.createLocation(name))));
    }
    public void registerRecipes(RegistryEvent.Register<RecipeSerializer<?>> event){
        UURecipeSerializers.register((name, recipes) -> event.getRegistry().register(recipes.setRegistryName(UsefulUtilities.createLocation(name))));
    }
    public void registerBlockEntities(RegistryEvent.Register<BlockEntityType<?>> event){
        UUTileEntities.register((name, blockentityType) -> event.getRegistry().register(blockentityType.setRegistryName(UsefulUtilities.createLocation(name))));
    }
}