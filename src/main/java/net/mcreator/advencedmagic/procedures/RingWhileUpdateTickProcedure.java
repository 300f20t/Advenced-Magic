package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;

public class RingWhileUpdateTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean isEquipped = false;
		isEquipped = true;
		if (entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana < entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana
				&& !(entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack.getItem()))) {
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana + 6;
				_vars.syncPlayerVariables(entity);
			}
		}
		if (entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana > entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana) {
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
