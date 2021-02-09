package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;
import java.util.Iterator;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BasicAdvProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BasicAdvProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 582);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure BasicAdv!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).NormalGumOwned)
				&& ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).BubbleGumFlavorOwned)) == (true))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubbler"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
			if ((((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 100)
					|| (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 500))
					&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubbler")))
									.isDone()
							: false) == (true)))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("bubble_gum_simulator:novice"));
					AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemaningCriteria().iterator();
						while (_iterator.hasNext()) {
							String _criterion = (String) _iterator.next();
							((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
						}
					}
				}
				if (((((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 500)
						|| (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 15000))
						&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("bubble_gum_simulator:novice")))
										.isDone()
								: false)) == (true))) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("bubble_gum_simulator:intermediate"));
						AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemaningCriteria().iterator();
							while (_iterator.hasNext()) {
								String _criterion = (String) _iterator.next();
								((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
							}
						}
					}
					if (((((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 2500)
							|| (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 50000)) == (true))
							&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("bubble_gum_simulator:intermediate")))
											.isDone()
									: false) == (true)))) {
						if (entity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("bubble_gum_simulator:expert"));
							AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemaningCriteria().iterator();
								while (_iterator.hasNext()) {
									String _criterion = (String) _iterator.next();
									((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
								}
							}
						}
						if (((((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 10000)
								|| (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 250000))
								&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("bubble_gum_simulator:expert")))
												.isDone()
										: false)) == (true))) {
							if (entity instanceof ServerPlayerEntity) {
								Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("bubble_gum_simulator:extreme"));
								AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
								if (!_ap.isDone()) {
									Iterator _iterator = _ap.getRemaningCriteria().iterator();
									while (_iterator.hasNext()) {
										String _criterion = (String) _iterator.next();
										((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
