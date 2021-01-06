
package net.mcreator.bubblegumsimulator.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.bubblegumsimulator.item.Hatch100eggsbadgeItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BgshatchbadgesItemGroup extends BubbleGumSimulatorModElements.ModElement {
	public BgshatchbadgesItemGroup(BubbleGumSimulatorModElements instance) {
		super(instance, 221);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbgshatchbadges") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Hatch100eggsbadgeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
