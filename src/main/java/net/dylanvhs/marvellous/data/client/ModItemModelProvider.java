package net.dylanvhs.marvellous.data.client;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.registry.ModBlocks;
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
        basicItem(ModItems.RAW_VIBRANIUM);
        basicItem(ModItems.VIBRANIUM_INGOT);
        basicItem(ModItems.CAPTAIN_AMERICA_UPGRADE_SMITHING_TEMPLATE);
        basicBlockItem(ModBlocks.VIBRANIUM_ORE);
        basicBlockItem(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        basicBlockItem(ModBlocks.RAW_VIBRANIUM_BLOCK);
        basicBlockItem(ModBlocks.VIBRANIUM_BLOCK);
    }

    private void basicBlockItem(Supplier<? extends Block> blockForItem) {
        withExistingParent(name(blockForItem.get()), modBlockLocation(name(blockForItem.get())));
    }

    private void basicItem(Supplier<? extends Item> item) {
        basicItem(item.get());
    }

    private void captainAmericaShieldItem(Supplier<? extends Item> item) {
        getBuilder(name(item.get()) + "_blocking")
                .parent(new ModelFile.UncheckedModelFile(ENTITY))
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", vanillaBlockLocation(name(Item.byBlock(Blocks.IRON_BLOCK))))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(45, 135, 0).translation(3.51F, 14, -1).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(45, 135, 0).translation(13.51F, 6, 6).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 180, -5).translation(-15, 7, -11).scale(1.2F, 1.2F, 1.2F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 180, -5).translation(5, 7, -11).scale(1.2F, 1.2F, 1.2F).end()
                .transform(ItemDisplayContext.GUI).rotation(15, -25, -5).translation(2, 2.5F, 0).scale(0.65F, 0.65F, 0.65F).end()
                .end();

        getBuilder(name(item.get()))
                .parent(new ModelFile.UncheckedModelFile(ENTITY))
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", vanillaBlockLocation(name(Item.byBlock(Blocks.IRON_BLOCK))))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0, 90, 0).translation(11, 7.5F, -3).end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0, 90, 0).translation(11, 7.5F, 13).end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0, 180, 5).translation(-10, 6, -10).scale(1.2F, 1.2F, 1.2F).end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0, 180, 5).translation(10, 4, -10).scale(1.2F, 1.2F, 1.2F).end()
                .transform(ItemDisplayContext.GUI).rotation(15, -25, -5).translation(2, 2.5F, 0).scale(0.65F, 0.65F, 0.65F).end()
                .transform(ItemDisplayContext.FIXED).rotation(0, 180, 0).translation(-4.5F, 4.5F, -5).scale(0.55F, 0.55F, 0.55F).end()
                .transform(ItemDisplayContext.GROUND).rotation(0, 0, 0).translation(2, 4, 2).scale(0.25F, 0.25F, 0.25F).end()
                .end()
                .override().predicate(new ResourceLocation("blocking"), 1).model(new ModelFile.UncheckedModelFile(modItemLocation(name(item.get()) + "_blocking")));
    }
}