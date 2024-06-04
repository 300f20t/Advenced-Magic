package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;

public class MaxManaInfoProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "" + entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana;
	}
}
