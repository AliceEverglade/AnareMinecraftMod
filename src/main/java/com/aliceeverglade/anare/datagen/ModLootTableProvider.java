package com.aliceeverglade.anare.datagen;

import com.aliceeverglade.anare.block.ModBlocks;
import com.aliceeverglade.anare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MYTHRIL_BLOCK);
        addDrop(ModBlocks.RAW_MYTHRIL_BLOCK);
        addDrop(ModBlocks.MYTHRIL_ANVIL_BLOCK);
        addDrop(ModBlocks.MYTHRIL_STAIRS);
        addDrop(ModBlocks.MYTHRIL_FORGE);

        addDrop(ModBlocks.MYTHRIL_ORE,multipleOreDrops(ModBlocks.MYTHRIL_ORE,ModItems.RAW_MYTHRIL,2,4));
        addDrop(ModBlocks.MYTHRIL_DEEPSLATE_ORE,multipleOreDrops(ModBlocks.MYTHRIL_ORE,ModItems.RAW_MYTHRIL,4,7));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops){
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop,this.applyExplosionDecay(drop,((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops,maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
