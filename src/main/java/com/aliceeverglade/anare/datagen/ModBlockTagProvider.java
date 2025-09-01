package com.aliceeverglade.anare.datagen;

import com.aliceeverglade.anare.block.ModBlocks;
import com.aliceeverglade.anare.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_MYTHRIL_BLOCK)
                .add(ModBlocks.MYTHRIL_BLOCK)
                .add(ModBlocks.MYTHRIL_ANVIL_BLOCK)
                .add(ModBlocks.MYTHRIL_ORE)
                .add(ModBlocks.MYTHRIL_DEEPSLATE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.RAW_MYTHRIL_BLOCK)
                .add(ModBlocks.MYTHRIL_BLOCK)
                .add(ModBlocks.MYTHRIL_ANVIL_BLOCK)
                .add(ModBlocks.MYTHRIL_ORE)
                .add(ModBlocks.MYTHRIL_DEEPSLATE_ORE);
    }
}
