package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.advencedmagic.network.AdvencedMagicModVariables;
import net.mcreator.advencedmagic.init.AdvencedMagicModItems;

public class MagicWandRMBProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack modifier_1 = ItemStack.EMPTY;
		ItemStack modifier_3 = ItemStack.EMPTY;
		ItemStack modifier_4 = ItemStack.EMPTY;
		ItemStack modifier_2 = ItemStack.EMPTY;
		double current_block_pos_x = 0;
		double current_block_pos_y = 0;
		double current_block_pos_z = 0;
		double number_of_repetitions = 0;
		double fire_pos_x = 0;
		double fire_pos_z = 0;
		double cooldown = 0;
		double mana_cost = 0;
		cooldown = 1;
		mana_cost = 1;
		modifier_1 = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrCreateTag().getString("modifier_1"))).toLowerCase(java.util.Locale.ENGLISH))));
		modifier_2 = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrCreateTag().getString("modifier_2"))).toLowerCase(java.util.Locale.ENGLISH))));
		modifier_3 = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrCreateTag().getString("modifier_3"))).toLowerCase(java.util.Locale.ENGLISH))));
		modifier_4 = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrCreateTag().getString("modifier_4"))).toLowerCase(java.util.Locale.ENGLISH))));
		if (modifier_2.getItem() == Items.AMETHYST_SHARD) {
			mana_cost = cooldown - 0.3;
		}
		if (modifier_3.getItem() == Items.AMETHYST_SHARD) {
			mana_cost = cooldown - 0.3;
		}
		if (modifier_2.getItem() == Items.ECHO_SHARD) {
			cooldown = cooldown - 0.4;
		}
		if (modifier_3.getItem() == Items.ECHO_SHARD) {
			cooldown = cooldown - 0.4;
		}
		if (modifier_4.getItem() == Blocks.OBSIDIAN.asItem()) {
			number_of_repetitions = 2;
		} else if (modifier_4.getItem() == Blocks.CRYING_OBSIDIAN.asItem()) {
			number_of_repetitions = 3;
		} else if (modifier_4.getItem() == Items.NETHERITE_INGOT) {
			number_of_repetitions = 4;
		} else if (modifier_4.getItem() == Items.NETHER_STAR) {
			number_of_repetitions = 5;
		} else {
			number_of_repetitions = 1;
		}
		current_block_pos_x = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
		current_block_pos_y = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
		current_block_pos_z = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
		if (modifier_1.getItem() == AdvencedMagicModItems.FACETED_DIAMOND.get()) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt((int) (10 + (number_of_repetitions - 1) * 0.5), RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			for (int index0 = 0; index0 < (int) number_of_repetitions; index0++) {
				if (entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana >= 10) {
					{
						AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
						_vars.player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana - 10 * mana_cost;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (100 * cooldown));
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.LIGHTNING_BOLT.spawn(_level, new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(10)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		} else if (modifier_1.getItem() == AdvencedMagicModItems.FACETED_QUARTZ.get()) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt((int) (10 + (number_of_repetitions - 1) * 0.5), RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			world.setBlock(BlockPos.containing(current_block_pos_x, current_block_pos_y + 1, current_block_pos_z), Blocks.FIRE.defaultBlockState(), 3);
			{
				AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
				_vars.player_mana = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana - 2 * mana_cost;
				_vars.syncPlayerVariables(entity);
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (10 * cooldown));
		} else {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt((int) (50 + number_of_repetitions * 10), RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			for (int index1 = 0; index1 < (int) number_of_repetitions; index1++) {
				if (entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES).player_mana >= 10) {
					{
						AdvencedMagicModVariables.PlayerVariables _vars = entity.getData(AdvencedMagicModVariables.PLAYER_VARIABLES);
						_vars.player_mana = 0;
						_vars.syncPlayerVariables(entity);
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.LIGHTNING_BOLT.spawn(_level, new BlockPos(
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
								entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
	}
}
