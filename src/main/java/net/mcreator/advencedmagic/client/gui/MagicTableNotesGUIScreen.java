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
	ImageButton imagebutton_close;
	ImageButton imagebutton_note;
	ImageButton imagebutton_note1;
	ImageButton imagebutton_note2;
	ImageButton imagebutton_note3;
	ImageButton imagebutton_note4;
	ImageButton imagebutton_note5;
	ImageButton imagebutton_note6;
	ImageButton imagebutton_note7;
	ImageButton imagebutton_note8;

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

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/darkening_the_background.png"), this.leftPos + -66, this.topPos + -38, 0, 0, 320, 240, 320, 240);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + -12, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 42, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow_down.png"), this.leftPos + 15, this.topPos + 25, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 96, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow_down.png"), this.leftPos + 69, this.topPos + 25, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 150, this.topPos + 7, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 96, this.topPos + 61, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow.png"), this.leftPos + 150, this.topPos + 61, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("advenced_magic:textures/screens/arrow_up.png"), this.leftPos + 186, this.topPos + 34, 0, 0, 32, 32, 32, 32);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_notes_gui.label_research_notes"), 51, -29, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_notes_gui.label_research_progress"), -57, 169, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_notes_gui.label_0"), 42, 169, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.advenced_magic.magic_table_notes_gui.label_7"), 51, 169, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_close = new ImageButton(this.leftPos + 222, this.topPos + -29, 16, 16, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/close.png"), new ResourceLocation("advenced_magic:textures/screens/close_active.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_close", imagebutton_close);
		this.addRenderableWidget(imagebutton_close);
		imagebutton_note = new ImageButton(this.leftPos + -30, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note", imagebutton_note);
		this.addRenderableWidget(imagebutton_note);
		imagebutton_note1 = new ImageButton(this.leftPos + 24, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note1", imagebutton_note1);
		this.addRenderableWidget(imagebutton_note1);
		imagebutton_note2 = new ImageButton(this.leftPos + 78, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note2", imagebutton_note2);
		this.addRenderableWidget(imagebutton_note2);
		imagebutton_note3 = new ImageButton(this.leftPos + 132, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note3", imagebutton_note3);
		this.addRenderableWidget(imagebutton_note3);
		imagebutton_note4 = new ImageButton(this.leftPos + 186, this.topPos + 7, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note4", imagebutton_note4);
		this.addRenderableWidget(imagebutton_note4);
		imagebutton_note5 = new ImageButton(this.leftPos + 24, this.topPos + 61, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note5", imagebutton_note5);
		this.addRenderableWidget(imagebutton_note5);
		imagebutton_note6 = new ImageButton(this.leftPos + 78, this.topPos + 61, 24, 24, new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")),
				e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note6", imagebutton_note6);
		this.addRenderableWidget(imagebutton_note6);
		imagebutton_note7 = new ImageButton(this.leftPos + 132, this.topPos + 61, 24, 24,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note7", imagebutton_note7);
		this.addRenderableWidget(imagebutton_note7);
		imagebutton_note8 = new ImageButton(this.leftPos + 186, this.topPos + 61, 24, 24,
				new WidgetSprites(new ResourceLocation("advenced_magic:textures/screens/note.png"), new ResourceLocation("advenced_magic:textures/screens/note_with_frame.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_note8", imagebutton_note8);
		this.addRenderableWidget(imagebutton_note8);
	}
}
