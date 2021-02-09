
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@BubbleGumSimulatorModElements.ModElement.Tag
public class HolyShockEntity extends BubbleGumSimulatorModElements.ModElement {
	public static EntityType entity = null;
	public HolyShockEntity(BubbleGumSimulatorModElements instance) {
		super(instance, 536);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("holy_shock")
						.setRegistryName("holy_shock");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -16724737, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("holy_shock_spawn_egg"));
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
				return new MobRenderer(renderManager, new ModelHolyShock(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("bubble_gum_simulator:textures/holyshock.png");
					}
				};
			});
		}
	}
	private void setupAttributes() {
		AttributeModifierMap.MutableAttribute ammma = MobEntity.func_233666_p_();
		ammma = ammma.createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3);
		ammma = ammma.createMutableAttribute(Attributes.MAX_HEALTH, 10);
		ammma = ammma.createMutableAttribute(Attributes.ARMOR, 0);
		ammma = ammma.createMutableAttribute(Attributes.ATTACK_DAMAGE, 3);
		GlobalEntityTypeAttributes.put(entity, ammma.create());
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			setCustomName(new StringTextComponent("Holy Shock"));
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
			this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(5, new SwimGoal(this));
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
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}
	}

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
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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
}
