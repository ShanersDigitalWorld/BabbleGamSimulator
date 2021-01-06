
package net.mcreator.bubblegumsimulator.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.bubblegumsimulator.item.BlubblegumItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BgsBubblegumflavorsItemGroup extends BubbleGumSimulatorModElements.ModElement {
	public BgsBubblegumflavorsItemGroup(BubbleGumSimulatorModElements instance) {
		super(instance, 288);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbgs_bubblegumflavors") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BlubblegumItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
