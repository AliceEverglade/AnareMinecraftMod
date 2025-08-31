package com.aliceeverglade.anare.item;

import com.aliceeverglade.anare.Anare;
import com.aliceeverglade.anare.item.custom.HammerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril", new Item(new Item.Settings()));
    public static final Item MYTHRIL_BAR = registerItem("mythril_bar",new Item((new Item.Settings())));

    public static final Item MYTHRIL_HAMMER = registerItem("mythril_hammer",new HammerItem(new Item.Settings().maxDamage(100)));
    public static final Item MYTHRIL_DONUT = registerItem("mythril_donut",new Item(new Item.Settings().food(ModFoodComponents.MYTHRIL_DONUT)));
    public static final Item EMPTY_VIAL = registerItem("empty_vial",new Item(new Item.Settings().fireproof()));
    public static final Item FIRE_SEELE_EXTRACT = registerItem("fire_seele_extract",new Item(new Item.Settings().fireproof()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Anare.MOD_ID,name),item);
    }
    public static void registerModItems()
    {
        FuelRegistry.INSTANCE.add(ModItems.FIRE_SEELE_EXTRACT, 2400);

        Anare.LOGGER.info("Registering Mod Items for " + Anare.MOD_ID);
    }
}
