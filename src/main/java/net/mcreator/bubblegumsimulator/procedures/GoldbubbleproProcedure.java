package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class GoldbubbleproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public GoldbubbleproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 315);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Goldbubblepro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Bubbles", ((entity.getPersistentData().getDouble("Bubbles")) + 35));
	}
}
