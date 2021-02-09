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

import net.mcreator.bubblegumsimulator.block.PetkittyBlock;
import net.mcreator.bubblegumsimulator.block.PetdoggyBlock;
import net.mcreator.bubblegumsimulator.block.PetbunnyBlock;
import net.mcreator.bubblegumsimulator.block.PetbearBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class CommonEggHatchingproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public CommonEggHatchingproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 490);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure CommonEggHatchingpro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure CommonEggHatchingpro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double Random = 0;
		if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) >= (BubbleGumSimulatorModVariables.WorldVariables
						.get(world).CommonEggValue))) {
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)
						- (BubbleGumSimulatorModVariables.WorldVariables.get(world).CommonEggValue));
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
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Doggy With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PetdoggyBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) >= 30) && ((Random) < 60))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Kitty With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PetkittyBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) > 5) && ((Random) < 30))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Bunny With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PetbunnyBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				entity.getPersistentData().putDouble("EggNumGen", (Random));
			} else if ((((Random) > 0) && ((Random) <= 5))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Hatched A Bear With A Rarity Of ")
												+ "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(PetbearBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			} else if (((Random) == (1e-7))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((("\u00A74[Server]:") + "" + ((entity.getDisplayName().getString())) + ""
												+ (" Just Hatched A Legendary 'King Doggy' (") + ""
												+ ((entity.getPersistentData().getDouble("Rarity"))) + "" + (")!\u00A7r"))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalSecretsHatched) + 1);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.TotalSecretsHatched = _setval;
						capability.syncPlayerVariables(entity);
					});
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
