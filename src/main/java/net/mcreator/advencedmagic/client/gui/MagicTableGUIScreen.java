package net.mcreator.advencedmagic.client.gui;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.advencedmagic.world.inventory.MagicTableGUIMenu;
import net.mcreator.advencedmagic.procedures.GUIItemDisplayingProcedure;
import net.mcreator.advencedmagic.network.MagicTableGUIButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MagicTableGUIScreen extends AbstractContainerScreen<MagicTableGUIMenu> {
	private final static HashMap<String, Object> guistate = MagicTableGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_notes_gui_inactive;
	ImageButton imagebutton_modifiers_gui_inactive;

	public MagicTableGUIScreen(MagicTableGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("advenced_magic:textures/screens/magic_table_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GUIItemDisplayingProcedure.execute(entity) instanceof LivingEntity livingEntity) {
			this.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 25, this.topPos + 72, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_gui.label_modifiers"), 69, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_gui.label_shift_click_to_change"), 51, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_notes_gui_inactive = new ImageButton(this.leftPos + 26, this.topPos + -15, 16, 16,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/notes_gui_inactive.png"), new ResourceLocation("advenced_magic:textures/screens/notes_gui.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new MagicTableGUIButtonMessage(0, x, y, z));
						MagicTableGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_notes_gui_inactive", imagebutton_notes_gui_inactive);
		this.addRenderableWidget(imagebutton_notes_gui_inactive);
		imagebutton_modifiers_gui_inactive = new ImageButton(this.leftPos + 6, this.topPos + -15, 16, 16,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/modifiers_gui_inactive.png"), new ResourceLocation("advenced_magic:textures/screens/modifiers_gui.png")), e -> {
					if (true) {
						PacketDistributor.SERVER.noArg().send(new MagicTableGUIButtonMessage(1, x, y, z));
						MagicTableGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_modifiers_gui_inactive", imagebutton_modifiers_gui_inactive);
		this.addRenderableWidget(imagebutton_modifiers_gui_inactive);
	}

	private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}
