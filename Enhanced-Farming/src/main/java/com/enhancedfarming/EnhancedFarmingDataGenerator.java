package com.enhancedfarming;

import com.enhancedfarming.advancements.AdvancementProvider;
import com.enhancedfarming.recipes.RecipeProvider;
import com.enhancedfarming.translations.EnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EnhancedFarmingDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(EnglishLangProvider::new);
		pack.addProvider(AdvancementProvider::new);
		pack.addProvider(RecipeProvider::new);
	}
}
