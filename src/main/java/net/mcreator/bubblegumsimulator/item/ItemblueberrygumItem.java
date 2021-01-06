
package net.mcreator.bubblegumsimulator.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.bubblegumsimulator.itemgroup.BgsBubblegumflavorsItemGroup;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class ItemblueberrygumItem extends BubbleGumSimulatorModElements.ModElement {
	@ObjectHolder("bubble_gum_simulator:itemblueberrygum")
	public static final Item block = null;
	public ItemblueberrygumItem(BubbleGumSimulatorModElements instance) {
		super(instance, 319);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BgsBubblegumflavorsItemGroup.tab).maxStackSize(0).rarity(Rarity.COMMON));
			setRegistryName("itemblueberrygum");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 0F;
		}
	}
}
