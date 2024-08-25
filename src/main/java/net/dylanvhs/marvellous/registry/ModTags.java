package net.dylanvhs.marvellous.registry;

import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static final TagKey<Item> CARTER_TRIM = itemTag("carter_trim");

    private static TagKey<Item> itemTag(String path) {
        return ItemTags.create(new ResourceLocation(Marvellous.MOD_ID, path));
    }
}
