package net.davebalda.morestuff.block;

import net.davebalda.morestuff.MoreStuff;
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

public class BlocksBuilder {
    /**
     * Helper class to create the registry key for the block.
     * It simply puts the ID of the block inside the mod identifier and
     * creates its registry key.
     * @param id
     * @return
     */
    private static RegistryKey<Block> keyOfBlock(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoreStuff.MOD_ID, id));
    }

    /**
     * Helper class to create the registry key for the block item.
     * It simply puts the ID of the block inside the mod identifier and
     * creates its item's registry key.
     * @param id
     * @return
     */
    private static RegistryKey<Item> keyOfItem(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreStuff.MOD_ID, id));
    }

    /**
     * Register function to create a block and its block item.
     * It uses a factory to simplify the job of handling different type of blocks.
     * It automatically creates the block and its item but it only returns the
     * registry of the block.
     * @param id
     * @param factory
     * @param settings
     * @return
     */
    public static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        RegistryKey<Block> blockKey = keyOfBlock(id);
        RegistryKey<Item> itemKey = keyOfItem(id);
        Block block = factory.apply(settings.registryKey(blockKey));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return Registry.register(Registries.BLOCK, blockKey, block);
    }
}
