package net.dylanvhs.marvellous.common.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;

public class CaptainAmericaShield extends ShieldItem {
    public CaptainAmericaShield(Properties pProperties) {
        super(pProperties);
    }
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BLOCK;
    }
    public int getUseDuration(ItemStack pStack) {
        return 72000;
    }
    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return pRepair.is(Items.IRON_INGOT) || super.isValidRepairItem(pToRepair, pRepair);
    }

    public static DyeColor getColor(ItemStack pStack) {
        return null;
    }

    public EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.OFFHAND;
    }
}
