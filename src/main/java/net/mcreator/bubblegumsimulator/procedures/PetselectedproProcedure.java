package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bubblegumsimulator.block.PetdoggyBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.function.Supplier;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class PetselectedproProcedure extends BubbleGumSimulatorModElements.ModElement {
	public PetselectedproProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 356);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Petselectedpro!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == new ItemStack(PetdoggyBlock.block, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(PetdoggyBlock.block, (int) (1));
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			entity.getPersistentData().putString("Petselected", "Doggy");
			entity.getPersistentData().putString("Petname", "Doggy");
			entity.getPersistentData().putDouble("Petbubbles", (entity.getPersistentData().getDouble("Doggybubbles")));
			entity.getPersistentData().putDouble("Petcoins", (entity.getPersistentData().getDouble("Doggycoins")));
			entity.getPersistentData().putDouble("Petgems", (entity.getPersistentData().getDouble("Doggygems")));
			entity.getPersistentData().putDouble("Petcurrency", (entity.getPersistentData().getDouble("Doggycurrency")));
		}
		entity.getPersistentData().putString("Petselected", "None");
		entity.getPersistentData().putString("Petname", "None");
		entity.getPersistentData().putDouble("Petbubbles", 0);
		entity.getPersistentData().putDouble("Petcoins", 0);
		entity.getPersistentData().putDouble("Petgems", 0);
		entity.getPersistentData().putDouble("Petcurrency", 0);
	}
}
