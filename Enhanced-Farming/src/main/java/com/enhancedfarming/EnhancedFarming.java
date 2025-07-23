package com.enhancedfarming;

import com.enhancedfarming.items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnhancedFarming implements ModInitializer {
	public static final String MOD_ID = "enhanced-farming";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_ID);
		ModItems.initialize();
	}
}