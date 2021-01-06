package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.item.ItemBubblegumItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class ItemBubblegumOnPlayerStoppedUsingProcedure extends BubbleGumSimulatorModElements.ModElement {
	public ItemBubblegumOnPlayerStoppedUsingProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 375);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure ItemBubblegumOnPlayerStoppedUsing!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(ItemBubblegumItem.block, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}
