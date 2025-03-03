package cc.cclvi.dev;

import cc.cclvi.dev.effects.VomitEffect;
import cc.cclvi.dev.items.DevItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dev implements ModInitializer {
	public static final String MOD_ID = "dev";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		DevItems.initialize();
		CompostingChanceRegistry.INSTANCE.add(DevItems.SHIT, 1f);
		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(DevItems.SAND_POWDER, 18 * 10 * 20);
		}));


		LOGGER.info("Hello Fabric world!");
	}
}