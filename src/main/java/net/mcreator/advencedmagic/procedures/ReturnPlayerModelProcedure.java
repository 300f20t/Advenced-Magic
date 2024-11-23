package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.entity.Entity;

public class ReturnPlayerModelProcedure {
	public static Entity execute(Entity entity) {
		if (entity == null)
			return null;
		return entity;
	}
}
