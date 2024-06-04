package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class PlayerManaUsloviiePokazaNalozhieniiaProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("neoforge:modifiable_items")))) {
			assert Boolean.TRUE; //#dbg:PlayerManaUsloviiePokazaNalozhieniia:marker1
			return true;
		}
		return false;
	}
}
