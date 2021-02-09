package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.UnrealGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.UltraGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.SuperGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.SuperDuperGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.StretchyGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.OmegaGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.NormalgumblockBlock;
import net.mcreator.bubblegumsimulator.block.MonsterGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.ExtraStretchyGumBlock;
import net.mcreator.bubblegumsimulator.block.ExtraChewyGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.EpicGumBlockBlock;
import net.mcreator.bubblegumsimulator.block.ChewyGumBlockBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BuyGumProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BuyGumProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 513);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure BuyGumPro!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency x for procedure BuyGumPro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency y for procedure BuyGumPro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency z for procedure BuyGumPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure BuyGumPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == NormalgumblockBlock.block.getDefaultState().getBlock())) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NormalGumOwned = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).NormalGum);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentGum = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Switching To Normal Gum"), ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == StretchyGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).StretchyGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).StretchyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).StretchyGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).StretchyGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).StretchyGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.StretchyGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).StretchyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ExtraStretchyGumBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ExtraStretchyGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraStretchyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ExtraStretchyGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).ExtraStretchyGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraStretchyGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ExtraStretchyGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraStretchyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ChewyGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ChewyGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChewyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ChewyGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).ChewyGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChewyGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChewyGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ChewyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == ExtraChewyGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ExtraChewyGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraChewyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).ExtraChewyGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).ExtraChewyGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraChewyGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ExtraChewyGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).ExtraChewyGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == EpicGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).EpicGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).EpicGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).EpicGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).EpicGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).EpicGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EpicGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).EpicGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SuperGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SuperGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SuperGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).SuperGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SuperGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SuperDuperGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SuperDuperGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperDuperGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).SuperDuperGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).SuperDuperGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperDuperGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.SuperDuperGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).SuperDuperGumValue);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == OmegaGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).OmegaGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).OmegaGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).OmegaGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).OmegaGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).OmegaGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.OmegaGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).OmegaGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == UnrealGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UnrealGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).UnrealGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UnrealGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).UnrealGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).UnrealGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UnrealGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).UnrealGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MonsterGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).MonsterGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).MonsterGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).MonsterGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).MonsterGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).MonsterGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.MonsterGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).MonsterGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == UltraGumBlockBlock.block.getDefaultState()
				.getBlock())) {
			if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UltraGumOwned) == (true))) {
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).UltraGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UltraGumOwned) == (false))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(
							new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
									.get(world).UltraGumValue)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
							- (BubbleGumSimulatorModVariables.WorldVariables.get(world).UltraGumValue));
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UltraGumOwned = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) (BubbleGumSimulatorModVariables.WorldVariables.get(world).UltraGum);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CurrentGum = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
