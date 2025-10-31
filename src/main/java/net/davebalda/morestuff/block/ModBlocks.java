package net.davebalda.morestuff.block;

import net.davebalda.morestuff.MoreStuff;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    // PUT NEW BLOCK HERE
    public static final Block FINE_REDSTONE_BLOCK = BlocksBuilder.register(
            "fine_redstone_block",
            RedstoneBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BRIGHT_RED)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
                    .solidBlock(Blocks::never)
    );
    public static final Block SAPPHIRE_GEM_BLOCK = BlocksBuilder.register(
            "sapphire_gem_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .instrument(NoteBlockInstrument.BIT)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
    );
    public static final Block SAPPHIRE_ORE = BlocksBuilder.register(
            "sapphire_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(3.0F, 3.0F)
    );
    public static final Block DEEPSLATE_SAPPHIRE_ORE = BlocksBuilder.register(
            "deepslate_sapphire_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.copy(SAPPHIRE_ORE)
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(4.5F, 3.0F)
                    .sounds(BlockSoundGroup.DEEPSLATE)
    );

    // Register method
    public static void registerModBlocks(){
        MoreStuff.LOGGER.info("Registering blocks for: " + MoreStuff.MOD_ID);
    }
}
