package net.dylanvhs.marvellous.data.client;

import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.client.renderer.CaptainAmericaShieldRenderer;
import net.minecraft.client.renderer.texture.atlas.sources.SingleFile;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.SpriteSourceProvider;

import java.util.Optional;

public class ModSpriteSourceProvider extends SpriteSourceProvider {

    public ModSpriteSourceProvider(PackOutput output, ExistingFileHelper fileHelper) {
        super(output, fileHelper, Marvellous.MOD_ID);
    }

    @Override
    protected void addSources() {
        atlas(SpriteSourceProvider.BLOCKS_ATLAS).addSource(new SingleFile(CaptainAmericaShieldRenderer.CAPTAIN_AMERICA_SHIELD_TEXTURE.texture(), Optional.empty()));
        atlas(SpriteSourceProvider.BLOCKS_ATLAS).addSource(new SingleFile(CaptainAmericaShieldRenderer.CAPTAIN_CARTER_SHIELD_TEXTURE.texture(), Optional.empty()));
    }
}