package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class Sellblock4EntityWalksOnTheBlockProcedure extends BubbleGumSimulatorModElements.ModElement {
	public Sellblock4EntityWalksOnTheBlockProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 336);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Sellblock4EntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Coincurrency",
				(((entity.getPersistentData().getDouble("Bubbles")) * 4) + (entity.getPersistentData().getDouble("Coincurrency"))));
		entity.getPersistentData().putDouble("Bubbles", ((entity.getPersistentData().getDouble("Bubbles")) * 0));
	}
}
