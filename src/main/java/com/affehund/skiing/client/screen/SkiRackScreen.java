package com.affehund.skiing.client.screen;

import com.affehund.skiing.common.container.SkiRackContainer;
import com.affehund.skiing.core.ModConstants;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class SkiRackScreen extends ContainerScreen<SkiRackContainer> {

	public SkiRackScreen(SkiRackContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 176;
		this.ySize = 166;
	}

	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ModConstants.MOD_ID,
			"textures/screen/ski_rack_screen.png");

	@Override
	public void render(MatrixStack matrixStack, int x, int y, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, x, y, partialTicks);
		this.renderHoveredTooltip(matrixStack, x, y);
	}

	@Override
	 protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
        String s = this.title.getString();
        this.font.drawString(matrixStack, s, (float)(this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        this.font.drawString(matrixStack, this.playerInventory.getDisplayName().getString(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    	this.titleX = (this.xSize - this.font.getStringPropertyWidth(this.title)) / 2;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
		int relX = (width - xSize) / 2;
        int relY = (height - ySize) / 2;
		this.blit(matrixStack, relX, relY, 0, 0, this.xSize, this.ySize);
	}
}