
package net.mcreator.bubblegumsimulator.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BgssoundtrackItemGroup extends BubbleGumSimulatorModElements.ModElement {
	public BgssoundtrackItemGroup(BubbleGumSimulatorModElements instance) {
		super(instance, 105);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbgssoundtrack") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.MUSIC_DISC_MALL, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
