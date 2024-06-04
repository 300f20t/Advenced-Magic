
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.advencedmagic.item.WoodenMagicWandItem;
import net.mcreator.advencedmagic.item.MagicWoodMagicWandItem;
import net.mcreator.advencedmagic.item.IronMagicRingItem;
import net.mcreator.advencedmagic.item.IronFileItem;
import net.mcreator.advencedmagic.item.IronDiamondCoatedFileItem;
import net.mcreator.advencedmagic.item.GoldenRingItem;
import net.mcreator.advencedmagic.item.FacetedQuartzItem;
import net.mcreator.advencedmagic.item.FacetedDiamondItem;
import net.mcreator.advencedmagic.AdvencedMagicMod;

public class AdvencedMagicModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, AdvencedMagicMod.MODID);
	public static final DeferredHolder<Item, Item> WOODEN_MAGIC_WAND = REGISTRY.register("wooden_magic_wand", () -> new WoodenMagicWandItem());
	public static final DeferredHolder<Item, Item> MAGIC_TABLE = block(AdvencedMagicModBlocks.MAGIC_TABLE);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_WOOD = block(AdvencedMagicModBlocks.MAGIC_TREE_WOOD);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_LOG = block(AdvencedMagicModBlocks.MAGIC_TREE_LOG);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_PLANKS = block(AdvencedMagicModBlocks.MAGIC_TREE_PLANKS);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_LEAVES = block(AdvencedMagicModBlocks.MAGIC_TREE_LEAVES);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_STAIRS = block(AdvencedMagicModBlocks.MAGIC_TREE_STAIRS);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_SLAB = block(AdvencedMagicModBlocks.MAGIC_TREE_SLAB);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_FENCE = block(AdvencedMagicModBlocks.MAGIC_TREE_FENCE);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_FENCE_GATE = block(AdvencedMagicModBlocks.MAGIC_TREE_FENCE_GATE);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_PRESSURE_PLATE = block(AdvencedMagicModBlocks.MAGIC_TREE_PRESSURE_PLATE);
	public static final DeferredHolder<Item, Item> MAGIC_TREE_BUTTON = block(AdvencedMagicModBlocks.MAGIC_TREE_BUTTON);
	public static final DeferredHolder<Item, Item> IRON_FILE = REGISTRY.register("iron_file", () -> new IronFileItem());
	public static final DeferredHolder<Item, Item> IRON_DIAMOND_COATED_FILE = REGISTRY.register("iron_diamond_coated_file", () -> new IronDiamondCoatedFileItem());
	public static final DeferredHolder<Item, Item> FACETED_DIAMOND = REGISTRY.register("faceted_diamond", () -> new FacetedDiamondItem());
	public static final DeferredHolder<Item, Item> FACETED_QUARTZ = REGISTRY.register("faceted_quartz", () -> new FacetedQuartzItem());
	public static final DeferredHolder<Item, Item> IRON_MAGIC_RING = REGISTRY.register("iron_magic_ring", () -> new IronMagicRingItem());
	public static final DeferredHolder<Item, Item> MAGIC_WOOD_MAGIC_WAND = REGISTRY.register("magic_wood_magic_wand", () -> new MagicWoodMagicWandItem());
	public static final DeferredHolder<Item, Item> GOLDEN_RING = REGISTRY.register("golden_ring", () -> new GoldenRingItem());

	// Start of user code block custom items
	// End of user code block custom items
	public static void register(IEventBus bus) {
		REGISTRY.register(bus);
	}

	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
