package cc.cclvi.dev.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;

public class VomitEffect extends StatusEffect {
	public VomitEffect() {
		super(StatusEffectCategory.HARMFUL, 0x5e3904);
	}

	@Override
	public boolean canApplyUpdateEffect(int duration, int amplifier) {
		return duration == 1;
	}

	@Override
	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity vomitingPlayer) {
			amplifier = Math.min(8, amplifier);
			HungerManager hm = vomitingPlayer.getHungerManager();
			float level = hm.getFoodLevel();
			float new_level = level * (1 - 0.1f * (amplifier + 1));
			hm.setFoodLevel((int)Math.ceil(new_level));
		}

		return super.applyUpdateEffect(world, entity, amplifier);
	}
}
