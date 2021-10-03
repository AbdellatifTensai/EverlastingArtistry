package com.abd.everlastingartistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.abd.everlastingartistry.common.registry.Registration;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EverlastingArtistry.MODID)
public class EverlastingArtistry {

	public static final Logger LOGGER = LogManager.getLogger();

	public static final String MODID = "everlastingartistry";

	public EverlastingArtistry() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Registration.init(bus);
		MinecraftForge.EVENT_BUS.register(this);
	}

}
