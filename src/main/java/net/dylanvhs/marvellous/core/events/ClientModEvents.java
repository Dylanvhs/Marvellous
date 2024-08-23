package net.dylanvhs.marvellous.core.events;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.client.model.CaptainAmericaShieldModel;
import net.dylanvhs.marvellous.registry.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Marvellous.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerLayerLocation(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CaptainAmericaShieldModel.LAYER_LOCATION, CaptainAmericaShieldModel::createLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemProperties.register(ModItems.CAPTAIN_AMERICA_SHIELD.get(), new ResourceLocation("blocking"), (itemStack, clientWorld, livingEntity, useTime) -> livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F);

    }

}
