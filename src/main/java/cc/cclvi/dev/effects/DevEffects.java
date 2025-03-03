package cc.cclvi.dev.effects;

import cc.cclvi.dev.Dev;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class DevEffects implements ModInitializer {
	public static final RegistryEntry<StatusEffect> VOMIT = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Dev.MOD_ID, "vomit"), new VomitEffect());

	@Override
	public void onInitialize() {

	}
}
