
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.registries.Registries;

import net.mcreator.advencedmagic.world.inventory.MagicTableNotesGUIMenu;
import net.mcreator.advencedmagic.world.inventory.MagicTableGUIMenu;
import net.mcreator.advencedmagic.AdvencedMagicMod;

public class AdvencedMagicModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, AdvencedMagicMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<MagicTableGUIMenu>> MAGIC_TABLE_GUI = REGISTRY.register("magic_table_gui", () -> IMenuTypeExtension.create(MagicTableGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MagicTableNotesGUIMenu>> MAGIC_TABLE_NOTES_GUI = REGISTRY.register("magic_table_notes_gui", () -> IMenuTypeExtension.create(MagicTableNotesGUIMenu::new));
}
