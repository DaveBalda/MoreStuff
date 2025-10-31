package net.davebalda.morestuff.item;

import net.davebalda.morestuff.MoreStuff;
import net.davebalda.morestuff.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MORE_STUFF_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MoreStuff.MOD_ID, "more_stuff_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.REDSTONE_CRYSTAL))
                    .displayName(Text.translatable("itemgroup.morestuff.more_stuff_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.REDSTONE_CRYSTAL);
                        entries.add(ModItems.RAW_REDSTONE_CRYSTAL);
                        entries.add(ModBlocks.FINE_REDSTONE_BLOCK);
                        entries.add(ModItems.SAPPHIRE_GEM);
                        entries.add(ModItems.SAPPHIRE);
                        entries.add(ModItems.RAW_SAPPHIRE);
                        entries.add(ModBlocks.SAPPHIRE_GEM_BLOCK);
                        entries.add(ModBlocks.SAPPHIRE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
                        entries.add(ModItems.RESTORATION_WAND);
                    })
                    .build());

    public static void registerItemGroups() {
        MoreStuff.LOGGER.info("Registering item groups for: " + MoreStuff.MOD_ID);
    }
}
