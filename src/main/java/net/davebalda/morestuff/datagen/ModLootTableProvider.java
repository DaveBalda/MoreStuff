package net.davebalda.morestuff.datagen;

import net.davebalda.morestuff.block.ModBlocks;
import net.davebalda.morestuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    /**
     * Generate method that allows you to set proper loot tables for block drops and more.
     * addDrop() simply makes the block drop itself.
     * oreDrops() makes you decide what to drop with silk touch and w/o silk touch.
     */
    @Override
    public void generate() {
        addDrop(ModBlocks.FINE_REDSTONE_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_GEM_BLOCK);
        addDrop(ModBlocks.SAPPHIRE_GEM_BUTTON);
        addDrop(ModBlocks.SAPPHIRE_GEM_FENCE);
        addDrop(ModBlocks.SAPPHIRE_GEM_FENCE_GATE);
        addDrop(ModBlocks.SAPPHIRE_GEM_PRESSURE_PLATE);
        addDrop(ModBlocks.SAPPHIRE_GEM_TRAPDOOR);
        addDrop(ModBlocks.SAPPHIRE_GEM_STAIRS);
        addDrop(ModBlocks.SAPPHIRE_GEM_WALL);

        addDrop(ModBlocks.SAPPHIRE_GEM_SLAB, slabDrops(ModBlocks.SAPPHIRE_GEM_SLAB));
        addDrop(ModBlocks.SAPPHIRE_GEM_DOOR, doorDrops(ModBlocks.SAPPHIRE_GEM_DOOR));

        addDrop(ModBlocks.SAPPHIRE_ORE, oreDrops(
                ModBlocks.SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE
        ));

        addDrop(ModBlocks.DEEPSLATE_SAPPHIRE_ORE, oreDrops(
                ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE
        ));
    }
}
