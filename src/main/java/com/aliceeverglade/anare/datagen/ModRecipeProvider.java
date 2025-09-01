package com.aliceeverglade.anare.datagen;

import com.aliceeverglade.anare.Anare;
import com.aliceeverglade.anare.block.ModBlocks;
import com.aliceeverglade.anare.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        //Mythril
        List<ItemConvertible> MYTHRIL_BAR_SMELTABLES = List.of(ModItems.RAW_MYTHRIL, ModBlocks.MYTHRIL_ORE,ModBlocks.MYTHRIL_DEEPSLATE_ORE);
        offerSmelting(recipeExporter,MYTHRIL_BAR_SMELTABLES, RecipeCategory.MISC,ModItems.MYTHRIL_BAR,1f,200,"mythril");
        offerBlasting(recipeExporter,MYTHRIL_BAR_SMELTABLES, RecipeCategory.MISC,ModItems.MYTHRIL_BAR,2f,100,"mythril");

        //Compacting
        offerReversibleCompactingRecipes(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModItems.MYTHRIL_BAR,RecipeCategory.DECORATIONS,ModBlocks.MYTHRIL_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter,RecipeCategory.BUILDING_BLOCKS,ModItems.RAW_MYTHRIL,RecipeCategory.DECORATIONS,ModBlocks.RAW_MYTHRIL_BLOCK);

        //Shaped
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MYTHRIL_DONUT,12)
                .pattern("XXX")
                .pattern("XOX")
                .pattern("XXX")
                .input('X', ModBlocks.MYTHRIL_BLOCK)
                .input('O', Blocks.HAY_BLOCK)
                .criterion(hasItem(ModBlocks.MYTHRIL_BLOCK),conditionsFromItem(ModBlocks.MYTHRIL_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MYTHRIL_HAMMER)
                .pattern(" XX")
                .pattern(" OX")
                .pattern("O  ")
                .input('X', ModBlocks.MYTHRIL_BLOCK)
                .input('O', Items.STICK)
                .criterion(hasItem(ModBlocks.MYTHRIL_BLOCK),conditionsFromItem(ModBlocks.MYTHRIL_BLOCK))
                .offerTo(recipeExporter);

        //Shapeless
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.FIRE_SEELE_EXTRACT)
                .input(ModItems.FIRE_ESSENCE,8)
                .input(ModItems.EMPTY_VIAL)
                .criterion(hasItem(ModItems.FIRE_ESSENCE),conditionsFromItem(ModItems.FIRE_ESSENCE))
                .offerTo(recipeExporter, Identifier.of(Anare.MOD_ID,"fire_extract_recipe"));
    }
}
