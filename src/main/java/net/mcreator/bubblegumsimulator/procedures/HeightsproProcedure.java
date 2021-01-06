package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class HeightsproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public HeightsproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 324);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Heightspro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("Heights", (entity.getPosY()));
	}

	@SubscribeEvent
	public void onEntityJump(LivingEvent.LivingJumpEvent event) {
		LivingEntity entity = event.getEntityLiving();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = entity.world;
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
