
package net.mcreator.bubblegumsimulator.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Item;

import net.mcreator.bubblegumsimulator.itemgroup.BgssoundtrackItemGroup;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

@BubbleGumSimulatorModElements.ModElement.Tag
public class Bgsst9Item extends BubbleGumSimulatorModElements.ModElement {
	@ObjectHolder("bubble_gum_simulator:bgsst_9")
	public static final Item block = null;
	public Bgsst9Item(BubbleGumSimulatorModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, BubbleGumSimulatorModElements.sounds.get(new ResourceLocation("bubble_gum_simulator:bgsst9")),
					new Item.Properties().group(BgssoundtrackItemGroup.tab).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("bgsst_9");
		}
	}
}
