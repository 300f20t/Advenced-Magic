package net.mcreator.advencedmagic.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

public class MagicWandInfoProcedure {
	public static String execute(ItemStack itemstack) {
		return "Modifiers: " + "\u00A7b" + "1. "
				+ new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("modifier_1"))).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName()
						.getString()
				+ " 2. "
				+ new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("modifier_2"))).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName()
						.getString()
				+ " 3. "
				+ new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("modifier_3"))).toLowerCase(java.util.Locale.ENGLISH)))).getDisplayName()
						.getString()
				+ " 4. " + new ItemStack(BuiltInRegistries.ITEM.get(new ResourceLocation(((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("modifier_4"))).toLowerCase(java.util.Locale.ENGLISH))))
						.getDisplayName().getString();
	}
}
