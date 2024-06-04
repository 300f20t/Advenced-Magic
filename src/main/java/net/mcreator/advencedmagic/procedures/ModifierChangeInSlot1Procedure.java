package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;
import java.util.Map;

public class ModifierChangeInSlot1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack modifier = ItemStack.EMPTY;
		ItemStack item = ItemStack.EMPTY;
		ItemStack old_modifier = ItemStack.EMPTY;
		item = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		modifier = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(1)).getItem() : ItemStack.EMPTY);
		old_modifier = new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((item.getOrCreateTag().getString("modifier_1"))).toLowerCase(java.util.Locale.ENGLISH))));
		item.getOrCreateTag().putString("modifier_1", (BuiltInRegistries.ITEM.getKey(modifier.getItem()).toString()));
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(1)).remove(1);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = old_modifier.copy();
			_setstack.setCount(1);
			((Slot) _slots.get(1)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}
