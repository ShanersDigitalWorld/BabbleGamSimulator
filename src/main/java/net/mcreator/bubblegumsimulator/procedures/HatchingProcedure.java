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
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class HatchingProcedure extends BubbleGumSimulatorModElements.ModElement {
	public HatchingProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 232);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure Hatching!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure Hatching!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double Random = 0;
		Random = (double) (Math.random() * 100);
		if (((Random) >= 40)) {
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
		} else if ((((Random) >= 30) && ((Random) < 40))) {
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
		} else if ((((Random) >= 25) && ((Random) < 30))) {
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
		} else if ((((Random) >= 5) && ((Random) < 25))) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.func_232641_a_(new StringTextComponent((((entity.getDisplayName().getString())) + ""
									+ (" Hatched A Bear With A Rarity Of ") + "" + (Math.round((entity.getPersistentData().getDouble("Rarity")))))),
									ChatType.SYSTEM, Util.DUMMY_UUID);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(PetbearBlock.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
	}
}
