package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.PetdoggyBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.function.Supplier;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class PetdoggyOnBlockRightClickedProcedure extends BubbleGumSimulatorModElements.ModElement {
	public PetdoggyOnBlockRightClickedProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 280);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PetdoggyOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(PetdoggyBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
