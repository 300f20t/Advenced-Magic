
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.advencedmagic.client.gui.Note1Screen;
import net.mcreator.advencedmagic.client.gui.MagicTableNotesGUIScreen;
import net.mcreator.advencedmagic.client.gui.MagicTableGUIScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AdvencedMagicModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(AdvencedMagicModMenus.MAGIC_TABLE_GUI.get(), MagicTableGUIScreen::new);
		event.register(AdvencedMagicModMenus.MAGIC_TABLE_NOTES_GUI.get(), MagicTableNotesGUIScreen::new);
		event.register(AdvencedMagicModMenus.NOTE_1.get(), Note1Screen::new);
	}
}
