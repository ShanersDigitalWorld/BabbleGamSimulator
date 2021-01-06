package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.item.BlubblegumItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BubblingprocedureProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BubblingprocedureProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 164);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Bubblingprocedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(BlubblegumItem.block, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		entity.getPersistentData().putDouble("Bubbles",
				((entity.getPersistentData().getDouble("Bubbles")) + ((entity.getPersistentData().getDouble("Bubblingamount")) + 1)));
		entity.getPersistentData().putDouble("Totalbubbles",
				((entity.getPersistentData().getDouble("Totalbubbles")) + (entity.getPersistentData().getDouble("Bubbles"))));
	}
}
