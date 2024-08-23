package net.dylanvhs.marvellous.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dylanvhs.marvellous.Marvellous;
import net.dylanvhs.marvellous.client.model.CaptainAmericaShieldModel;
import net.dylanvhs.marvellous.registry.ModItems;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
public class CaptainAmericaShieldRenderer extends BlockEntityWithoutLevelRenderer {
    public static final Material CAPTAIN_AMERICA_SHIELD_TEXTURE = new Material(TextureAtlas.LOCATION_BLOCKS, Marvellous.modPrefix("entity/captain_america_shield/captain_america_shield"));
    public final CaptainAmericaShieldModel model;

    public CaptainAmericaShieldRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        super(pBlockEntityRenderDispatcher, pEntityModelSet);
        this.model = new CaptainAmericaShieldModel(pEntityModelSet.bakeLayer(CaptainAmericaShieldModel.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Item item = pStack.getItem();

        if (item == ModItems.CAPTAIN_AMERICA_SHIELD.get()) {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            Material material = CAPTAIN_AMERICA_SHIELD_TEXTURE;
            VertexConsumer vertexconsumer = material.sprite().wrap(ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(material.atlasLocation()), true, pStack.hasFoil()));

            this.model.handle().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            this.model.plate().render(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);

            pPoseStack.popPose();
        }
    }
}
