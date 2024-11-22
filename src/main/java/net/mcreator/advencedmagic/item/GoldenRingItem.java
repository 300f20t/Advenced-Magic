
package net.mcreator.advencedmagic.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.advencedmagic.procedures.RingWhileUpdateTickProcedure;
import net.mcreator.advencedmagic.procedures.RingWhenEquippedProcedure;
import net.mcreator.advencedmagic.procedures.MagicRingInfoProcedure;
import net.mcreator.advencedmagic.procedures.GoldenRingBaubleIsUnequippedProcedure;

import java.util.List;

public class GoldenRingItem extends Item implements ICurioItem {
	public GoldenRingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : Minecraft.getInstance().player;
		list.add(Component.literal(MagicRingInfoProcedure.execute(itemstack)));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		RingWhileUpdateTickProcedure.execute(slotContext.entity(), stack);
	}

	@Override
	public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
		RingWhenEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		GoldenRingBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
