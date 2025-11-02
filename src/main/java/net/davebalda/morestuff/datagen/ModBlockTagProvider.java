package net.davebalda.morestuff.datagen;

import net.davebalda.morestuff.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FINE_REDSTONE_BLOCK)
                .add(ModBlocks.SAPPHIRE_GEM_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.SAPPHIRE_GEM_STAIRS)
                .add(ModBlocks.SAPPHIRE_GEM_SLAB)
                .add(ModBlocks.SAPPHIRE_GEM_BUTTON)
                .add(ModBlocks.SAPPHIRE_GEM_DOOR)
                .add(ModBlocks.SAPPHIRE_GEM_TRAPDOOR)
                .add(ModBlocks.SAPPHIRE_GEM_FENCE)
                .add(ModBlocks.SAPPHIRE_GEM_FENCE_GATE)
                .add(ModBlocks.SAPPHIRE_GEM_WALL)
                .add(ModBlocks.SAPPHIRE_GEM_PRESSURE_PLATE);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.SAPPHIRE_GEM_BLOCK);
        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.SAPPHIRE_GEM_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SAPPHIRE_GEM_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.SAPPHIRE_GEM_WALL);
    }
}
