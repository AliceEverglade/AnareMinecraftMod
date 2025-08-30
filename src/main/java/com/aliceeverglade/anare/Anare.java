package com.aliceeverglade.anare;

import com.aliceeverglade.anare.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Anare implements ModInitializer {
	public static final String MOD_ID = "anare";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
	}
}