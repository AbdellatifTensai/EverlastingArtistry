package com.abd.everlastingartistry.common.registry;

import com.abd.everlastingartistry.EverlastingArtistry;
import com.abd.everlastingartistry.common.item.EverlastingWeapon;

import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			EverlastingArtistry.MODID);
	private static final RegistryObject<Item> EVERLASTING_WEAPON = ITEMS.register("everlastingweapon",
			() -> new EverlastingWeapon(new Item.Properties()));

	public static void init(IEventBus bus) {
		ITEMS.register(bus);
	}
}
