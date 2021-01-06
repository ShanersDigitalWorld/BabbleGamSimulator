package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BubblegumbubbleproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BubblegumbubbleproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 303);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Bubblegumbubblepro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Bubbles", ((entity.getPersistentData().getDouble("Bubbles")) + 1));
		entity.getPersistentData().putDouble("Totalbubbles", ((entity.getPersistentData().getDouble("Totalbubbles")) + 1));
	}
}
