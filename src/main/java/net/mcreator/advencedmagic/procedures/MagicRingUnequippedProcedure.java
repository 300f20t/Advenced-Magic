package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;

public class MagicRingUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
			_vars.max_player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana - 20;
			_vars.syncPlayerVariables(entity);
		}
	}
}
