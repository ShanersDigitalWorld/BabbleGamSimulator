package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.TextFieldWidget;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

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
				System.err.println("Failed to load dependency entity for procedure Codespro!");
			return;
		}
		if (dependencies.get("guistate") == null) {
			if (!dependencies.containsKey("guistate"))
				System.err.println("Failed to load dependency guistate for procedure Codespro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap guistate = (HashMap) dependencies.get("guistate");
		if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("Tofuu"))) {
			if (((entity.getPersistentData().getDouble("Tofuutag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Coincurrency", ((entity.getPersistentData().getDouble("Coincurrency")) + 5000));
				entity.getPersistentData().putDouble("Tofuutag", 1);
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
			if (((entity.getPersistentData().getDouble("Freecoinstag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Coincurrency", ((entity.getPersistentData().getDouble("Coincurrency")) + 150));
				entity.getPersistentData().putDouble("Freecoinstag", 1);
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
			if (((entity.getPersistentData().getDouble("ObscureEntitytag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Coincurrency", ((entity.getPersistentData().getDouble("Coincurrency")) + 500));
				entity.getPersistentData().putDouble("ObscureEntitytag", 1);
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
			if (((entity.getPersistentData().getDouble("Minimetag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Coincurrency", ((entity.getPersistentData().getDouble("Coincurrency")) + 2500));
				entity.getPersistentData().putDouble("Minimetag", 1);
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
			if (((entity.getPersistentData().getDouble("LotsOfGemstag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Gemcurrency", ((entity.getPersistentData().getDouble("Gemcurrency")) + 25));
				entity.getPersistentData().putDouble("LotsOfGemstag", 1);
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
			if (((entity.getPersistentData().getDouble("SuperGemstag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Gemcurrency", ((entity.getPersistentData().getDouble("Gemcurrency")) + 100));
				entity.getPersistentData().putDouble("SuperGemstag", 1);
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
			if (((entity.getPersistentData().getDouble("Twiistedtag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Gemcurrency", ((entity.getPersistentData().getDouble("Gemcurrency")) + 5000));
				entity.getPersistentData().putDouble("Twiistedtag", 1);
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
			if (((entity.getPersistentData().getDouble("BlueCrewtag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Gemcurrency", ((entity.getPersistentData().getDouble("Gemcurrency")) + 5000));
				entity.getPersistentData().putDouble("BlueCrewtag", 1);
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
			if (((entity.getPersistentData().getDouble("SuperCoinstag")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Coincurrency", ((entity.getPersistentData().getDouble("Coincurrency")) + 1000));
				entity.getPersistentData().putDouble("SuperCoinstag", 1);
			}
		} else if ((((new Object() {
			public String getText() {
				TextFieldWidget textField = (TextFieldWidget) guistate.get("text:codesin");
				if (textField != null) {
					return textField.getText();
				}
				return "";
			}
		}.getText())).equals("pinkarmypet"))) {
			if (((entity.getPersistentData().getDouble("Pinkarmypet")) == 1)) {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Already Used"));
				}
			} else {
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("Code Active"));
				}
				entity.getPersistentData().putDouble("Gemcurrency", ((entity.getPersistentData().getDouble("Gemcurrency")) + 5000));
				entity.getPersistentData().putDouble("Pinkarmypet", 1);
			}
		} else {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("Wrong Code"));
			}
		}
	}
}
