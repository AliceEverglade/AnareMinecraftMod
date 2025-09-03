package com.aliceeverglade.anare.block;

import com.aliceeverglade.anare.Anare;
import com.aliceeverglade.anare.block.custom.ArcaneAnvilBlock;
import com.aliceeverglade.anare.block.custom.ArcaneForgeBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block MYTHRIL_BLOCK = registerBlock("mythril_block",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.CALCITE)));

    public static final Block MYTHRIL_ORE = registerBlock("mythril_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.STONE)));

    public static final Block MYTHRIL_DEEPSLATE_ORE = registerBlock("mythril_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4,7),
                    AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MYTHRIL_ANVIL_BLOCK = registerBlock("mythril_anvil_block",
            new ArcaneAnvilBlock(AbstractBlock.Settings.create().strength(7f).requiresTool().sounds(BlockSoundGroup.ANVIL)));

    public static final Block MYTHRIL_STAIRS = registerBlock("mythril_stairs",
            new StairsBlock(ModBlocks.MYTHRIL_BLOCK.getDefaultState(),AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block MYTHRIL_FORGE = registerBlock("mythril_forge",
            new ArcaneForgeBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()
                    .luminance(state -> state.get(ArcaneForgeBlock.LIT) ? 15 : 0)));

    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK,Identifier.of(Anare.MOD_ID,name),block);
    }

    private static void registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(Anare.MOD_ID,name),
                new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        Anare.LOGGER.info("Registering Mod Blocks for " + Anare.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register( entries ->
        {
            entries.add(ModBlocks.MYTHRIL_BLOCK);
            entries.add(ModBlocks.RAW_MYTHRIL_BLOCK);
        });
    }
}
