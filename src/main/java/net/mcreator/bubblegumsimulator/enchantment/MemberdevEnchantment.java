
package net.mcreator.bubblegumsimulator.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class MemberdevEnchantment extends BubbleGumSimulatorModElements.ModElement {
	@ObjectHolder("bubble_gum_simulator:memberdev")
	public static final Enchantment enchantment = null;
	public MemberdevEnchantment(BubbleGumSimulatorModElements instance) {
		super(instance, 258);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("memberdev"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.ALL, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
