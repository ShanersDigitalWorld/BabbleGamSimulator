package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModVariables;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class OverlayUpdateProProcedure extends BubbleGumSimulatorModElements.ModElement {
	public OverlayUpdateProProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 525);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BubbleGumSimulatorMod.LOGGER.warn("Failed to load dependency entity for procedure OverlayUpdatePro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putString("OverlayBubbles",
				((Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentBubbles))) + "" + ("/") + ""
						+ (Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CurrentGum)))));
		entity.getPersistentData().putString("OverlayTotalBubbles",
				("" + (Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalBubbles)))));
		entity.getPersistentData().putString("OverlayTotalEggs",
				("" + (Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).TotalEggs)))));
		entity.getPersistentData().putString("OverlayCoinCurrency",
				("" + (Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).CoinCurrency)))));
		entity.getPersistentData().putString("OverlayGemCurrency",
				("" + (Math.round(((entity.getCapability(BubbleGumSimulatorModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new BubbleGumSimulatorModVariables.PlayerVariables())).GemCurrency)))));
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
