package net.dylanvhs.marvellous.common.item;

import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    public ModSmithingTemplateItem(Component pAppliesTo, Component pIngredients, Component pUpdradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditonalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpdradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditonalSlotEmptyIcons);
    }

    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;

    private static final ResourceLocation EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
    private static final ResourceLocation EMPTY_SLOT_INGOT = new ResourceLocation("item/empty_slot_ingot");
    private static final Component CAPTAIN_AMERICA_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Marvellous.MOD_ID,"captain_america_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component CAPTAIN_AMERICA_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.captain_america_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component  CAPTAIN_AMERICA_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.captain_america_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component CAPTAIN_AMERICA_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.captain_america_upgrade.base_slot_description")));
    private static final Component CAPTAIN_AMERICA_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.captain_america_upgrade.additions_slot_description")));

    public static SmithingTemplateItem createCaptainAmericaUpgradeTemplate() {
        return new SmithingTemplateItem(CAPTAIN_AMERICA_UPGRADE_APPLIES_TO, CAPTAIN_AMERICA_UPGRADE_INGREDIENTS, CAPTAIN_AMERICA_UPGRADE, CAPTAIN_AMERICA_UPGRADE_BASE_SLOT_DESCRIPTION, CAPTAIN_AMERICA_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createCaptainAmericaUpgradeIconList(), createCaptainAmericaUpgradeMaterialList());
    }

    private static List<ResourceLocation> createCaptainAmericaUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createCaptainAmericaUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }


}
