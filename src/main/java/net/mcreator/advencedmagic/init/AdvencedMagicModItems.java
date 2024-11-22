
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.advencedmagic.item.MagicWandWithFireGemItem;
import net.mcreator.advencedmagic.item.IronHammerItem;
import net.mcreator.advencedmagic.item.IronFileItem;
import net.mcreator.advencedmagic.item.IronDiamondCoatedFileItem;
import net.mcreator.advencedmagic.item.HighQualityWaterGemItem;
import net.mcreator.advencedmagic.item.GoldenRingItem;
import net.mcreator.advencedmagic.AdvencedMagicMod;

public class AdvencedMagicModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(BuiltInRegistries.ITEM, AdvencedMagicMod.MODID);
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
	public static final DeferredHolder<Item, Item> IRON_FILE = REGISTRY.register("iron_file", IronFileItem::new);
	public static final DeferredHolder<Item, Item> IRON_DIAMOND_COATED_FILE = REGISTRY.register("iron_diamond_coated_file", IronDiamondCoatedFileItem::new);
	public static final DeferredHolder<Item, Item> GOLDEN_RING = REGISTRY.register("golden_ring", GoldenRingItem::new);
	public static final DeferredHolder<Item, Item> HIGH_QUALITY_WATER_GEM = REGISTRY.register("high_quality_water_gem", HighQualityWaterGemItem::new);
	public static final DeferredHolder<Item, Item> HIGH_QUALITY_WATER_GEM_ORE = block(AdvencedMagicModBlocks.HIGH_QUALITY_WATER_GEM_ORE);
	public static final DeferredHolder<Item, Item> HIGH_QUALITY_WATER_GEM_BLOCK = block(AdvencedMagicModBlocks.HIGH_QUALITY_WATER_GEM_BLOCK);
	public static final DeferredHolder<Item, Item> IRON_HAMMER = REGISTRY.register("iron_hammer", IronHammerItem::new);
	public static final DeferredHolder<Item, Item> MAGIC_WAND_WITH_FIRE_GEM = REGISTRY.register("magic_wand_with_fire_gem", MagicWandWithFireGemItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredHolder<Item, Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
