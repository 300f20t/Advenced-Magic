
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;

import net.mcreator.advencedmagic.block.MagicTreeWoodBlock;
import net.mcreator.advencedmagic.block.MagicTreeStairsBlock;
import net.mcreator.advencedmagic.block.MagicTreeSlabBlock;
import net.mcreator.advencedmagic.block.MagicTreePressurePlateBlock;
import net.mcreator.advencedmagic.block.MagicTreePlanksBlock;
import net.mcreator.advencedmagic.block.MagicTreeLogBlock;
import net.mcreator.advencedmagic.block.MagicTreeLeavesBlock;
import net.mcreator.advencedmagic.block.MagicTreeFenceGateBlock;
import net.mcreator.advencedmagic.block.MagicTreeFenceBlock;
import net.mcreator.advencedmagic.block.MagicTreeButtonBlock;
import net.mcreator.advencedmagic.block.MagicTableBlock;
import net.mcreator.advencedmagic.block.HighQualityWaterGemOreBlock;
import net.mcreator.advencedmagic.block.HighQualityWaterGemBlockBlock;
import net.mcreator.advencedmagic.AdvencedMagicMod;

public class AdvencedMagicModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(AdvencedMagicMod.MODID);
	public static final DeferredHolder<Block, Block> MAGIC_TABLE = REGISTRY.register("magic_table", MagicTableBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_WOOD = REGISTRY.register("magic_tree_wood", MagicTreeWoodBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_LOG = REGISTRY.register("magic_tree_log", MagicTreeLogBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_PLANKS = REGISTRY.register("magic_tree_planks", MagicTreePlanksBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_LEAVES = REGISTRY.register("magic_tree_leaves", MagicTreeLeavesBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_STAIRS = REGISTRY.register("magic_tree_stairs", MagicTreeStairsBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_SLAB = REGISTRY.register("magic_tree_slab", MagicTreeSlabBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_FENCE = REGISTRY.register("magic_tree_fence", MagicTreeFenceBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_FENCE_GATE = REGISTRY.register("magic_tree_fence_gate", MagicTreeFenceGateBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_PRESSURE_PLATE = REGISTRY.register("magic_tree_pressure_plate", MagicTreePressurePlateBlock::new);
	public static final DeferredHolder<Block, Block> MAGIC_TREE_BUTTON = REGISTRY.register("magic_tree_button", MagicTreeButtonBlock::new);
	public static final DeferredHolder<Block, Block> HIGH_QUALITY_WATER_GEM_ORE = REGISTRY.register("high_quality_water_gem_ore", HighQualityWaterGemOreBlock::new);
	public static final DeferredHolder<Block, Block> HIGH_QUALITY_WATER_GEM_BLOCK = REGISTRY.register("high_quality_water_gem_block", HighQualityWaterGemBlockBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
