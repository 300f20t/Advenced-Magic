package net.mcreator.advencedmagic.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.advencedmagic.procedures.PlayerManaUsloviiePokazaNalozhieniiaProcedure;
import net.mcreator.advencedmagic.procedures.MaxManaInfoProcedure;
import net.mcreator.advencedmagic.procedures.ManaInfoProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PlayerManaOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (PlayerManaUsloviiePokazaNalozhieniiaProcedure.execute(entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.advenced_magic.player_mana.label_max_mana"), 10, 30, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.advenced_magic.player_mana.label_player_mana"), 10, 10, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					MaxManaInfoProcedure.execute(entity), 60, 30, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ManaInfoProcedure.execute(entity), 75, 10, -1, false);
		}
	}
}
