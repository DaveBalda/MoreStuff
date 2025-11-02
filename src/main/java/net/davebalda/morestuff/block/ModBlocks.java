package net.davebalda.morestuff.block;

import net.davebalda.morestuff.MoreStuff;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
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
    public static final Block SAPPHIRE_GEM_STAIRS = BlocksBuilder.registerStairsBlock( "sapphire_gem_stairs", ModBlocks.SAPPHIRE_GEM_BLOCK);
    public static final Block SAPPHIRE_GEM_SLAB = BlocksBuilder.registerSlabBlock("sapphire_gem_slab", ModBlocks.SAPPHIRE_GEM_BLOCK);
    public static final Block SAPPHIRE_GEM_BUTTON = BlocksBuilder.register("sapphire_gem_button",
            settings -> new ButtonBlock(BlockSetType.IRON, 20, settings),
            BlocksBuilder.createButtonSettings()
    );
    public static final Block SAPPHIRE_GEM_PRESSURE_PLATE = BlocksBuilder.register(
            "sapphire_gem_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .solid()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SAPPHIRE_GEM_FENCE = BlocksBuilder.register(
            "sapphire_gem_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .instrument(NoteBlockInstrument.BIT)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
    );
    public static final Block SAPPHIRE_GEM_FENCE_GATE = BlocksBuilder.register(
            "sapphire_gem_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(SAPPHIRE_GEM_BLOCK.getDefaultMapColor())
                    .solid()
                    .instrument(NoteBlockInstrument.BIT)
                    .strength(5.0F, 6.0F)
    );
    public static final Block SAPPHIRE_GEM_WALL = BlocksBuilder.registerWallBlock("sapphire_gem_wall", ModBlocks.SAPPHIRE_GEM_BLOCK);
    public static final Block SAPPHIRE_GEM_DOOR = BlocksBuilder.register(
            "sapphire_gem_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .strength(5.0F)
                    .nonOpaque()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SAPPHIRE_GEM_TRAPDOOR = BlocksBuilder.register(
            "sapphire_gem_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BLUE)
                    .requiresTool()
                    .strength(5.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
    );

    // Register method
    public static void registerModBlocks(){
        MoreStuff.LOGGER.info("Registering blocks for: " + MoreStuff.MOD_ID);
    }
}
