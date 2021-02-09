
package net.mcreator.bubblegumsimulator.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ActionResultType;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BetatventEntity extends BubbleGumSimulatorModElements.ModElement {
	public static EntityType entity = null;
	public BetatventEntity(BubbleGumSimulatorModElements instance) {
		super(instance, 533);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.5f, 0.5f)).build("betatvent")
						.setRegistryName("betatvent");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -16711681, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("betatvent_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		DeferredWorkQueue.runLater(this::setupAttributes);
	}
	private static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelBetaTV(), 0.2f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("bubble_gum_simulator:textures/betatv.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 0);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends CreatureEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("§6 (Shiny) §f Beta TV §b Level 1"));
			setCustomNameVisible(true);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0, false));
			this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(3, new RandomWalkingGoal(this, 0.8));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, false));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + -0.5;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("weather.rain.above"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public ActionResultType func_230254_b_(PlayerEntity sourceentity, Hand hand) {
			ItemStack itemstack = sourceentity.getHeldItem(hand);
			ActionResultType retval = ActionResultType.func_233537_a_(this.world.isRemote());
			super.func_230254_b_(sourceentity, hand);
			sourceentity.startRiding(this);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			return retval;
		}

		@Override
		public boolean canBeCollidedWith() {
			return false;
		}

		@Override
		public void travel(Vector3d dir) {
			Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
			if (this.isBeingRidden()) {
				this.rotationYaw = entity.rotationYaw;
				this.prevRotationYaw = this.rotationYaw;
				this.rotationPitch = entity.rotationPitch * 0.5F;
				this.setRotation(this.rotationYaw, this.rotationPitch);
				this.jumpMovementFactor = this.getAIMoveSpeed() * 0.15F;
				this.renderYawOffset = entity.rotationYaw;
				this.rotationYawHead = entity.rotationYaw;
				this.stepHeight = 1.0F;
				if (entity instanceof LivingEntity) {
					this.setAIMoveSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));
					float forward = ((LivingEntity) entity).moveForward;
					float strafe = ((LivingEntity) entity).moveStrafing;
					super.travel(new Vector3d(strafe, 0, forward));
				}
				this.prevLimbSwingAmount = this.limbSwingAmount;
				double d1 = this.getPosX() - this.prevPosX;
				double d0 = this.getPosZ() - this.prevPosZ;
				float f1 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;
				if (f1 > 1.0F)
					f1 = 1.0F;
				this.limbSwingAmount += (f1 - this.limbSwingAmount) * 0.4F;
				this.limbSwing += this.limbSwingAmount;
				return;
			}
			this.stepHeight = 0.5F;
			this.jumpMovementFactor = 0.02F;
			super.travel(dir);
		}
	}

	// Made with Blockbench 3.7.5
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelBetaTV extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		public ModelBetaTV() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(21, 37).addBox(1.0F, -1.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 37).addBox(1.0F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 37).addBox(1.0F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 37).addBox(1.0F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 34).addBox(1.0F, -1.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 32).addBox(1.0F, -1.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 30).addBox(0.0F, -1.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 28).addBox(0.0F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 26).addBox(0.0F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 24).addBox(0.0F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 22).addBox(0.0F, -1.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 20).addBox(0.0F, -1.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 18).addBox(-1.0F, -1.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 16).addBox(-1.0F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 14).addBox(-1.0F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 12).addBox(-1.0F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 10).addBox(-1.0F, -1.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 8).addBox(-1.0F, -1.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 6).addBox(-2.0F, -1.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 4).addBox(-2.0F, -1.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 2).addBox(-2.0F, -1.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 0).addBox(-2.0F, -1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(36, 36).addBox(-2.0F, -1.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 36).addBox(-2.0F, -1.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 36).addBox(2.0F, -2.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 36).addBox(2.0F, -2.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 36).addBox(2.0F, -2.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 36).addBox(2.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 36).addBox(2.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 35).addBox(2.0F, -2.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 35).addBox(2.0F, -2.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 35).addBox(1.0F, -2.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 35).addBox(1.0F, -2.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 35).addBox(1.0F, -2.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 35).addBox(1.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 34).addBox(1.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 34).addBox(1.0F, -2.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 34).addBox(1.0F, -2.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 34).addBox(0.0F, -2.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 34).addBox(0.0F, -2.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 34).addBox(0.0F, -2.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 31).addBox(0.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 29).addBox(0.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 27).addBox(0.0F, -2.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 25).addBox(0.0F, -2.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 23).addBox(-1.0F, -2.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 21).addBox(-1.0F, -2.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 19).addBox(-1.0F, -2.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 17).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 15).addBox(-1.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 13).addBox(-1.0F, -2.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 11).addBox(-1.0F, -2.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 9).addBox(-2.0F, -2.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 7).addBox(-2.0F, -2.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 5).addBox(-2.0F, -2.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 3).addBox(-2.0F, -2.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 1).addBox(-2.0F, -2.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(33, 33).addBox(-2.0F, -2.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 33).addBox(-2.0F, -2.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 33).addBox(2.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 33).addBox(2.0F, -3.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 33).addBox(2.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 33).addBox(2.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 32).addBox(2.0F, -3.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 32).addBox(2.0F, -3.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 32).addBox(2.0F, -3.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 32).addBox(1.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 32).addBox(1.0F, -3.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 32).addBox(1.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 31).addBox(1.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 31).addBox(1.0F, -3.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 31).addBox(1.0F, -3.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 31).addBox(1.0F, -3.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 31).addBox(0.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 28).addBox(0.0F, -3.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 26).addBox(-1.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 24).addBox(-1.0F, -3.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 22).addBox(-1.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 20).addBox(-1.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 18).addBox(-1.0F, -3.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 16).addBox(-1.0F, -3.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 14).addBox(-1.0F, -3.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 12).addBox(-2.0F, -3.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 10).addBox(-2.0F, -3.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 8).addBox(-2.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 6).addBox(-2.0F, -3.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 4).addBox(-2.0F, -3.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 2).addBox(-2.0F, -3.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 0).addBox(-2.0F, -3.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(30, 30).addBox(2.0F, -4.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 30).addBox(2.0F, -4.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 30).addBox(2.0F, -4.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 30).addBox(2.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 30).addBox(2.0F, -4.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 30).addBox(2.0F, -4.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 29).addBox(2.0F, -4.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 29).addBox(1.0F, -4.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 29).addBox(1.0F, -4.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 29).addBox(1.0F, -4.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 29).addBox(1.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 28).addBox(1.0F, -4.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 28).addBox(1.0F, -4.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 28).addBox(1.0F, -4.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 28).addBox(0.0F, -4.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 28).addBox(0.0F, -4.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 25).addBox(-1.0F, -4.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 23).addBox(-1.0F, -4.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 21).addBox(-1.0F, -4.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 19).addBox(-1.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 17).addBox(-1.0F, -4.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 15).addBox(-1.0F, -4.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 13).addBox(-1.0F, -4.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 11).addBox(-2.0F, -4.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 9).addBox(-2.0F, -4.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 7).addBox(-2.0F, -4.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 5).addBox(-2.0F, -4.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 3).addBox(-2.0F, -4.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 1).addBox(-2.0F, -4.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(27, 27).addBox(-2.0F, -4.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 27).addBox(2.0F, -5.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 27).addBox(2.0F, -5.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 27).addBox(2.0F, -5.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 27).addBox(2.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 26).addBox(2.0F, -5.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 26).addBox(2.0F, -5.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 26).addBox(2.0F, -5.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 26).addBox(1.0F, -5.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 26).addBox(1.0F, -5.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 25).addBox(1.0F, -5.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 25).addBox(1.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 25).addBox(1.0F, -5.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 25).addBox(1.0F, -5.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 22).addBox(1.0F, -5.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 20).addBox(0.0F, -5.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 18).addBox(0.0F, -5.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 16).addBox(0.0F, -5.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 14).addBox(0.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 12).addBox(0.0F, -5.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 10).addBox(0.0F, -5.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 8).addBox(0.0F, -5.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 6).addBox(-1.0F, -5.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 4).addBox(-1.0F, -5.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 2).addBox(-1.0F, -5.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 0).addBox(-1.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(24, 24).addBox(-1.0F, -5.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 24).addBox(-1.0F, -5.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 24).addBox(-1.0F, -5.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 24).addBox(-2.0F, -5.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 24).addBox(-2.0F, -5.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 23).addBox(-2.0F, -5.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 23).addBox(-2.0F, -5.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 23).addBox(-2.0F, -5.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 23).addBox(-2.0F, -5.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 22).addBox(-2.0F, -5.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 22).addBox(2.0F, -6.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 22).addBox(2.0F, -6.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 22).addBox(2.0F, -6.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 19).addBox(2.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 17).addBox(2.0F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 15).addBox(2.0F, -6.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 13).addBox(2.0F, -6.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 11).addBox(1.0F, -6.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 9).addBox(1.0F, -6.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 7).addBox(1.0F, -6.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 5).addBox(1.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 3).addBox(1.0F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 1).addBox(1.0F, -6.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(21, 21).addBox(1.0F, -6.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 21).addBox(0.0F, -6.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 21).addBox(0.0F, -6.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 21).addBox(0.0F, -6.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 20).addBox(0.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 20).addBox(0.0F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 20).addBox(0.0F, -6.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 20).addBox(0.0F, -6.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 19).addBox(-1.0F, -6.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 19).addBox(-1.0F, -6.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 19).addBox(-1.0F, -6.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 16).addBox(-1.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 14).addBox(-1.0F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 12).addBox(-1.0F, -6.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 10).addBox(-1.0F, -6.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 8).addBox(-2.0F, -6.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 6).addBox(-2.0F, -6.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 4).addBox(-2.0F, -6.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 2).addBox(-2.0F, -6.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 0).addBox(-2.0F, -6.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(18, 18).addBox(-2.0F, -6.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 18).addBox(-2.0F, -6.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 18).addBox(2.0F, -7.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 18).addBox(2.0F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 17).addBox(2.0F, -7.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 17).addBox(2.0F, -7.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 17).addBox(2.0F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 16).addBox(2.0F, -7.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 16).addBox(2.0F, -7.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 16).addBox(1.0F, -7.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 13).addBox(1.0F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 11).addBox(1.0F, -7.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 9).addBox(1.0F, -7.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 7).addBox(1.0F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 5).addBox(1.0F, -7.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 3).addBox(1.0F, -7.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 1).addBox(0.0F, -7.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(15, 15).addBox(0.0F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 15).addBox(0.0F, -7.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 15).addBox(0.0F, -7.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 14).addBox(0.0F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 14).addBox(0.0F, -7.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 14).addBox(0.0F, -7.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 13).addBox(-1.0F, -7.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 13).addBox(-1.0F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 10).addBox(-1.0F, -7.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 8).addBox(-1.0F, -7.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 6).addBox(-1.0F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 4).addBox(-1.0F, -7.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 2).addBox(-1.0F, -7.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 0).addBox(-2.0F, -7.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(12, 12).addBox(-2.0F, -7.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 12).addBox(-2.0F, -7.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 12).addBox(-2.0F, -7.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 11).addBox(-2.0F, -7.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 11).addBox(-2.0F, -7.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 10).addBox(-2.0F, -7.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 10).addBox(1.0F, -8.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 7).addBox(1.0F, -8.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 5).addBox(1.0F, -9.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 3).addBox(1.0F, -9.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 1).addBox(1.0F, -9.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(9, 9).addBox(1.0F, -9.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 9).addBox(1.0F, -10.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(6, 8).addBox(1.0F, -10.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 8).addBox(1.0F, -11.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(3, 7).addBox(1.0F, -11.0F, 2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
