package net.davebalda.morestuff.block;

import net.davebalda.morestuff.MoreStuff;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Block list
    public static final Block FINE_REDSTONE_BLOCK = registerBlock("fine_redstone_block",
            AbstractBlock.Settings.create().strength(5.0F, 6.0F)
                    .mapColor(MapColor.BRIGHT_RED)
                    .requiresTool().sounds(BlockSoundGroup.METAL));

    // Helper method to register blocks
    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreStuff.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    // Helper method to register block items (drops)
    private static void registerBlockItem(String name, Block block){
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks(){
        MoreStuff.LOGGER.info("Registering blocks for: " + MoreStuff.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.FINE_REDSTONE_BLOCK);
        });
    }
}
