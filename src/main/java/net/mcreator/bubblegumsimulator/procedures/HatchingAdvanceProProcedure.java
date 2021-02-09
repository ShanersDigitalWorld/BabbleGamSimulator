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
public class HatchingAdvanceProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public HatchingAdvanceProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 573);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure HatchingAdvancePro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 1)) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("bubble_gum_simulator:your_first_pet"));
				AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemaningCriteria().iterator();
					while (_iterator.hasNext()) {
						String _criterion = (String) _iterator.next();
						((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
					}
				}
			}
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 10)
					&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("bubble_gum_simulator:your_first_pet")))
									.isDone()
							: false) == (true)))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("bubble_gum_simulator:pet_collector"));
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
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 20)
						&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("bubble_gum_simulator:pet_collector")))
										.isDone()
								: false)) == (true))) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("bubble_gum_simulator:pet_hoarder"));
						AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements().getProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemaningCriteria().iterator();
							while (_iterator.hasNext()) {
								String _criterion = (String) _iterator.next();
								((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv, _criterion);
							}
						}
					}
					if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 100)
							&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("bubble_gum_simulator:pet_hoarder")))
											.isDone()
									: false) == (true)))) {
						if (entity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_100_eggs"));
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
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 1000)
								&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_100_eggs")))
												.isDone()
										: false)) == (true))) {
							if (entity instanceof ServerPlayerEntity) {
								Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_1000_eggs"));
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
									.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 10000)
									&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
											? ((ServerPlayerEntity) entity).getAdvancements()
													.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
															.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_1000_eggs")))
													.isDone()
											: false)
											|| (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
													? ((ServerPlayerEntity) entity).getAdvancements()
															.getProgress(
																	((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																			.getAdvancement(new ResourceLocation("bubble_gum_simulator:extreme")))
															.isDone()
													: false))) == (true))) {
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_10000_eggs"));
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
										.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 20000)
										&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
												? ((ServerPlayerEntity) entity).getAdvancements()
														.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_10000_eggs")))
														.isDone()
												: false)) == (true))) {
									if (entity instanceof ServerPlayerEntity) {
										Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("bubble_gum_simulator:unreal_hatcher"));
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
											.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 50000)
											&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
													? ((ServerPlayerEntity) entity).getAdvancements()
															.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																	.getAdvancementManager()
																	.getAdvancement(new ResourceLocation("bubble_gum_simulator:unreal_hatcher")))
															.isDone()
													: false)) == (true))) {
										if (entity instanceof ServerPlayerEntity) {
											Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("bubble_gum_simulator:eggmaster"));
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
												.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 100000)
												&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
														? ((ServerPlayerEntity) entity).getAdvancements()
																.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																		.getAdvancementManager()
																		.getAdvancement(new ResourceLocation("bubble_gum_simulator:eggmaster")))
																.isDone()
														: false)) == (true))) {
											if (entity instanceof ServerPlayerEntity) {
												Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_100000_eggs"));
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
													.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 250000)
													&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
															? ((ServerPlayerEntity) entity).getAdvancements()
																	.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																			.getAdvancementManager().getAdvancement(
																					new ResourceLocation("bubble_gum_simulator:hatch_100000_eggs")))
																	.isDone()
															: false)) == (true))) {
												if (entity instanceof ServerPlayerEntity) {
													Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
															.getAdvancementManager()
															.getAdvancement(new ResourceLocation("bubble_gum_simulator:godly_hatcher"));
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
														.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 1000000)
														&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																? ((ServerPlayerEntity) entity).getAdvancements()
																		.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																				.getAdvancementManager().getAdvancement(
																						new ResourceLocation("bubble_gum_simulator:godly_hatcher")))
																		.isDone()
																: false)) == (true))) {
													if (entity instanceof ServerPlayerEntity) {
														Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																.getAdvancementManager()
																.getAdvancement(new ResourceLocation("bubble_gum_simulator:hatch_1000000_eggs"));
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
															.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) >= 5000000)
															&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																	? ((ServerPlayerEntity) entity).getAdvancements()
																			.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																					.getAdvancementManager()
																					.getAdvancement(new ResourceLocation(
																							"bubble_gum_simulator:hatch_1000000_eggs")))
																			.isDone()
																	: false)) == (true))) {
														if (entity instanceof ServerPlayerEntity) {
															Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																	.getAdvancementManager()
																	.getAdvancement(new ResourceLocation("bubble_gum_simulator:no_life"));
															AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements()
																	.getProgress(_adv);
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
						}
					}
				}
			}
		}
	}
}
