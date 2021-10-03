package com.abd.everlastingartistry.common.item;

import com.abd.everlastingartistry.common.gui.GuiGlyphInfuse;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class EverlastingWeapon extends Item{

	public EverlastingWeapon(Properties p_i48487_1_) {
		super(p_i48487_1_);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		Minecraft mc = Minecraft.getInstance();
		if(worldIn.isRemote && mc.currentScreen == null) {
			mc.displayGuiScreen(new GuiGlyphInfuse());
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	
}
