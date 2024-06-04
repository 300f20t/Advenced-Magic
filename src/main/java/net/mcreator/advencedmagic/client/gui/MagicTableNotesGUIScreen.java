package net.mcreator.advencedmagic.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.advencedmagic.world.inventory.MagicTableNotesGUIMenu;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MagicTableNotesGUIScreen extends AbstractContainerScreen<MagicTableNotesGUIMenu> {
	private final static HashMap<String, Object> guistate = MagicTableNotesGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_modifiers_gui_inactive;
	ImageButton imagebutton_notes_gui_inactive;
	ImageButton imagebutton_note;

	public MagicTableNotesGUIScreen(MagicTableNotesGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("advenced_magic:textures/screens/magic_table_notes_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 33, this.topPos + 7, 0, 0, 32, 32, 32, 32);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_modifiers_gui_inactive = new ImageButton(this.leftPos + 6, this.topPos + -15, 16, 16,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/modifiers_gui_inactive.png"), new ResourceLocation("advenced_magic:textures/screens/modifiers_gui.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_modifiers_gui_inactive", imagebutton_modifiers_gui_inactive);
		this.addRenderableWidget(imagebutton_modifiers_gui_inactive);
		imagebutton_notes_gui_inactive = new ImageButton(this.leftPos + 26, this.topPos + -15, 16, 16,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/notes_gui_inactive.png"), new ResourceLocation("advenced_magic:textures/screens/notes_gui.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_notes_gui_inactive", imagebutton_notes_gui_inactive);
		this.addRenderableWidget(imagebutton_notes_gui_inactive);
		imagebutton_note = new ImageButton(this.leftPos + 6, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note", imagebutton_note);
		this.addRenderableWidget(imagebutton_note);
	}
}
