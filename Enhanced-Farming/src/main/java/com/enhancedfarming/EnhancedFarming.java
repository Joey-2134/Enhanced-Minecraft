package com.enhancedfarming;

import com.enhancedfarming.blocks.ModBlockEntities;
import com.enhancedfarming.blocks.ModBlocks;
import com.enhancedfarming.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.enhancedfarming.blocks.ModBlocks.ENHANCED_FARMING_BLOCKS;
import static com.enhancedfarming.items.ModItems.ENHANCED_FARMING_ITEMS;

public class EnhancedFarming implements ModInitializer {
	public static final String MOD_ID = "enhanced-farming";
	public static final String MOD_NAME = "Enhanced Farming";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<ItemGroup> ENHANCED_FARMING_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "item_group"));
	public static final ItemGroup ENHANCED_FARMING_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ModItems.FERTILIZER))
			.displayName(Text.translatable("itemGroup.enhanced-farming-group"))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing {}", MOD_ID);
		ModItems.initialize();
		ModBlocks.initialize();
		ModBlockEntities.initialize();

		addModItemsToCustomModGroup();
	}

	/**
	 * Creates custom item group and adds all mod blocks to it
	 */
	private static void addModItemsToCustomModGroup() {
		Registry.register(Registries.ITEM_GROUP, ENHANCED_FARMING_GROUP_KEY, ENHANCED_FARMING_GROUP);
		ItemGroupEvents.modifyEntriesEvent(ENHANCED_FARMING_GROUP_KEY)
				.register(itemGroup -> {
					ENHANCED_FARMING_ITEMS.forEach(itemGroup::add);
					ENHANCED_FARMING_BLOCKS.forEach((block) -> {
						itemGroup.add(block.asItem());
					});
				});
	}
}