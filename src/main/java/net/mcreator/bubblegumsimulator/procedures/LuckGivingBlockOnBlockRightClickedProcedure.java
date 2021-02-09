package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class LuckGivingBlockOnBlockRightClickedProcedure extends BubbleGumSimulatorModElements.ModElement {
	public LuckGivingBlockOnBlockRightClickedProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 489);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure LuckGivingBlockOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("CurrentLuck", ((entity.getPersistentData().getDouble("CurrentLuck")) + 1));
	}
}
