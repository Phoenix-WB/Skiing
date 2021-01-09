package com.affehund.skiing.core.init;

import java.util.concurrent.Callable;

import com.affehund.skiing.client.render.SkiRackISTER;
import com.affehund.skiing.client.render.SkisItemISTER;
import com.affehund.skiing.common.item.PulloverItem;
import com.affehund.skiing.common.item.PulloverMaterial;
import com.affehund.skiing.common.item.SkiRackItem;
import com.affehund.skiing.common.item.SkisItem;
import com.affehund.skiing.common.item.SnowShovel;
import com.affehund.skiing.common.tile.SkiRackTileEntity;
import com.affehund.skiing.core.ModConstants;
import com.affehund.skiing.core.utils.DrinkableItem;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			ModConstants.MOD_ID);

	public static final RegistryObject<Item> CHOCOLATE_CUP = ITEMS.register(ModConstants.RegistryStrings.CHOCOLATE_CUP,
			() -> new DrinkableItem(new Item.Properties().maxStackSize(1).group(ModItemGroup.MOD_ITEM_GROUP)
					.food(new Food.Builder().hunger(6).saturation(0.3F).build()), Items.BUCKET, true, true));

	public static final RegistryObject<Item> PULLOVER = ITEMS.register(ModConstants.RegistryStrings.PULLOVER,
			() -> new PulloverItem(PulloverMaterial.PULLOVER, EquipmentSlotType.CHEST,
					new Item.Properties().maxStackSize(1).group(ModItemGroup.MOD_ITEM_GROUP)));
	
	public static final RegistryObject<Item> SNOW_SHOVEL = ITEMS.register(ModConstants.RegistryStrings.ITEM_SNOW_SHOVEL,
			() -> new SnowShovel(ItemTier.IRON, 1.5F, -3.0F,
					new Item.Properties().maxDamage(1561).group(ModItemGroup.MOD_ITEM_GROUP)));

	public static final RegistryObject<Item> SKIS_ITEM = ITEMS.register(ModConstants.RegistryStrings.SKIS_ITEM,
			() -> new SkisItem(new Item.Properties().setISTER(() -> SkisItemISTER::new).maxStackSize(1)
					.group(ModItemGroup.MOD_ITEM_GROUP)));
	
	public static final RegistryObject<Item> SKI_STICK_ITEM = ITEMS.register(
			ModConstants.RegistryStrings.SKI_STICK_ITEM,
			() -> new Item(new Item.Properties().maxStackSize(2).group(ModItemGroup.MOD_ITEM_GROUP)));
	
	public static final RegistryObject<Item> SKIS_RACK = ITEMS.register(
			ModConstants.RegistryStrings.SKI_RACK,
			() -> new SkiRackItem(ModBlocks.SKI_RACK.get(), new Item.Properties().setISTER(() -> skiRackRenderer()).maxStackSize(1).group(ModItemGroup.MOD_ITEM_GROUP)));

	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> skiRackRenderer() {
		return () -> new SkiRackISTER<TileEntity>(() -> new SkiRackTileEntity());
	}
}
