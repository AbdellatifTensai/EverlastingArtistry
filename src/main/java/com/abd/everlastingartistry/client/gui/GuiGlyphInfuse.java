package com.abd.everlastingartistry.client.gui;

import org.lwjgl.opengl.GL11;

import com.abd.everlastingartistry.EverlastingArtistry;
import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

//a date for absolutly no reason 10/9/2021 9:14pm

public class GuiGlyphInfuse extends Screen{
	
	private final ResourceLocation TEXTURE = new ResourceLocation(EverlastingArtistry.MODID, "textures/gui/bgimage.png");
	
	public GuiGlyphInfuse() {
		super(new StringTextComponent(""));
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		
		Tessellator tess = Tessellator.getInstance();
		BufferBuilder buf = tess.getBuffer();
		buf.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		int bgwidth = width/8;
		RenderGuiHelper.box(ms, buf).from(bgwidth, 0).dim(bgwidth * 6, height).draw();
		tess.draw();
		
		buf.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR_TEX);
		this.minecraft.getTextureManager().bindTexture(new ResourceLocation(EverlastingArtistry.MODID, "textures/gui/bg.png"));
		RenderGuiHelper.box(ms, buf).from(bgwidth, height/2).dim(128, 16).draw();
		tess.draw();
		
		super.render(ms, mouseX, mouseY, partialTicks);
	}
	
}
