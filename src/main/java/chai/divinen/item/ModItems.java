package chai.divinen.item;

import chai.divinen.DivineEncounters;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item IDOL = registerItem("idol", Item::new, new Item.Settings());
    public static final Item ZEUS_IDOL = registerItem("zeus_idol", Item::new, new Item.Settings());

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DivineEncounters.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static void initializeItems() {
        DivineEncounters.LOGGER.info("Registering ModItems for " + DivineEncounters.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> {
            itemGroup.add(IDOL);
            itemGroup.add(ZEUS_IDOL);
        });
    }
}
