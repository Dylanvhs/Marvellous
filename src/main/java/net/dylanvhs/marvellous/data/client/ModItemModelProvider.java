package net.dylanvhs.marvellous.data.client;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.registry.ModItems;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;
import static net.dylanvhs.marvellous.data.ModDatagenUtil.*;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, Marvellous.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        captainAmericaShieldItem(ModItems.CAPTAIN_AMERICA_SHIELD);
    }

    private void captainAmericaShieldItem(Supplier<? extends Item> item) {
        getBuilder(name(item.get()) + "_blocking")
                .parent(new ModelFile.UncheckedModelFile(ENTITY))
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", vanillaBlockLocation(name(Item.byBlock(Blocks.IRON_BLOCK))))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(45, 135, 0).translation(3.51F, 11, -2).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(45, 135, 0).translation(13.51F, 3, 5).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 180, -5).translation(-15, 5, -11).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 180, -5).translation(5, 5, -11).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.GUI).rotation(15, -25, -5).translation(2, 2.5F, 0).scale(0.65F, 0.65F, 0.65F).end()
                .end();

        getBuilder(name(item.get()))
                .parent(new ModelFile.UncheckedModelFile(ENTITY))
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", vanillaBlockLocation(name(Item.byBlock(Blocks.IRON_BLOCK))))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0, 90, 0).translation(10, 6, -4).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0, 90, 0).translation(10, 6, 12).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 180, 5).translation(-10, 2, -10).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 180, 5).translation(10, 0, -10).scale(1.0F, 1.0F, 1.0F).end()
                .transform(ItemDisplayContext.GUI).rotation(15, -25, -5).translation(2, 2.5F, 0).scale(0.65F, 0.65F, 0.65F).end()
                .transform(ItemDisplayContext.FIXED).rotation(0, 180, 0).translation(-4.5F, 4.5F, -5).scale(0.55F, 0.55F, 0.55F).end()
                .transform(ItemDisplayContext.GROUND).rotation(0, 0, 0).translation(2, 4, 2).scale(0.25F, 0.25F, 0.25F).end()
                .end()
                .override().predicate(new ResourceLocation("blocking"), 1).model(new ModelFile.UncheckedModelFile(modItemLocation(name(item.get()) + "_blocking")));
    }
}