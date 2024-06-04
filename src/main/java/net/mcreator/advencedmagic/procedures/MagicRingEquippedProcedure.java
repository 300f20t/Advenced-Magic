package net.mcreator.advencedmagic.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;
import net.mcreator.advencedmagic.init.AdvencedMagicModItems;

public class MagicRingEquippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(AdvencedMagicModItems.IRON_MAGIC_RING.get(), lv).isPresent() : false) {
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.max_player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana + 20;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
