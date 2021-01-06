
package net.mcreator.bubblegumsimulator.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.bubblegumsimulator.item.NovicebadgeItem;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BgsbubblebadgesItemGroup extends BubbleGumSimulatorModElements.ModElement {
	public BgsbubblebadgesItemGroup(BubbleGumSimulatorModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabbgsbubblebadges") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NovicebadgeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
