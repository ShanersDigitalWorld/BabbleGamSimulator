package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.item.ItemStack;

import net.mcreator.bubblegumsimulator.item.CoinsItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class CoinsItemIsDroppedByPlayerProcedure extends BubbleGumSimulatorModElements.ModElement {
	public CoinsItemIsDroppedByPlayerProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 301);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure CoinsItemIsDroppedByPlayer!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		(itemstack).getOrCreateTag().putDouble("Coincurrency", (((itemstack).getOrCreateTag().getDouble("Coincurrency")) + 1));
		{
			ItemStack _isc = (itemstack);
			final ItemStack _setstack = new ItemStack(CoinsItem.block, (int) (1));
			final int _sltid = (int) (0);
			_setstack.setCount((int) 1);
			_isc.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
				if (capability instanceof IItemHandlerModifiable) {
					((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
				}
			});
		}
	}
}
