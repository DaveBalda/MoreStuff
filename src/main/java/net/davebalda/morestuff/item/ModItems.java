package net.davebalda.morestuff.item;

import net.davebalda.morestuff.MoreStuff;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

/**
 * Classe per la gestione e la creazione di nuovi items.
 * Non viene registrata texture ne nome.
 */
public class ModItems {
    // Item list with ID and registry keys
    public static final Item REDSTONE_CRYSTAL = registerItem("redstone_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "redstone_crystal")))
    ));
    public static final Item RAW_REDSTONE_CRYSTAL = registerItem("raw_redstone_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "raw_redstone_crystal")))
    ));

    // Helper method to register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreStuff.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreStuff.LOGGER.info("Registering items for: " + MoreStuff.MOD_ID);
    }
}
