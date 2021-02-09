
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
public class NeoneleentEntity extends BubbleGumSimulatorModElements.ModElement {
	public static EntityType entity = null;
	public NeoneleentEntity(BubbleGumSimulatorModElements instance) {
		super(instance, 541);
		FMLJavaModLoadingContext.get().getModEventBus().register(new ModelRegisterHandler());
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("neoneleent")
						.setRegistryName("neoneleent");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -39169, -52429, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("neoneleent_spawn_egg"));
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
				return new MobRenderer(renderManager, new ModelNeonElemental(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("bubble_gum_simulator:textures/eleneon.png");
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
			setCustomName(new StringTextComponent("Neon Elemental"));
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
