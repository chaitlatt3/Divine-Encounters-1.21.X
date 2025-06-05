package chai.divinen.block;

import chai.divinen.DivineEncounters;
import chai.divinen.block.custom.AltarBlock;
import chai.divinen.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ALTAR = registerBlock("altar", AltarBlock::new,
            AbstractBlock.Settings.create().strength(1f).requiresTool(), true);

    /* Register a new block */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create registry key for block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the new block
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Create an item for the block
        if(shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    /* Return a registry key for the block */
    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DivineEncounters.MOD_ID, name));
    }
    /* Return a registry key for an item of the block */
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DivineEncounters.MOD_ID, name));
    }

    /* Initialize new Blocks */
    public static void initializeBlocks() {
        DivineEncounters.LOGGER.info("Registering ModBlocks for " + DivineEncounters.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ModItems.DIVINE_ENCOUNTERS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.ALTAR.asItem());
        });
    }
}
