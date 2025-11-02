package net.davebalda.morestuff.datagen;

import net.davebalda.morestuff.block.ModBlocks;
import net.davebalda.morestuff.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool sapphireGemPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SAPPHIRE_GEM_BLOCK);

        sapphireGemPool.stairs(ModBlocks.SAPPHIRE_GEM_STAIRS);
        sapphireGemPool.slab(ModBlocks.SAPPHIRE_GEM_SLAB);
        sapphireGemPool.button(ModBlocks.SAPPHIRE_GEM_BUTTON);
        sapphireGemPool.pressurePlate(ModBlocks.SAPPHIRE_GEM_PRESSURE_PLATE);
        sapphireGemPool.fence(ModBlocks.SAPPHIRE_GEM_FENCE);
        sapphireGemPool.fenceGate(ModBlocks.SAPPHIRE_GEM_FENCE_GATE);
        sapphireGemPool.wall(ModBlocks.SAPPHIRE_GEM_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FINE_REDSTONE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
        blockStateModelGenerator.registerDoor(ModBlocks.SAPPHIRE_GEM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SAPPHIRE_GEM_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.REDSTONE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_REDSTONE_CRYSTAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.RESTORATION_WAND, Models.HANDHELD);
    }
}
