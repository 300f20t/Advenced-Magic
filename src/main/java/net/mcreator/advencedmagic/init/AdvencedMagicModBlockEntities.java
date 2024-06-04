
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.advencedmagic.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.advencedmagic.block.entity.MagicTableBlockEntity;
import net.mcreator.advencedmagic.AdvencedMagicMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvencedMagicModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AdvencedMagicMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MAGIC_TABLE = register("magic_table", AdvencedMagicModBlocks.MAGIC_TABLE, MagicTableBlockEntity::new);

	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MAGIC_TABLE.get(), (blockEntity, side) -> ((MagicTableBlockEntity) blockEntity).getItemHandler());
	}
}
