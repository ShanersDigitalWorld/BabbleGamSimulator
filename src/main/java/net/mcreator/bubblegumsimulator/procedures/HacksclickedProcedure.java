package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class HacksclickedProcedure extends BubbleGumSimulatorModElements.ModElement {
	public HacksclickedProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 506);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure Hacksclicked!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency guistate for procedure Hacksclicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure Hacksclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:DevCodes");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("MuchLove"))) {
			if (((entity.getPersistentData().getBoolean("tagDevMode")) == (true))) {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Was Already In Dev Mode."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
				entity.getPersistentData().putBoolean("tagDevMode", (false));
			} else {
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Is In Dev Mode."))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				entity.setCustomName(new StringTextComponent("The Boss"));
				entity.getPersistentData().putDouble("tagPlayerx", (entity.getPosX()));
				entity.getPersistentData().putDouble("tagPlayery", (entity.getPosY()));
				entity.getPersistentData().putDouble("tagPlayerz", (entity.getPosZ()));
				entity.setNoGravity((true));
				entity.getPersistentData().putBoolean("tagDevMode", (true));
			}
		}
	}
}
