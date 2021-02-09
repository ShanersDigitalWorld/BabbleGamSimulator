package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.SellblockBlock;
import net.mcreator.bubblegumsimulator.block.RustblockBlock;
import net.mcreator.bubblegumsimulator.block.RainbowblockBlock;
import net.mcreator.bubblegumsimulator.block.ForestgreenblockBlock;
import net.mcreator.bubblegumsimulator.block.BluewhiteblockBlock;
import net.mcreator.bubblegumsimulator.block.BlackblockBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class SpikeyEggHatchingProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public SpikeyEggHatchingProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 492);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure SpikeyEggHatchingPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure SpikeyEggHatchingPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double Random = 0;
		if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= 35000)) {
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) - 35000);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoinCurrency = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs) + 1);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TotalEggs = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			Random = (double) (Math.random() * 100);
			entity.getPersistentData().putDouble("Rarity", (Random));
			if (((Random) >= 60)) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Golem With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(RainbowblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 20) && ((Random) < 60))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Dino With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(BlackblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 12) && ((Random) < 20))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent(
												(((entity.getDisplayName().getString())) + "" + (" Hatched A Ruby Golem With A Rarity Of ") + ""
														+ (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(BluewhiteblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 7) && ((Random) < 12))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent(
												(((entity.getDisplayName().getString())) + "" + (" Hatched A Polar Dragon With A Rarity Of ") + ""
														+ (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(RustblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if ((((Random) >= 1) && ((Random) < 7))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent(
												(((entity.getDisplayName().getString())) + "" + (" Hatched A Dark Dragon With A Rarity Of ") + ""
														+ (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SellblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if ((((Random) >= 0) && ((Random) < 1))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((("\u00A7b[Server]:") + "" + ((entity.getDisplayName().getString())) + ""
										+ (" Hatched A Legendary 'Emerald Golem' (") + ""
										+ (Math.round((entity.getPersistentData().getDouble("Rarity")))) + "" + (")!\u00A7r"))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ForestgreenblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				Random = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalLegendsHatched) + 1);
			}
		} else {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Dont Have Enough Currency For This Egg"))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}
}
