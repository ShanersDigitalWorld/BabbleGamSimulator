package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class GuiShopCondition1Procedure extends BubbleGumSimulatorModElements.ModElement {
	public GuiShopCondition1Procedure(BubbleGumSimulatorModElements instance) {
		super(instance, 601);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure GuiShopCondition1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setCustomName(new StringTextComponent("Neta"));
	}
}
