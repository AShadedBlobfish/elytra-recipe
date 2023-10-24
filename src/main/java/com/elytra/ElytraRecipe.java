package com.elytra;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElytraRecipe implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("elytra_recipe");

	public static final Item KEVLAR = new Item(new FabricItemSettings());

	public static final Item ENCHANTED_ENDER_EYE = new Item(new FabricItemSettings().maxCount(16));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registries.ITEM, new Identifier("elytra_recipe", "kevlar"), KEVLAR);
		Registry.register(Registries.ITEM, new Identifier("elytra_recipe", "enchanted_ender_eye"), ENCHANTED_ENDER_EYE);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
			content.addAfter(Items.LEATHER, KEVLAR);
			content.addAfter(Items.ENDER_EYE, ENCHANTED_ENDER_EYE);
		});
		LOGGER.info("Mod loaded successfully");
	}
}