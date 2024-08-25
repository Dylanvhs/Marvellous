package net.dylanvhs.marvellous.registry;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.common.item.ModSmithingTemplateItem;
import net.dylanvhs.marvellous.common.item.VibraniumShieldItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Marvellous.MOD_ID);

    public static final RegistryObject<Item> VIBRANIUM_SHIELD =
            ITEMS.register("vibranium_shield", () -> new VibraniumShieldItem((new Item.Properties().durability(886))));
    public static final RegistryObject<Item> RAW_VIBRANIUM =
            ITEMS.register("raw_vibranium", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VIBRANIUM_INGOT =
            ITEMS.register("vibranium_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> VIBRANIUM_UPGRADE_SMITHING_TEMPLATE =
            ITEMS.register("vibranium_upgrade_smithing_template", ModSmithingTemplateItem::createCaptainAmericaUpgradeTemplate);

    public static final RegistryObject<Item> CARTER_TRIM_SMITHING_TEMPLATE =
            ITEMS.register("carter_trim_smithing_template", () -> ModSmithingTemplateItem.createShieldTrimTemplate(new ResourceLocation("marvellous:carter")));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
