package com.affehund.skiing.client.screen;

import com.affehund.skiing.common.container.SpruceSkiRackContainer;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

/**
 * @author Affehund
 *
 */
public class SpruceSkiRackScreen extends AbstractSkiRackScreen<SpruceSkiRackContainer> {
	public SpruceSkiRackScreen(SpruceSkiRackContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}
}
