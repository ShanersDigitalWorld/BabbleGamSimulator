package net.mcreator.bubblegumsimulator.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.IProperty;
import net.minecraft.server.MinecraftServer;
import net.minecraft.block.BlockState;

import net.mcreator.bubblegumsimulator.block.PetkittyBlock;
import net.mcreator.bubblegumsimulator.block.PetdoggyBlock;
import net.mcreator.bubblegumsimulator.block.PetbunnyBlock;
import net.mcreator.bubblegumsimulator.block.PetbearBlock;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import java.util.Random;
import java.util.Map;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BetatestcommoneggProcedure extends BubbleGumSimulatorModElements.ModElement {
	public BetatestcommoneggProcedure(BubbleGumSimulatorModElements instance) {
		super(instance, 328);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure Betatestcommonegg!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure Betatestcommonegg!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure Betatestcommonegg!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure Betatestcommonegg!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Random()).nextInt((int) 100 + 1)) > 40)) {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = PetdoggyBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_bs.has(_property))
						_bs = _bs.with(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("A Player Hatched A Doggy!"));
			}
		} else if ((((new Random()).nextInt((int) 100 + 1)) > 30)) {
			if ((((new Random()).nextInt((int) 100 + 1)) < 40)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = PetkittyBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_bs.has(_property))
							_bs = _bs.with(_property, (Comparable) entry.getValue());
					}
					world.setBlockState(_bp, _bs, 3);
				}
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("A Player Hatched A Kitty!"));
				}
			}
		} else if ((((new Random()).nextInt((int) 100 + 1)) > 25)) {
			if ((((new Random()).nextInt((int) 100 + 1)) < 30)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = PetbunnyBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_bs.has(_property))
							_bs = _bs.with(_property, (Comparable) entry.getValue());
					}
					world.setBlockState(_bp, _bs, 3);
				}
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("A Player Hatched A Bunny!"));
				}
			}
		} else if ((((new Random()).nextInt((int) 100 + 1)) > 5)) {
			if ((((new Random()).nextInt((int) 100 + 1)) < 25)) {
				{
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					BlockState _bs = PetbearBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_bs.has(_property))
							_bs = _bs.with(_property, (Comparable) entry.getValue());
					}
					world.setBlockState(_bp, _bs, 3);
				}
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("A Player Hatched A Bear!"));
				}
			}
		}
	}
}
