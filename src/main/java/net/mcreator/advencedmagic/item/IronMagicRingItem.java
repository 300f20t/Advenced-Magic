
package net.mcreator.advencedmagic.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.advencedmagic.procedures.RingWhileUpdateTickProcedure;
import net.mcreator.advencedmagic.procedures.MagicRingUnequippedProcedure;
import net.mcreator.advencedmagic.procedures.MagicRingInfoProcedure;
import net.mcreator.advencedmagic.procedures.MagicRingEquippedProcedure;

import java.util.List;

public class IronMagicRingItem extends Item implements ICurioItem {
	public IronMagicRingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		list.add(Component.literal(MagicRingInfoProcedure.execute(itemstack)));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		RingWhileUpdateTickProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		MagicRingEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		MagicRingUnequippedProcedure.execute(slotContext.entity());
	}
}
