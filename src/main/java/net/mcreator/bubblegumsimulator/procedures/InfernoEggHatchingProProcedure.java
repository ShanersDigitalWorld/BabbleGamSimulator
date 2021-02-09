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

import net.mcreator.bubblegumsimulator.block.CashmereblockBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class InfernoEggHatchingProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public InfernoEggHatchingProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 493);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure InfernoEggHatchingPro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure InfernoEggHatchingPro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double Random = 0;
		if ((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).MobuxCurrency) >= 229)) {
			{
				double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).MobuxCurrency) - 229);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MobuxCurrency = _setval;
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
			Random = (double) (Math.random() * 0);
			entity.getPersistentData().putDouble("Rarity", (Random));
			if (((Random) == 0)) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList()
								.func_232641_a_(
										new StringTextComponent((("\u00A7b[Server]:") + "" + ((entity.getDisplayName().getString())) + ""
												+ (" Hatched A Legendary 'Inferno Dragon' (") + ""
												+ ((entity.getPersistentData().getDouble("Rarity"))) + "" + (")!\u00A7r"))),
										ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(CashmereblockBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalLegendsHatched) + 1);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.TotalLegendsHatched = _setval;
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
