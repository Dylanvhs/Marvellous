package net.dylanvhs.marvellous;

import com.mojang.logging.LogUtils;
import net.dylanvhs.marvellous.data.client.ModBlockStateProvider;
import net.dylanvhs.marvellous.data.client.ModItemModelProvider;
import net.dylanvhs.marvellous.data.client.ModSpriteSourceProvider;
import net.dylanvhs.marvellous.data.client.ModWorldGenProvider;
import net.dylanvhs.marvellous.registry.ModBlocks;
import net.dylanvhs.marvellous.registry.ModCreativeModeTabs;
import net.dylanvhs.marvellous.registry.ModItems;
import net.dylanvhs.marvellous.registry.ModSounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

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
        modBus.addListener(this::gatherData);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    public static ResourceLocation modPrefix(String path) {
        return new ResourceLocation(Marvellous.MOD_ID, path);
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        boolean includeClient = event.includeClient();
        boolean includeServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(includeClient, new ModSpriteSourceProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new ModBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(includeClient, new ModItemModelProvider(packOutput, fileHelper));

        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));


    }
}