package net.dylanvhs.marvellous.data.client;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.registry.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, Marvellous.MOD_ID, exFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        block(ModBlocks.VIBRANIUM_ORE);
        block(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        block(ModBlocks.RAW_VIBRANIUM_BLOCK);
        block(ModBlocks.VIBRANIUM_BLOCK);
    }

    private void block(Supplier<? extends Block> block) {
        simpleBlock(block.get());
    }

}
