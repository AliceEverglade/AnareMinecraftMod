package com.aliceeverglade.anare.util;

import com.aliceeverglade.anare.Anare;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Anare.MOD_ID,name));
        }
    }
    public static class Items{
        public static final TagKey<Item> ESSENCE_DEGRADABLE_FIRE = createTag("essence_degradable_fire");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Anare.MOD_ID,name));
        }
    }
}
