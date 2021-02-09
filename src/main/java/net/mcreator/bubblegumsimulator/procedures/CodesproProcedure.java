package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class CodesproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public CodesproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 340);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure Codespro!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency guistate for procedure Codespro!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure Codespro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("pinkarmypet"))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CodeVerified = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodepinkarmypet) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency) + 5000);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GemCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodepinkarmypet = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("BlueCrew"))) {
			{
				boolean _setval = (boolean) (true);
				entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CodeVerified = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeBlueCrew) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency) + 5000);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GemCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeBlueCrew = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("SuperGems"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeSuperGems) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency) + 100);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GemCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeSuperGems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("Twiisted"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeTwisted) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency) + 5000);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GemCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeTwisted = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("LotsOfGems"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeLotsOfGems) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency) + 25);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.GemCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeLotsOfGems = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("Tofuu"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeTofuu) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) + 5000);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeTofuu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("Minime"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeMinime) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) + 2500);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeMinime = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("ObscureEntity"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeObscureEntity) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) + 500);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeObscureEntity = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("SuperCoins"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeSuperCoins) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) + 1000);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeSuperCoins = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("FreeCoins"))) {
			if (((((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CodeVerified) == (true))
					&& (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).UsedCodeFreeCoins) == (false)))) {
				{
					double _setval = (double) (((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency) + 150);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CoinCurrency = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Knows Codes!"))), ChatType.SYSTEM,
								Util.DUMMY_UUID);
				}
				{
					boolean _setval = (boolean) (true);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.UsedCodeFreeCoins = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					boolean _setval = (boolean) (false);
					entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.CodeVerified = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (!world.isRemote()) {
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().func_232641_a_(
								new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" You Already Used That Code."))),
								ChatType.SYSTEM, Util.DUMMY_UUID);
				}
			}
		} else {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(
							new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" Doesn't Seem To Know Any Codes."))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
	}
}
