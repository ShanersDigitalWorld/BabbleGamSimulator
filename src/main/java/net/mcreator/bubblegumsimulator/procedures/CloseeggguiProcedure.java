package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class CloseeggguiProcedure extends BubbleGumSimulatorModElements.ModElement {
	public CloseeggguiProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 225);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure Closeegggui!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
