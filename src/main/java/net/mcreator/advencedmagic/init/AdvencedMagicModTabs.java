
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.advencedmagic.AdvencedMagicMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AdvencedMagicModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvencedMagicMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVENCED_MAGIC_CREATIVE_TAB = REGISTRY.register("advenced_magic_creative_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.advenced_magic.advenced_magic_creative_tab")).icon(() -> new ItemStack(AdvencedMagicModBlocks.MAGIC_TABLE.get())).displayItems((parameters, tabData) -> {
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
				tabData.accept(AdvencedMagicModItems.IRON_DIAMOND_COATED_FILE.get());
				tabData.accept(AdvencedMagicModItems.IRON_HAMMER.get());
				tabData.accept(AdvencedMagicModItems.MAGIC_WAND_WITH_FIRE_GEM.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(AdvencedMagicModBlocks.HIGH_QUALITY_WATER_GEM_ORE.get().asItem());
			tabData.accept(AdvencedMagicModBlocks.HIGH_QUALITY_WATER_GEM_BLOCK.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AdvencedMagicModItems.GOLDEN_RING.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(AdvencedMagicModItems.HIGH_QUALITY_WATER_GEM.get());
		}
	}
}
