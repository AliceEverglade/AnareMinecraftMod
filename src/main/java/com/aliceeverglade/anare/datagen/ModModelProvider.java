package com.aliceeverglade.anare.datagen;

import com.aliceeverglade.anare.block.ModBlocks;
import com.aliceeverglade.anare.block.custom.ArcaneForgeBlock;
import com.aliceeverglade.anare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_MYTHRIL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYTHRIL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYTHRIL_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYTHRIL_ANVIL_BLOCK);

        //Pools
        BlockStateModelGenerator.BlockTexturePool mythrilPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MYTHRIL_BLOCK);
        mythrilPool.stairs(ModBlocks.MYTHRIL_STAIRS);

        //Misc
        Identifier forgeOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.MYTHRIL_FORGE,blockStateModelGenerator.modelCollector);
        Identifier forgeOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.MYTHRIL_FORGE,"_on",Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.MYTHRIL_FORGE)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(ArcaneForgeBlock.LIT,forgeOnIdentifier,forgeOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.RAW_MYTHRIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYTHRIL_BAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.MYTHRIL_HAMMER, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_ESSENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_SEELE_EXTRACT, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VIAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MYTHRIL_DONUT, Models.GENERATED);
    }
}
