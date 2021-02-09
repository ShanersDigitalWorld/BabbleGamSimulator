// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelHolyShock extends EntityModel<Entity> {
	private final ModelRenderer yellow_concrete;
	private final ModelRenderer red_concrete;
	private final ModelRenderer magenta_concrete;
	private final ModelRenderer lime_concrete;
	private final ModelRenderer light_blue_concrete;
	private final ModelRenderer White;
	private final ModelRenderer Orange;

	public ModelHolyShock() {
		textureWidth = 64;
		textureHeight = 64;

		yellow_concrete = new ModelRenderer(this);
		yellow_concrete.setRotationPoint(6.5F, 24.0F, -6.5F);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -4.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -5.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-8.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-7.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -6.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-7.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -12.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -13.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -14.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -14.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -13.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -9.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -10.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-2.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-3.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -4.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -5.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -6.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-6.0F, -6.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-5.0F, -6.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-7.0F, -6.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-8.0F, -6.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-8.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		yellow_concrete.setTextureOffset(24, 25).addBox(-4.0F, -9.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		red_concrete = new ModelRenderer(this);
		red_concrete.setRotationPoint(6.5F, 24.0F, -6.5F);
		red_concrete.setTextureOffset(24, 25).addBox(-12.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-12.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-12.0F, -3.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-9.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -8.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-12.0F, -8.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-13.0F, -9.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-13.0F, -10.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-13.0F, -11.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-8.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-9.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-12.0F, -12.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-9.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-10.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		red_concrete.setTextureOffset(24, 25).addBox(-11.0F, -14.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		magenta_concrete = new ModelRenderer(this);
		magenta_concrete.setRotationPoint(6.5F, 24.0F, -6.5F);
		magenta_concrete.setTextureOffset(24, 25).addBox(-13.0F, -11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		magenta_concrete.setTextureOffset(24, 25).addBox(-1.0F, -2.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		magenta_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		magenta_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		magenta_concrete.setTextureOffset(24, 25).addBox(-13.0F, -9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		magenta_concrete.setTextureOffset(24, 25).addBox(-13.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		lime_concrete = new ModelRenderer(this);
		lime_concrete.setRotationPoint(6.5F, 24.0F, -6.5F);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -13.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -13.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -8.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -9.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -9.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -9.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -9.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -10.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -10.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -10.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -11.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -11.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		lime_concrete.setTextureOffset(24, 25).addBox(-1.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		light_blue_concrete = new ModelRenderer(this);
		light_blue_concrete.setRotationPoint(6.5F, 24.0F, -6.5F);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-13.0F, -10.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -3.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -4.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -5.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -5.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -6.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -6.0F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -6.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -6.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -6.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -7.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -7.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -7.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -8.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-1.0F, -8.0F, 10.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-13.0F, -8.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-13.0F, -9.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(24, 25).addBox(-13.0F, -9.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-13.5F, -16.5F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-7.5F, -16.5F, 5.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-12.5F, -16.5F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-8.5F, -16.5F, 4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-12.5F, -16.5F, 7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-8.5F, -16.5F, 7.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-11.5F, -16.5F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-9.5F, -16.5F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-11.5F, -16.5F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-11.5F, -16.5F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-9.5F, -16.5F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		light_blue_concrete.setTextureOffset(0, 0).addBox(-11.5F, -16.5F, 9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		White = new ModelRenderer(this);
		White.setRotationPoint(-6.0F, 13.0F, 6.5F);
		White.setTextureOffset(4, 14).addBox(0.5F, -3.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(0, 0).addBox(-0.5F, 10.0F, -13.0F, 13.0F, 1.0F, 13.0F, 0.0F, false);
		White.setTextureOffset(15, 20).addBox(-0.5F, -3.0F, -13.0F, 1.0F, 3.0F, 13.0F, 0.0F, false);
		White.setTextureOffset(30, 18).addBox(-0.5F, 0.0F, -10.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		White.setTextureOffset(0, 33).addBox(-0.5F, 1.0F, -9.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		White.setTextureOffset(38, 39).addBox(-0.5F, 2.0F, -8.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		White.setTextureOffset(4, 14).addBox(-0.5F, 3.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(0, 33).addBox(-0.5F, 0.0F, -13.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(0, 33).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(0, 14).addBox(-0.5F, 4.0F, -13.0F, 1.0F, 6.0F, 13.0F, 0.0F, false);
		White.setTextureOffset(15, 15).addBox(0.5F, -3.0F, -7.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(4, 14).addBox(0.5F, -3.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 24).addBox(0.5F, -3.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(14, 41).addBox(5.5F, -3.0F, -11.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 24).addBox(8.5F, -3.0F, -10.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(16, 39).addBox(0.5F, -3.0F, -5.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(24, 41).addBox(11.5F, 6.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(0, 33).addBox(11.5F, 6.0F, -5.0F, 1.0F, 4.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(4, 41).addBox(11.5F, 9.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(30, 20).addBox(11.5F, 5.0F, -8.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(2, 19).addBox(11.5F, 9.0F, -12.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		White.setTextureOffset(9, 25).addBox(11.5F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(0, 41).addBox(11.5F, -2.0F, -4.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(24, 41).addBox(11.5F, 0.0F, -3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(8, 14).addBox(11.5F, 0.0F, -2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(0, 14).addBox(11.5F, -2.0F, -7.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(39, 9).addBox(11.5F, 3.0F, -5.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(0, 0).addBox(11.5F, -2.0F, -10.0F, 1.0F, 10.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, -3.0F, -9.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, 9.0F, -1.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, 4.0F, -1.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 20).addBox(0.5F, 5.0F, -1.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 39).addBox(5.5F, 6.0F, -1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 39).addBox(9.5F, 5.0F, -1.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(39, 5).addBox(10.5F, 1.0F, -1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(9, 36).addBox(0.5F, 1.0F, -1.0F, 9.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(4, 14).addBox(0.5F, 3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, 0.0F, -1.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 28).addBox(0.5F, -2.0F, -1.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 15).addBox(0.5F, -3.0F, -2.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(15, 20).addBox(0.5F, 5.0F, -13.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 39).addBox(5.5F, 6.0F, -13.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(4, 14).addBox(11.5F, 7.0F, -11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(6, 0).addBox(11.5F, -2.0F, -12.0F, 1.0F, 10.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 39).addBox(9.5F, 5.0F, -13.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(39, 0).addBox(9.5F, 2.0F, -13.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, 9.0F, -13.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, 4.0F, -13.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(29, 36).addBox(0.5F, 1.0F, -13.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(39, 3).addBox(9.5F, -1.0F, -13.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 18).addBox(3.5F, 0.0F, -13.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(9, 33).addBox(0.5F, -1.0F, -13.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, -2.0F, -13.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(15, 15).addBox(0.5F, -3.0F, -13.0F, 12.0F, 1.0F, 2.0F, 0.0F, false);
		White.setTextureOffset(15, 24).addBox(5.5F, -3.0F, -3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		White.setTextureOffset(30, 30).addBox(0.5F, -3.0F, -4.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);

		Orange = new ModelRenderer(this);
		Orange.setRotationPoint(-6.0F, 16.5F, 2.5F);
		Orange.setTextureOffset(8, 41).addBox(3.5F, 4.5F, -9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(20, 41).addBox(4.5F, 2.5F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(5, 11).addBox(3.5F, -0.5F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(5, 11).addBox(4.5F, -0.5F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(0, 24).addBox(5.5F, -4.5F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(24, 23).addBox(3.5F, -6.5F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(5, 11).addBox(3.5F, -6.5F, -4.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(8, 41).addBox(4.5F, -6.5F, -6.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(24, 23).addBox(4.5F, -6.5F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(24, 23).addBox(8.5F, -6.5F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(20, 41).addBox(4.5F, 2.5F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(8, 41).addBox(3.5F, 4.5F, 3.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(8, 41).addBox(3.5F, -4.5F, -9.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(20, 41).addBox(2.5F, -4.5F, -9.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(20, 41).addBox(-0.5F, -1.5F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		Orange.setTextureOffset(35, 18).addBox(-0.5F, -2.5F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		yellow_concrete.render(matrixStack, buffer, packedLight, packedOverlay);
		red_concrete.render(matrixStack, buffer, packedLight, packedOverlay);
		magenta_concrete.render(matrixStack, buffer, packedLight, packedOverlay);
		lime_concrete.render(matrixStack, buffer, packedLight, packedOverlay);
		light_blue_concrete.render(matrixStack, buffer, packedLight, packedOverlay);
		White.render(matrixStack, buffer, packedLight, packedOverlay);
		Orange.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}