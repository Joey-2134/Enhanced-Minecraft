package com.enhancedfarming;

import com.enhancedfarming.tags.EnglishLangProvider;
import com.enhancedfarming.tags.FertilizableBlockTag;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.Registries;

public class EnhancedFarmingDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(
				(output, registriesFuture) ->
						new FertilizableBlockTag(output, Registries.BLOCK.getKey(), registriesFuture)
		);

		pack.addProvider(EnglishLangProvider::new);
	}
}
