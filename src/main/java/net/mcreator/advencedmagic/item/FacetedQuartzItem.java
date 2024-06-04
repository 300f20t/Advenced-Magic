
package net.mcreator.advencedmagic.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FacetedQuartzItem extends Item {
	public FacetedQuartzItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}
}
