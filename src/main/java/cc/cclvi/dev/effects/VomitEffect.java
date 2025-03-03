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
		if (duration > 0) {
			return duration % 20 == 0;
		} else {
			return false;
		}
	}

	@Override
	public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
		if (entity instanceof PlayerEntity) {
			PlayerEntity vomitingPlayer = (PlayerEntity) entity;
			HungerManager hm = vomitingPlayer.getHungerManager();
			float level = hm.getFoodLevel() + hm.getSaturationLevel();
			vomitingPlayer.addExhaustion(4 * 1.4f * 0.113431849435f * (amplifier + 1) * level / 33f * 28f);
		}

		return super.applyUpdateEffect(world, entity, amplifier);
	}
}
