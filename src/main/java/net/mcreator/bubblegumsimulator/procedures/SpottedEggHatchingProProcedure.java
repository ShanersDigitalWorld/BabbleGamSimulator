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

import net.mcreator.bubblegumsimulator.block.SmokygreyblockBlock;
import net.mcreator.bubblegumsimulator.block.SeagreenblockBlock;
import net.mcreator.bubblegumsimulator.block.CyanblockBlock;
import net.mcreator.bubblegumsimulator.block.CashmereblockBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class SpottedEggHatchingProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public SpottedEggHatchingProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 491);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure SpottedEggHatchingPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure SpottedEggHatchingPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double Random = 0;
		if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= 3200)) {
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) - 3200);
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
			if (((Random) >= 30)) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Mouse With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(CashmereblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 25) && ((Random) < 30))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Wolf With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SeagreenblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 20) && ((Random) < 25))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Fox With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(CyanblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 15) && ((Random) < 20))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent(
												(((entity.getDisplayName().getString())) + "" + (" Hatched A Polar Bear With A Rarity Of ") + ""
														+ (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SmokygreyblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if ((((Random) >= 10) && ((Random) < 15))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Panda With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SmokygreyblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
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
