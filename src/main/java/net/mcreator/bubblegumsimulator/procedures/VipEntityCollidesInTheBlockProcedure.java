package net.mcreator.bubblegumsimulator.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.IProperty;
import net.minecraft.block.BlockState;
import net.minecraft.advancements.Advancement;

import net.mcreator.bubblegumsimulator.block.VipunlockedBlock;
import net.mcreator.bubblegumsimulator.block.VipBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class VipEntityCollidesInTheBlockProcedure extends BubbleGumSimulatorModElements.ModElement {
	public VipEntityCollidesInTheBlockProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 151);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("advancement") == null) {
			if (!dependencies.containsKey("advancement"))
				System.err.println("Failed to load dependency advancement for procedure VipEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure VipEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure VipEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure VipEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure VipEntityCollidesInTheBlock!");
			return;
		}
		Advancement advancement = (Advancement) dependencies.get("advancement");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getWorld().getServer() != null
				? world.getWorld().getServer().getAdvancementManager().getAdvancement(new ResourceLocation("bubble_gum_simulator:bgs_vip"))
						.equals(advancement)
				: false)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), VipunlockedBlock.block.getDefaultState(), 3);
		} else {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = VipBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
