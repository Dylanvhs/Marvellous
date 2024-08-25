package net.dylanvhs.marvellous.registry;

import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Marvellous.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MARVELLOUS_TAB = CREATIVE_MODE_TABS.register("marvellous_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VIBRANIUM_SHIELD.get()))
                    .title(Component.translatable("creativetab.marvellous_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        for (var items : ModItems.ITEMS.getEntries()) {
                            pOutput.accept(items.get());
                        }
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}