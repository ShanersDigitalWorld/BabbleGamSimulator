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
public class BubbleAdvanceProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BubbleAdvanceProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 530);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure BubbleAdvancePro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 7500)
				&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
						? ((ServerPlayerEntity) entity).getAdvancements()
								.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("bubble_gum_simulator:extreme")))
								.isDone()
						: false) == (true)))) {
			if (entity instanceof ServerPlayerEntity) {
				Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
						.getAdvancement(new ResourceLocation("bubble_gum_simulator:extreme_bubbler"));
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
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 15000)
					&& ((((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
							? ((ServerPlayerEntity) entity).getAdvancements()
									.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("bubble_gum_simulator:extreme_bubbler")))
									.isDone()
							: false) == (true)))) {
				if (entity instanceof ServerPlayerEntity) {
					Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
							.getAdvancement(new ResourceLocation("bubble_gum_simulator:gum_specialist"));
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
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 45000)
						&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
								? ((ServerPlayerEntity) entity).getAdvancements()
										.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("bubble_gum_simulator:gum_specialist")))
										.isDone()
								: false)) == (true))) {
					if (entity instanceof ServerPlayerEntity) {
						Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
								.getAdvancement(new ResourceLocation("bubble_gum_simulator:incredible_bubbler"));
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
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 100000)
							&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
									? ((ServerPlayerEntity) entity).getAdvancements()
											.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("bubble_gum_simulator:incredible_bubbler")))
											.isDone()
									: false)) == (true))) {
						if (entity instanceof ServerPlayerEntity) {
							Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
									.getAdvancement(new ResourceLocation("bubble_gum_simulator:outrageous_bubbler"));
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
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 250000)
								&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
										? ((ServerPlayerEntity) entity).getAdvancements()
												.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("bubble_gum_simulator:outrageous_bubbler")))
												.isDone()
										: false)) == (true))) {
							if (entity instanceof ServerPlayerEntity) {
								Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
										.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubble_enthusiast"));
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
									.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 500000)
									&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
											? ((ServerPlayerEntity) entity).getAdvancements()
													.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
															.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubble_enthusiast")))
													.isDone()
											: false)) == (true))) {
								if (entity instanceof ServerPlayerEntity) {
									Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
											.getAdvancement(new ResourceLocation("bubble_gum_simulator:unreal_bubbler"));
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
										.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= 750000)
										&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
												? ((ServerPlayerEntity) entity).getAdvancements()
														.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
																.getAdvancement(new ResourceLocation("bubble_gum_simulator:unreal_bubbler")))
														.isDone()
												: false)) == (true))) {
									if (entity instanceof ServerPlayerEntity) {
										Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
												.getAdvancement(new ResourceLocation("bubble_gum_simulator:gum_extremist"));
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
											.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (15000 * 100))
											&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
													? ((ServerPlayerEntity) entity).getAdvancements()
															.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																	.getAdvancementManager()
																	.getAdvancement(new ResourceLocation("bubble_gum_simulator:gum_extremist")))
															.isDone()
													: false)) == (true))) {
										if (entity instanceof ServerPlayerEntity) {
											Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
													.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubble_connoisseur"));
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
												.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (35000 * 100))
												&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
														? ((ServerPlayerEntity) entity).getAdvancements()
																.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																		.getAdvancementManager().getAdvancement(
																				new ResourceLocation("bubble_gum_simulator:bubble_connoisseur")))
																.isDone()
														: false)) == (true))) {
											if (entity instanceof ServerPlayerEntity) {
												Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server).getAdvancementManager()
														.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubble_master"));
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
													.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (75000 * 100))
													&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
															? ((ServerPlayerEntity) entity).getAdvancements()
																	.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																			.getAdvancementManager().getAdvancement(
																					new ResourceLocation("bubble_gum_simulator:bubble_master")))
																	.isDone()
															: false)) == (true))) {
												if (entity instanceof ServerPlayerEntity) {
													Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
															.getAdvancementManager()
															.getAdvancement(new ResourceLocation("bubble_gum_simulator:bubble_champion"));
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
														.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (250000
																* 100))
														&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																? ((ServerPlayerEntity) entity).getAdvancements()
																		.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																				.getAdvancementManager().getAdvancement(
																						new ResourceLocation("bubble_gum_simulator:bubble_champion")))
																		.isDone()
																: false)) == (true))) {
													if (entity instanceof ServerPlayerEntity) {
														Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																.getAdvancementManager()
																.getAdvancement(new ResourceLocation("bubble_gum_simulator:grand_master"));
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
															.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (500000
																	* 100))
															&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																	? ((ServerPlayerEntity) entity).getAdvancements()
																			.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																					.getAdvancementManager()
																					.getAdvancement(new ResourceLocation(
																							"bubble_gum_simulator:grand_master")))
																			.isDone()
																	: false)) == (true))) {
														if (entity instanceof ServerPlayerEntity) {
															Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																	.getAdvancementManager()
																	.getAdvancement(new ResourceLocation("bubble_gum_simulator:grand_champion"));
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
														if ((((((entity
																.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (1500000
																		* 100))
																&& (((entity instanceof ServerPlayerEntity) && (entity.world instanceof ServerWorld))
																		? ((ServerPlayerEntity) entity).getAdvancements()
																				.getProgress(((MinecraftServer) ((ServerPlayerEntity) entity).server)
																						.getAdvancementManager()
																						.getAdvancement(new ResourceLocation(
																								"bubble_gum_simulator:grand_champion")))
																				.isDone()
																		: false)) == (true))) {
															if (entity instanceof ServerPlayerEntity) {
																Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																		.getAdvancementManager()
																		.getAdvancement(new ResourceLocation("bubble_gum_simulator:godly_bubbler"));
																AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements()
																		.getProgress(_adv);
																if (!_ap.isDone()) {
																	Iterator _iterator = _ap.getRemaningCriteria().iterator();
																	while (_iterator.hasNext()) {
																		String _criterion = (String) _iterator.next();
																		((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv,
																				_criterion);
																	}
																}
															}
															if ((((((entity
																	.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles) >= (50000000
																			* 100))
																	&& (((entity instanceof ServerPlayerEntity)
																			&& (entity.world instanceof ServerWorld))
																					? ((ServerPlayerEntity) entity).getAdvancements().getProgress(
																							((MinecraftServer) ((ServerPlayerEntity) entity).server)
																									.getAdvancementManager()
																									.getAdvancement(new ResourceLocation(
																											"bubble_gum_simulator:godly_bubbler")))
																							.isDone()
																					: false)) == (true))) {
																if (entity instanceof ServerPlayerEntity) {
																	Advancement _adv = ((MinecraftServer) ((ServerPlayerEntity) entity).server)
																			.getAdvancementManager().getAdvancement(
																					new ResourceLocation("bubble_gum_simulator:simply_insane"));
																	AdvancementProgress _ap = ((ServerPlayerEntity) entity).getAdvancements()
																			.getProgress(_adv);
																	if (!_ap.isDone()) {
																		Iterator _iterator = _ap.getRemaningCriteria().iterator();
																		while (_iterator.hasNext()) {
																			String _criterion = (String) _iterator.next();
																			((ServerPlayerEntity) entity).getAdvancements().grantCriterion(_adv,
																					_criterion);
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
	}
}
