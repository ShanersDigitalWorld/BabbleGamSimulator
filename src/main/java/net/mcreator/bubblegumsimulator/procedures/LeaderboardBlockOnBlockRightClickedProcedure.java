package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class LeaderboardBlockOnBlockRightClickedProcedure extends BubbleGumSimulatorModElements.ModElement {
	public LeaderboardBlockOnBlockRightClickedProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 486);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure LeaderboardBlockOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency world for procedure LeaderboardBlockOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		String PlayerNames = "";
		double Playercounts = 0;
		double PlayerBubbles = 0;
		entity.getPersistentData().putString("PlayerNames", (entity.getDisplayName().getString()));
		entity.getPersistentData().putDouble("PlayerBubbles", ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles));
		entity.getPersistentData().putDouble("PlayerCounts", (world.getPlayers().size()));
		entity.getPersistentData().putString("LBP1N", (entity.getDisplayName().getString()));
		entity.getPersistentData().putDouble("LBP1B", ((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles));
		entity.getPersistentData().putDouble("LBP1R", (world.getPlayers().size()));
	}
}
