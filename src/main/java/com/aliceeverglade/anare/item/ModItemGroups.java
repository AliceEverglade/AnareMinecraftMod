package com.aliceeverglade.anare.item;

import com.aliceeverglade.anare.Anare;
import com.aliceeverglade.anare.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup ANARE_MAIN_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Anare.MOD_ID,"anare_main_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_MYTHRIL))
                    .displayName(Text.translatable("itemgroup.anare.main_group"))
                    .entries(((displayContext, entries) ->
                    {
                        entries.add(ModItems.RAW_MYTHRIL);
                        entries.add(ModItems.MYTHRIL_BAR);
                        entries.add((ModBlocks.MYTHRIL_ORE));
                        entries.add(ModBlocks.MYTHRIL_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RAW_MYTHRIL_BLOCK);
                        entries.add(ModBlocks.MYTHRIL_BLOCK);
                        entries.add(ModBlocks.MYTHRIL_ANVIL_BLOCK);
                        entries.add(ModBlocks.MYTHRIL_STAIRS);
                        entries.add(ModItems.MYTHRIL_DONUT);
                        entries.add(ModItems.EMPTY_VIAL);
                        entries.add(ModItems.FIRE_SEELE_EXTRACT);
                        entries.add(ModBlocks.MYTHRIL_FORGE);
                    })).build());

    public static void registerItemGroups()
    {
        Anare.LOGGER.info("Registering Mod Item Groups for " + Anare.MOD_ID);
    }
}
