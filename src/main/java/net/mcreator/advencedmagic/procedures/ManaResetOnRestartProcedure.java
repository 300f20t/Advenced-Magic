package net.mcreator.advencedmagic.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;
import net.mcreator.advencedmagic.init.AdvencedMagicModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaResetOnRestartProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(AdvencedMagicModItems.IRON_MAGIC_RING.get(), lv).isPresent() : false) {
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.max_player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana - 20;
				_vars.syncPlayerVariables(entity);
			}
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(AdvencedMagicModItems.GOLDEN_RING.get(), lv).isPresent() : false) {
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.max_player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).max_player_mana - 40;
				_vars.syncPlayerVariables(entity);
			}
		}
	}
}
