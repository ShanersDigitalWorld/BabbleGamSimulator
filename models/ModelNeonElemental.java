// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelNeonElemental extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public ModelNeonElemental() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 4).addBox(-5.5F, -4.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(17, 20).addBox(-4.5F, -8.0F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-3.5F, -8.0F, -4.5F, 7.0F, 5.0F, 9.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 18).addBox(-1.5F, -8.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 26).addBox(-5.5F, -7.0F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 4).addBox(-3.5F, -9.0F, 2.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 24).addBox(-2.5F, -9.0F, 3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 22).addBox(-2.5F, -9.0F, -4.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 14).addBox(-4.5F, -9.0F, -2.5F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 20).addBox(-3.5F, -10.0F, -2.5F, 7.0F, 1.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 6).addBox(-2.5F, -10.0F, 2.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 20).addBox(-2.5F, -10.0F, -3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 26).addBox(-1.5F, -11.0F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 28).addBox(-1.5F, -11.0F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 0).addBox(-2.5F, -11.0F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 14).addBox(-2.5F, -7.0F, -5.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 18).addBox(-1.5F, -4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 18).addBox(-1.5F, -4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 14).addBox(-2.5F, -7.0F, 4.5F, 5.0F, 3.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 18).addBox(-1.5F, -8.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-5.5F, -8.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 4).addBox(4.5F, -4.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 26).addBox(4.5F, -7.0F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(4.5F, -8.0F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 4).addBox(-3.5F, -9.0F, -3.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(17, 20).addBox(3.5F, -8.0F, -3.5F, 1.0F, 5.0F, 7.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 4).addBox(-3.5F, -3.0F, -3.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 4).addBox(-3.5F, -3.0F, 2.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 24).addBox(-2.5F, -3.0F, 3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 22).addBox(-2.5F, -3.0F, -4.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 14).addBox(-4.5F, -3.0F, -2.5F, 9.0F, 1.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 20).addBox(-2.5F, -2.0F, -3.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 20).addBox(-3.5F, -2.0F, -2.5F, 7.0F, 1.0F, 5.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 6).addBox(-2.5F, -2.0F, 2.5F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 28).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(7, 26).addBox(-1.5F, -1.0F, 1.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(23, 0).addBox(-2.5F, -1.0F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}