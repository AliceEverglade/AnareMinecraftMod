package com.aliceeverglade.anare.item;

import com.aliceeverglade.anare.Anare;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_MYTHRIL = registerItem("raw_mythril", new Item(new Item.Settings()));
    public static final Item MYTHRIL_BAR = registerItem("mythril_bar",new Item((new Item.Settings())));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(Anare.MOD_ID,name),item);
    }
    public static void registerModItems()
    {
        Anare.LOGGER.info("Registering Mod Items for " + Anare.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
        {
            entries.add(RAW_MYTHRIL);
            entries.add(MYTHRIL_BAR);
        });
    }
}
