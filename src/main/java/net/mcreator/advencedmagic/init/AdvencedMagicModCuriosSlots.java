package net.mcreator.advencedmagic.init;

import top.theillusivec4.curios.api.SlotTypePreset;
import top.theillusivec4.curios.api.SlotTypeMessage;
import top.theillusivec4.curios.api.CuriosApi;

import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.InterModComms;
import net.neoforged.bus.api.SubscribeEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvencedMagicModCuriosSlots {
	@SubscribeEvent
	public static void enqueueIMC(final InterModEnqueueEvent event) {
		InterModComms.sendTo(CuriosApi.MODID, SlotTypeMessage.REGISTER_TYPE, () -> SlotTypePreset.RING.getMessageBuilder().size(2).build());
	}
}
