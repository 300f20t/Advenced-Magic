
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

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
import net.mcreator.advencedmagic.AdvencedMagicMod;

public class AdvencedMagicModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK, AdvencedMagicMod.MODID);
	public static final DeferredHolder<Block, Block> MAGIC_TABLE = REGISTRY.register("magic_table", () -> new MagicTableBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_WOOD = REGISTRY.register("magic_tree_wood", () -> new MagicTreeWoodBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_LOG = REGISTRY.register("magic_tree_log", () -> new MagicTreeLogBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_PLANKS = REGISTRY.register("magic_tree_planks", () -> new MagicTreePlanksBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_LEAVES = REGISTRY.register("magic_tree_leaves", () -> new MagicTreeLeavesBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_STAIRS = REGISTRY.register("magic_tree_stairs", () -> new MagicTreeStairsBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_SLAB = REGISTRY.register("magic_tree_slab", () -> new MagicTreeSlabBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_FENCE = REGISTRY.register("magic_tree_fence", () -> new MagicTreeFenceBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_FENCE_GATE = REGISTRY.register("magic_tree_fence_gate", () -> new MagicTreeFenceGateBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_PRESSURE_PLATE = REGISTRY.register("magic_tree_pressure_plate", () -> new MagicTreePressurePlateBlock());
	public static final DeferredHolder<Block, Block> MAGIC_TREE_BUTTON = REGISTRY.register("magic_tree_button", () -> new MagicTreeButtonBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
