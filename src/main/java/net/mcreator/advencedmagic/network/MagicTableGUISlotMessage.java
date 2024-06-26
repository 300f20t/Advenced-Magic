
package net.mcreator.advencedmagic.network;

import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.advencedmagic.world.inventory.MagicTableGUIMenu;
import net.mcreator.advencedmagic.procedures.ModifierChangeInSlot4Procedure;
import net.mcreator.advencedmagic.procedures.ModifierChangeInSlot3Procedure;
import net.mcreator.advencedmagic.procedures.ModifierChangeInSlot2Procedure;
import net.mcreator.advencedmagic.procedures.ModifierChangeInSlot1Procedure;
import net.mcreator.advencedmagic.AdvencedMagicMod;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record MagicTableGUISlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final ResourceLocation ID = new ResourceLocation(AdvencedMagicMod.MODID, "magic_table_gui_slots");
	public MagicTableGUISlotMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	@Override
	public void write(final FriendlyByteBuf buffer) {
		buffer.writeInt(slotID);
		buffer.writeInt(x);
		buffer.writeInt(y);
		buffer.writeInt(z);
		buffer.writeInt(changeType);
		buffer.writeInt(meta);
	}

	@Override
	public ResourceLocation id() {
		return ID;
	}

	public static void handleData(final MagicTableGUISlotMessage message, final PlayPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.workHandler().submitAsync(() -> {
				Player entity = context.player().get();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			}).exceptionally(e -> {
				context.packetHandler().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = MagicTableGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			ModifierChangeInSlot1Procedure.execute(entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			ModifierChangeInSlot2Procedure.execute(entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			ModifierChangeInSlot3Procedure.execute(entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			ModifierChangeInSlot4Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		AdvencedMagicMod.addNetworkMessage(MagicTableGUISlotMessage.ID, MagicTableGUISlotMessage::new, MagicTableGUISlotMessage::handleData);
	}
}
