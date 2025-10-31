package net.davebalda.morestuff.item;

import net.davebalda.morestuff.MoreStuff;
import net.davebalda.morestuff.item.custom.RestorationWandItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Item list with ID and registry keys
    public static final Item RESTORATION_WAND = registerItem("restoration_wand", new RestorationWandItem(
            new Item.Settings().maxCount(1).maxDamage(500)
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "restoration_wand")))
    ));
    public static final Item REDSTONE_CRYSTAL = registerItem("redstone_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "redstone_crystal")))
    ));
    public static final Item RAW_REDSTONE_CRYSTAL = registerItem("raw_redstone_crystal", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "raw_redstone_crystal")))
    ));
    public static final Item SAPPHIRE_GEM = registerItem("sapphire_gem", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "sapphire_gem")))
    ));
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "sapphire")))
    ));
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, "raw_sapphire")))
    ));

    // Helper method to register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreStuff.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreStuff.LOGGER.info("Registering items for: " + MoreStuff.MOD_ID);
    }
}
