
package net.mcreator.bubblegumsimulator.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.bubblegumsimulator.itemgroup.BgsbubblebadgesItemGroup;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class GumspecialistbadgeItem extends BubbleGumSimulatorModElements.ModElement {
	@ObjectHolder("bubble_gum_simulator:gumspecialistbadge")
	public static final Item block = null;
	public GumspecialistbadgeItem(BubbleGumSimulatorModElements instance) {
		super(instance, 211);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BgsbubblebadgesItemGroup.tab).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("gumspecialistbadge");
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
			return 1F;
		}
	}
}
