package net.dylanvhs.marvellous.common.item;

import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.armortrim.TrimPattern;

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
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = new ResourceLocation("item/empty_slot_redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = new ResourceLocation("item/empty_slot_quartz");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = new ResourceLocation("item/empty_slot_emerald");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = new ResourceLocation("item/empty_slot_diamond");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = new ResourceLocation("item/empty_slot_lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = new ResourceLocation("item/empty_slot_amethyst_shard");

    private static final Component SHIELD_TRIM_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.shield_trim.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SHIELD_TRIM_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.shield_trim.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component SHIELD_TRIM_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.shield_trim.base_slot_description")));
    private static final Component SHIELD_TRIM_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.shield_trim.additions_slot_description")));

    private static final Component VIBRANIUM_UPGRADE = Component.translatable(Util.makeDescriptionId("upgrade", new ResourceLocation(Marvellous.MOD_ID,"vibranium_upgrade"))).withStyle(TITLE_FORMAT);
    private static final Component VIBRANIUM_UPGRADE_APPLIES_TO = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.vibranium_upgrade.applies_to"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component  VIBRANIUM_UPGRADE_INGREDIENTS = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.vibranium_upgrade.ingredients"))).withStyle(DESCRIPTION_FORMAT);
    private static final Component VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.vibranium_upgrade.base_slot_description")));
    private static final Component VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(Util.makeDescriptionId("item", new ResourceLocation(Marvellous.MOD_ID,"smithing_template.vibranium_upgrade.additions_slot_description")));


    public static SmithingTemplateItem createShieldTrimTemplate(ResourceKey<TrimPattern> pPatternKey) {
        return createShieldTrimTemplate(pPatternKey.location());
    }

    private static List<ResourceLocation> createTrimmableShieldIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createShieldTrimmableMaterialIconList() {
        return List.of(EMPTY_SLOT_LAPIS_LAZULI, EMPTY_SLOT_QUARTZ, EMPTY_SLOT_DIAMOND, EMPTY_SLOT_EMERALD, EMPTY_SLOT_AMETHYST_SHARD);
    }

    public static SmithingTemplateItem createShieldTrimTemplate(ResourceLocation pLocation) {
        return new SmithingTemplateItem(SHIELD_TRIM_APPLIES_TO, SHIELD_TRIM_INGREDIENTS, Component.translatable(Util.makeDescriptionId("trim_pattern", pLocation)).withStyle(TITLE_FORMAT), SHIELD_TRIM_BASE_SLOT_DESCRIPTION, SHIELD_TRIM_ADDITIONS_SLOT_DESCRIPTION, createTrimmableShieldIconList(), createShieldTrimmableMaterialIconList());
    }

    public static SmithingTemplateItem createCaptainAmericaUpgradeTemplate() {
        return new SmithingTemplateItem(VIBRANIUM_UPGRADE_APPLIES_TO, VIBRANIUM_UPGRADE_INGREDIENTS, VIBRANIUM_UPGRADE, VIBRANIUM_UPGRADE_BASE_SLOT_DESCRIPTION, VIBRANIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createCaptainAmericaUpgradeIconList(), createCaptainAmericaUpgradeMaterialList());
    }

    private static List<ResourceLocation> createCaptainAmericaUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<ResourceLocation> createCaptainAmericaUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}
