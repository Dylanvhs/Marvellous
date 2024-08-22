package net.dylanvhs.marvellous.item;

import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Marvellous.MOD_ID);
    public static final RegistryObject<CreativeModeTab> BOUNTIFUL_CRITTERS_TAB = CREATIVE_MODE_TABS.register("bountiful_critters_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.EMERALD))

                    .title(Component.translatable("creativetab.bountiful_critters_tab"))
                    .displayItems((pParameters, pOutput) -> {




                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}