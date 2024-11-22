
package net.mcreator.advencedmagic.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HighQualityWaterGemItem extends Item {
	public HighQualityWaterGemItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
