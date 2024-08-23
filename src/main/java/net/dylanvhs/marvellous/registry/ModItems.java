package net.dylanvhs.marvellous.registry;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.common.item.CaptainAmericaShieldItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Marvellous.MOD_ID);

    public static final RegistryObject<Item> CAPTAIN_AMERICA_SHIELD =
            ITEMS.register("captain_america_shield", () -> new CaptainAmericaShieldItem((new Item.Properties().durability(886))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
