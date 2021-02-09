package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.SellblockBlock;
import net.mcreator.bubblegumsimulator.block.Sellblock7Block;
import net.mcreator.bubblegumsimulator.block.Sellblock6Block;
import net.mcreator.bubblegumsimulator.block.Sellblock5Block;
import net.mcreator.bubblegumsimulator.block.Sellblock4Block;
import net.mcreator.bubblegumsimulator.block.Sellblock3Block;
import net.mcreator.bubblegumsimulator.block.Sellblock2Block;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class SellbubblesproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public SellbubblesproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 240);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure Sellbubblespro!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency x for procedure Sellbubblespro!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency y for procedure Sellbubblespro!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency z for procedure Sellbubblespro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure Sellbubblespro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SellblockBlock.block.getDefaultState().getBlock())) {
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock2Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 2)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock3Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 4)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock4Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 5)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock5Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 6)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock6Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 7)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Sellblock7Block.block.getDefaultState()
				.getBlock())) {
			{
				double _setval = (double) ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 8)
						+ ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency));
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles) * 0);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CurrentBubbles = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
