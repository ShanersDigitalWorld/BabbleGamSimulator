
package net.mcreator.bubblegumsimulator.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.bubblegumsimulator.procedures.ItemBubblegumOnPlayerStoppedUsingProcedure;
import net.mcreator.bubblegumsimulator.procedures.BubblingprocedureProcedure;
import net.mcreator.bubblegumsimulator.procedures.BubblegumbubbleproProcedure;
import net.mcreator.bubblegumsimulator.itemgroup.BgsBubblegumflavorsItemGroup;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class ItemBubblegumItem extends BubbleGumSimulatorModElements.ModElement {
	@ObjectHolder("bubble_gum_simulator:item_bubblegum")
	public static final Item block = null;
	public ItemBubblegumItem(BubbleGumSimulatorModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(BgsBubblegumflavorsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("item_bubblegum");
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

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				BubblingprocedureProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}

		@Override
		public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
			boolean retval = super.onEntitySwing(itemstack, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				BubblegumbubbleproProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entity, int time) {
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ItemBubblegumOnPlayerStoppedUsingProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
