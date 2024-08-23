package net.dylanvhs.marvellous.client.model;

import com.mojang.blaze3d.Blaze3D;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dylanvhs.marvellous.Marvellous;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;

public class CaptainAmericaShieldModel extends Model {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Marvellous.modPrefix("captain_america_shield"), "captain_america_shield");
	private final ModelPart root;
	private final ModelPart plate;
	private final ModelPart handle;

	public CaptainAmericaShieldModel(ModelPart root) {
		super(RenderType::entityCutout);
		this.root = root.getChild("root");
		this.plate = root.getChild("plate");
		this.handle = root.getChild("handle");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.ZERO);

		partdefinition.addOrReplaceChild("plate", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -8.5F, -1.0F, 20.0F, 20.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.ZERO);

		partdefinition.addOrReplaceChild("handle", CubeListBuilder.create().texOffs(0, 25).addBox(-5.0F, -1.5F, -3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(3.0F, -1.5F, -3.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 3.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public ModelPart plate() {
		return this.plate;
	}

	public ModelPart handle() {
		return this.handle;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}