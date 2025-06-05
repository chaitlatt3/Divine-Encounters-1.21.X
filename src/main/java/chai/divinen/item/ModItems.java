package chai.divinen.item;

import chai.divinen.DivineEncounters;
import chai.divinen.item.custom.IdolItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // Mod Group tab in Minecraft Creative Mode
    public static final RegistryKey<ItemGroup> DIVINE_ENCOUNTERS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(DivineEncounters.MOD_ID, "item_group"));
    public static final ItemGroup DIVINE_ENCOUNTERS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.IDOL))
            .displayName(Text.translatable("itemGroup.divinen"))
            .build();

    // Mod Items
    public static final Item AMBROSIA = registerItem("ambrosia", Item::new, new Item.Settings().food(ModFoodComponents.DIVINE_FOOD_COMPONENT, ModFoodComponents.AMBROSIA_COMPONENT));
    public static final Item DRIED_HERBS = registerItem("dried_herbs", Item::new, new Item.Settings().food(ModFoodComponents.DIVINE_FOOD_COMPONENT));
    public static final Item FRESH_HERBS = registerItem("fresh_herbs", Item::new, new Item.Settings().food(ModFoodComponents.DIVINE_FOOD_COMPONENT));

    public static final Item IDOL = registerItem("idol", IdolItem::new, new IdolItem.Settings().maxCount(1));
    public static final Item ZEUS_IDOL = registerItem("zeus_idol", IdolItem::new, new IdolItem.Settings().maxCount(1));

    public static final Item DIVINE_ESSENCE = registerItem("divine_essence", Item::new, new Item.Settings());
    public static final Item CERAMIC_PIECE = registerItem("ceramic_piece", Item::new, new Item.Settings());


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
        Registry.register(Registries.ITEM_GROUP, DIVINE_ENCOUNTERS_ITEM_GROUP_KEY, DIVINE_ENCOUNTERS_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(DIVINE_ENCOUNTERS_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(IDOL);
            itemGroup.add(ZEUS_IDOL);
            itemGroup.add(AMBROSIA);
            itemGroup.add(DIVINE_ESSENCE);
            itemGroup.add(CERAMIC_PIECE);
            itemGroup.add(DRIED_HERBS);
            itemGroup.add(FRESH_HERBS);
        });
    }
}
