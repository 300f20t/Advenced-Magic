
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.advencedmagic.AdvencedMagicMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvencedMagicModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvencedMagicMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVENCED_MAGIC_CREATIVE_TAB = REGISTRY.register("advenced_magic_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.advenced_magic.advenced_magic_creative_tab")).icon(() -> new ItemStack(AdvencedMagicModBlocks.MAGIC_TABLE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(AdvencedMagicModItems.WOODEN_MAGIC_WAND.get());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TABLE.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_WOOD.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_LOG.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_PLANKS.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_LEAVES.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_STAIRS.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_SLAB.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_FENCE.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_FENCE_GATE.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_PRESSURE_PLATE.get().asItem());
				tabData.accept(AdvencedMagicModBlocks.MAGIC_TREE_BUTTON.get().asItem());
				tabData.accept(AdvencedMagicModItems.IRON_FILE.get());
				tabData.accept(AdvencedMagicModItems.FACETED_DIAMOND.get());
				tabData.accept(AdvencedMagicModItems.FACETED_QUARTZ.get());
				tabData.accept(AdvencedMagicModItems.MAGIC_WOOD_MAGIC_WAND.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AdvencedMagicModItems.IRON_MAGIC_RING.get());
			tabData.accept(AdvencedMagicModItems.GOLDEN_RING.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(AdvencedMagicModItems.IRON_DIAMOND_COATED_FILE.get());
		}
	}
}
