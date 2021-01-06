package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BlueberrybubbleproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BlueberrybubbleproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 302);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Blueberrybubblepro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Bubbles", ((entity.getPersistentData().getDouble("Bubbles")) + 2));
	}
}
