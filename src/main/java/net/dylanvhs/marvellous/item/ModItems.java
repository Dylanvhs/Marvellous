package net.dylanvhs.marvellous.item;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.item.custom.CaptainAmericaShield;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Marvellous.MOD_ID);

    public static final RegistryObject<Item> CAPTAIN_AMERICA_SHIELD =
            ITEMS.register("captain_america_shield", () -> new CaptainAmericaShield((new Item.Properties()).durability(886)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
