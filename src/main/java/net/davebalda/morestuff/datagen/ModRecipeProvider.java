package net.davebalda.morestuff.datagen;

import net.davebalda.morestuff.block.ModBlocks;
import net.davebalda.morestuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                // Lists of ItemConvertible for multiple output recipes
                List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(
                        ModItems.RAW_SAPPHIRE,
                        ModBlocks.SAPPHIRE_ORE,
                        ModBlocks.DEEPSLATE_SAPPHIRE_ORE
                );

                // Single ItemConvertible for single smelting recipes
                ItemConvertible SAPPHIRE = ModItems.SAPPHIRE;
                ItemConvertible RAW_REDSTONE_CRYSTAL = ModItems.RAW_REDSTONE_CRYSTAL;

                // Smelting-Blasting recipes
                offerSmelting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1, 200, "sapphire");
                offerBlasting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE, 1, 100, "sapphire");
                offerSmelting(List.of(RAW_REDSTONE_CRYSTAL), RecipeCategory.MISC, ModItems.REDSTONE_CRYSTAL, 1, 200, "redstone_crystal");
                offerBlasting(List.of(RAW_REDSTONE_CRYSTAL), RecipeCategory.MISC, ModItems.REDSTONE_CRYSTAL, 1, 100, "redstone_crystal");
                offerSmelting(List.of(SAPPHIRE), RecipeCategory.MISC, ModItems.SAPPHIRE_GEM, 1.5F, 400, "sapphire_gem");
                offerBlasting(List.of(SAPPHIRE), RecipeCategory.MISC, ModItems.SAPPHIRE_GEM, 1.5F, 200, "sapphire_gem");

                // Compacted recipes (compacted block to 9 items and vice versa)
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.REDSTONE_CRYSTAL, RecipeCategory.DECORATIONS, ModBlocks.FINE_REDSTONE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE_GEM, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_GEM_BLOCK);

                // Shaped recipes
                createShaped(RecipeCategory.TOOLS, ModItems.RESTORATION_WAND)
                        .pattern("  G")
                        .pattern(" G ")
                        .pattern("R  ")
                        .input('R', Items.BLAZE_ROD)
                        .input('G', ModItems.SAPPHIRE_GEM)
                        .criterion(hasItem(ModItems.SAPPHIRE_GEM), conditionsFromItem(ModItems.SAPPHIRE_GEM))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_GEM_FENCE, 3)
                        .pattern("BSB")
                        .pattern("BSB")
                        .input('B', ModBlocks.SAPPHIRE_GEM_BLOCK)
                        .input('S', ModItems.SAPPHIRE)
                        .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_GEM_FENCE_GATE)
                        .pattern("SBS")
                        .pattern("SBS")
                        .input('B', ModBlocks.SAPPHIRE_GEM_BLOCK)
                        .input('S', ModItems.SAPPHIRE)
                        .criterion(hasItem(ModItems.SAPPHIRE), conditionsFromItem(ModItems.SAPPHIRE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.SAPPHIRE_GEM_STAIRS, Ingredient.ofItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .criterion(hasItem(ModBlocks.SAPPHIRE_GEM_BLOCK), conditionsFromItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_GEM_SLAB, ModBlocks.SAPPHIRE_GEM_BLOCK);
                createButtonRecipe(ModBlocks.SAPPHIRE_GEM_BUTTON, Ingredient.ofItem(ModItems.SAPPHIRE_GEM))
                        .criterion(hasItem(ModItems.SAPPHIRE_GEM), conditionsFromItem(ModItems.SAPPHIRE_GEM))
                        .offerTo(exporter);
                offerPressurePlateRecipe(ModBlocks.SAPPHIRE_GEM_PRESSURE_PLATE, ModBlocks.SAPPHIRE_GEM_BLOCK);
                createDoorRecipe(ModBlocks.SAPPHIRE_GEM_DOOR, Ingredient.ofItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .criterion(hasItem(ModBlocks.SAPPHIRE_GEM_BLOCK), conditionsFromItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.SAPPHIRE_GEM_TRAPDOOR, Ingredient.ofItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .criterion(hasItem(ModBlocks.SAPPHIRE_GEM_BLOCK), conditionsFromItem(ModBlocks.SAPPHIRE_GEM_BLOCK))
                        .offerTo(exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_GEM_WALL, ModBlocks.SAPPHIRE_GEM_BLOCK);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
