package com.abd.everlastingartistry.client.gui;

import java.awt.Color;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.util.math.vector.Matrix4f;

// a date for absolutly no reason 10/9/2021 9:30pm
public class RenderGuiHelper {

	public static GuiBuilder box(MatrixStack ms, IVertexBuilder buf) {
		RenderSystem.enableBlend();
		return new GuiBuilder(ms,buf);
	}

	public static class GuiBuilder {

		private final IVertexBuilder buf;
		private final MatrixStack ms;
		private float x, y, width, height;
		private Color color = Color.WHITE;

		public GuiBuilder(MatrixStack ms, IVertexBuilder buf) {
			this.ms = ms;
			this.buf = buf;
		}

		public GuiBuilder from(float x, float y) {
			this.x = x;
			this.y = y;
			return this;
		}

		public GuiBuilder dim(float width, float height) {
			this.width = width;
			this.height = height;
			return this;
		}

		public GuiBuilder color(int r, int g, int b, int a) {
			this.color = new Color(r, g, b, a);
			return this;
		}

		public GuiBuilder draw() {
			int r = this.color.getRed();
			int g = this.color.getBlue();
			int b = this.color.getGreen();
			int a = this.color.getAlpha();
			Matrix4f matrix = this.ms.getLast().getMatrix();
			buf.pos(matrix, x, y + height, 0).color(r, g, b, a).tex(0F, 1F).endVertex();
			buf.pos(matrix, x + width, y + height, 0).color(r, g, b, a).tex(1F, 1F).endVertex();
			buf.pos(matrix, x + width, y, 0).color(r, g, b, a).tex(1F, 0F).endVertex();
			buf.pos(matrix, x, y, 0).color(r, g, b, a).tex(0F, 0F).endVertex();
			return this;
		}
	}
}
