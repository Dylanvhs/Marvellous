package net.dylanvhs.marvellous;

import com.mojang.logging.LogUtils;
import net.dylanvhs.marvellous.registry.ModBlocks;
import net.dylanvhs.marvellous.registry.ModCreativeModeTabs;
import net.dylanvhs.marvellous.registry.ModItems;
import net.dylanvhs.marvellous.registry.ModSounds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(Marvellous.MOD_ID)
public class Marvellous {
    public static final String MOD_ID = "marvellous";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final List<Runnable> CALLBACKS = new ArrayList<>();

    public Marvellous() {
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modBus);
        ModItems.register(modBus);
        ModSounds.register(modBus);
        ModBlocks.register(modBus);


        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}