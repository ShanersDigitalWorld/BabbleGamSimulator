package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.WatermelonblockBlock;
import net.mcreator.bubblegumsimulator.block.VipgumflavorBlock;
import net.mcreator.bubblegumsimulator.block.SwirlBlockBlock;
import net.mcreator.bubblegumsimulator.block.PizzablockBlock;
import net.mcreator.bubblegumsimulator.block.LemonBlockBlock;
import net.mcreator.bubblegumsimulator.block.GoldgumblockBlock;
import net.mcreator.bubblegumsimulator.block.DonutBlockBlock;
import net.mcreator.bubblegumsimulator.block.ContrastblockBlock;
import net.mcreator.bubblegumsimulator.block.ChocolateBlockBlock;
import net.mcreator.bubblegumsimulator.block.CherryBlockBlock;
import net.mcreator.bubblegumsimulator.block.BubbleGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.BlueBerryBlockBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BuyFlavorProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BuyFlavorProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 511);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure BuyFlavorPro!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency x for procedure BuyFlavorPro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency y for procedure BuyFlavorPro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency z for procedure BuyFlavorPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure BuyFlavorPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BubbleGumBlockBlock.block.getDefaultState().getBlock())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BubbleGumFlavorOwned = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).BubbleGumFlavor);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentFlavor = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BlueBerryBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).BlueberryFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).BlueberryFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).BlueberryFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).BlueberryFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlueberryFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).BlueberryFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).BubbleGumFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == PizzablockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).PizzaFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).PizzaFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).PizzaFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).PizzaFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PizzaFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).PuzzleFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).PizzaFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == CherryBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CherryFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).CherryFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CherryFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).CherryFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CherryFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).CherryFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).CherryFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DonutBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).DonutFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).DonutFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).DonutFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).DonutFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DonutFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).DonutFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).DonutFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ChocolateBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ChocolateFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChocolateFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ChocolateFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).ChocolateFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChocolateFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChocolateFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChocolateFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == VipgumflavorBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).VIPGamePass) == (true))) {
				entity.getPersistentData().putBoolean("VIPFlavorOwned", (true));
				entity.getPersistentData().putDouble("VIPFlavor", 16);
				{
					double _setval = (double) (entity.getPersistentData().getDouble("VIPFlavor"));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == WatermelonblockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).WatermelonFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).WatermelonFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).WatermelonFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).WatermelonFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.WatermelonFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).WatermelonFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).WatermelonFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ContrastblockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ContrastFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ContrastFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ContrastFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).ContrastFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ContrastFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).ContrastFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ContrastFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == GoldgumblockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GoldFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).GoldFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GoldFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).GoldFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GoldFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).GoldFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).GoldFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == LemonBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).LemonFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).LemonFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).LemonFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).LemonFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.LemonFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).LemonFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).LemonFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SwirlBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SwirlFlavorOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SwirlFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SwirlFlavorOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).SwirlFlavorValue)))) {
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SwirlFlavorOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).SwirlFlavorValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SwirlFlavor);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentFlavor = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
