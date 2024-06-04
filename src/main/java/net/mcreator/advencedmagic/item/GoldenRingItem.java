
package net.mcreator.advencedmagic.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GoldenRingItem extends Item implements ICurioItem {
	public GoldenRingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
