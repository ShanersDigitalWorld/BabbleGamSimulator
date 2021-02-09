package net.mcreator.bubblegumsimulator;

import org.spongepowered.asm.mixin.Unique;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class BubbleGumSimulatorModVariables {
	public BubbleGumSimulatorModVariables(BubbleGumSimulatorModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}
	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "bubble_gum_simulator_worldvars";
		public double NormalFace = 0;
		public double NormalFaceValue = 0;
		public double BubbleGumFlavorValue = 0.0;
		public double NormalGumValue = 0.0;
		public double BubbleGumFlavor = 1.0;
		public double RedGlowingEyesFaceValue = 1.02E9;
		public double RainbowFlavorValue = 1.06E7;
		public double FireGumValue = 1.0E10;
		public double QuantumGum = 1.0E45;
		public double SweetGum = 1.0E7;
		public double FireGum = 1.0E8;
		public double OceanGumValue = 1.0E9;
		public double AzureWrathFaceValue = 1.11E10;
		public double FriendlyPirateFaceValue = 1.15E7;
		public double SprinklesFlavorValue = 1.2E10;
		public double SandyGum = 1.2E7;
		public double XDFaceValue = 1.35E8;
		public double TriangularFlavorValue = 1.3E8;
		public double SugarGumValue = 1.55E8;
		public double ScarFaceValue = 1.5E8;
		public double RedRawrFaceValue = 1.5E9;
		public double InfernoFlavorValue = 1.7E11;
		public double CrimsonWrathFaceValue = 1.81E10;
		public double IcecreamFlavorValue = 1.9E10;
		public double DonutFlavor = 10.0;
		public double BubbleTroubleFace = 100.0;
		public double ExtraStretchyGum = 100.0;
		public double ScarFace = 1000.0;
		public double SuperDuperGum = 1000.0;
		public double HeroicGum = 100000.0;
		public double Experiment54Gum = 1000000.0;
		public double WatermelonFlavorValue = 10200.0;
		public double VoidFlavor = 105.0;
		public double RubyFlavorValue = 105000.0;
		public double IntenseFlavor = 11000.0;
		public double ExtraChewyGumValue = 1200.0;
		public double OmegaGumValue = 12325.0;
		public double AlienGum = 125000.0;
		public double LavaFlavorValue = 1250000.0;
		public double MythicalGumValue = 130000.0;
		public double AquaFlavor = 135.0;
		public double YumFace = 1400.0;
		public double ChocolateFlavor = 15.0;
		public double PopcornFlavor = 1560.0;
		public double VIPFlavor = 16.0;
		public double CherryFlavorValue = 1600.0;
		public double UnrealGumValue = 16750.0;
		public double ChewyGum = 170.0;
		public double BlueberryFlavorValue = 175.0;
		public double StretchyGumValue = 175.0;
		public double OmegaGum = 1750.0;
		public double ContrastFlavorValue = 17500.0;
		public double LegendaryGum = 17500.0;
		public double PlasmaFlavor = 180.0;
		public double CrimsonEvilEyeFace = 1800.0;
		public double BlueberryFlavor = 2.0;
		public double DoggyCoins = 2.0;
		public double DoubleChewGamePass = 2.0;
		public double FishGum = 2.25E7;
		public double GreenBubbleFaceValue = 2.5E7;
		public double SourGum = 2.5E7;
		public double EvilSkepticFaceValue = 2.5E9;
		public double PuzzleFlavorValue = 2.5E9;
		public double VampireFaceValue = 2.8E10;
		public double WatermelonFlavor = 22.0;
		public double FinnMcCoolFace = 220.0;
		public double EpicGumValue = 2200.0;
		public double UnrealGum = 2250.0;
		public double GoldFlavorValue = 22500.0;
		public double RedTangoFace = 2260.0;
		public double VoidFlavorValue = 245000.0;
		public double NormalGum = 25.0;
		public double CommonEggValue = 250.0;
		public double ExtraChewyGum = 250.0;
		public double LavaFlavor = 250.0;
		public double MythicalGum = 25000.0;
		public double RadioactiveGum = 250000.0;
		public double MonsterGumValue = 25500.0;
		public double GodlyGumValue = 260000.0;
		public double AlienGumValue = 2694000.0;
		public double PuzzleFlavor = 2750.0;
		public double TrippleHatchGamePass = 3.0;
		public double SandyGumValue = 3.25E8;
		public double SpicyFlavorValue = 3.3E11;
		public double YumFaceValue = 3.4E8;
		public double Experiment32GumValue = 3.5E7;
		public double ContrastFlavor = 30.0;
		public double EpicGum = 300.0;
		public double FriendlyPirateFace = 300.0;
		public double RedGlowingEyesFace = 3050.0;
		public double LemonFlavorValue = 31000.0;
		public double VenomFlavorValue = 3100000.0;
		public double DonutFlavorValue = 3200.0;
		public double RedRawrFace = 3250.0;
		public double VIPFlavorValue = 349.0;
		public double GoldFlavor = 35.0;
		public double MonsterGum = 3500.0;
		public double UltraGumValue = 35500.0;
		public double SprinklesFlavor = 3600.0;
		public double EvilSkepticFace = 3850.0;
		public double PizzaFlavor = 4.0;
		public double StitchesFaceValue = 4.0E10;
		public double BlueBubbleFaceValue = 4.3E7;
		public double OceanGum = 4.5E7;
		public double MoltonFlavorValue = 4.75E10;
		public double SweetGumValue = 4.75E8;
		public double ExtraStretchyGumValue = 400.0;
		public double BubbleTroubleFaceValue = 400000.0;
		public double AquaFlavorValue = 410000.0;
		public double PineappleFlavor = 4150.0;
		public double LemonFlavor = 42.0;
		public double UniversalGumValue = 425000.0;
		public double BeastModeFace = 4350.0;
		public double SwirlFlavorValue = 44000.0;
		public double StretchyGum = 45.0;
		public double SuperGumValue = 4500.0;
		public double VenomFlavor = 465.0;
		public double EmeraldWrathFace = 4850.0;
		public double MagmaGumValue = 5.0E9;
		public double RedTangoFaceValue = 5.1E8;
		public double SurgeFlavorValue = 5.5E7;
		public double BeastModeFaceValue = 5.5E9;
		public double PopcornFlavorValue = 5.6E8;
		public double CrimsonEvilEyeFaceValue = 5.8E8;
		public double SwirlFlavor = 50.0;
		public double PizzaFlavorValue = 500.0;
		public double GodlyGum = 50000.0;
		public double HeroicGumValue = 50000.0;
		public double Experiment32Gum = 500000.0;
		public double SugarGum = 5000000.0;
		public double OrangeFlavor = 5200.0;
		public double GalaxyFlavorValue = 5200000.0;
		public double AzureWrathFace = 5250.0;
		public double ChocolateFlavorValue = 5400.0;
		public double GalaxyFlavor = 545.0;
		public double SuperGum = 550.0;
		public double UltraGum = 5500.0;
		public double GreenBubbleFace = 565.0;
		public double CherryFlavor = 6.0;
		public double MagmaGum = 6.5E7;
		public double DaringBeardFaceValue = 6.8E7;
		public double FrostFlavor = 60.0;
		public double IcecreamFlavor = 6000.0;
		public double PlasmaFlavorValue = 620000.0;
		public double FrostFlavorValue = 62500.0;
		public double FinnMcCoolFaceValue = 6350000.0;
		public double RadioactiveGumValue = 6390000.0;
		public double BlueBubbleFace = 645.0;
		public double CrimsonWrathFace = 6666.0;
		public double MoltonFlavor = 6750.0;
		public double IntenseFlavorValue = 7.0E11;
		public double RedGoofFaceValue = 7.0E7;
		public double FishGumValue = 7.5E8;
		public double DaringBeardFace = 720.0;
		public double RainbowFlavor = 720.0;
		public double RedGoofFace = 745.0;
		public double QuantumGumValue = 749.0;
		public double FlamesFlavor = 7500.0;
		public double UniversalGum = 75000.0;
		public double VampireFace = 7800.0;
		public double SourGumValue = 8.5E8;
		public double OrangeFlavorValue = 8.5E9;
		public double EmeraldWrathFaceValue = 8.9E9;
		public double RubyFlavor = 80.0;
		public double SurgeFlavor = 800.0;
		public double SuperDuperGumValue = 8350.0;
		public double InfernoFlavor = 8600.0;
		public double PineappleFlavorValue = 9.5E8;
		public double Experiment54GumValue = 9.6E7;
		public double FlamesFlavorValue = 9.9E10;
		public double ChewyGumValue = 900.0;
		public double XDFace = 900.0;
		public double StitchesFace = 9000.0;
		public double TriangularFlavor = 920.0;
		public double LegendaryGumValue = 92000.0;
		public double SpicyFlavor = 98000.0;
		public String Common = "Common";
		public String Epic = "Epic";
		public String Legendary = "Legendary";
		public String Mythic = "Mythic";
		public String Rare = "Rare";
		public String Secret = "Secret";
		public String Shiny = "Shiny";
		public String Unique = "Unique";
		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			NormalFace = nbt.getDouble("NormalFace");
			NormalFaceValue = nbt.getDouble("NormalFaceValue");
			BubbleGumFlavorValue = nbt.getDouble("BubbleGumFlavorValue");
			NormalGumValue = nbt.getDouble("NormalGumValue");
			BubbleGumFlavor = nbt.getDouble("BubbleGumFlavor");
			RedGlowingEyesFaceValue = nbt.getDouble("RedGlowingEyesFaceValue");
			RainbowFlavorValue = nbt.getDouble("RainbowFlavorValue");
			FireGumValue = nbt.getDouble("FireGumValue");
			QuantumGum = nbt.getDouble("QuantumGum");
			SweetGum = nbt.getDouble("SweetGum");
			FireGum = nbt.getDouble("FireGum");
			OceanGumValue = nbt.getDouble("OceanGumValue");
			AzureWrathFaceValue = nbt.getDouble("AzureWrathFaceValue");
			FriendlyPirateFaceValue = nbt.getDouble("FriendlyPirateFaceValue");
			SprinklesFlavorValue = nbt.getDouble("SprinklesFlavorValue");
			SandyGum = nbt.getDouble("SandyGum");
			XDFaceValue = nbt.getDouble("XDFaceValue");
			TriangularFlavorValue = nbt.getDouble("TriangularFlavorValue");
			SugarGumValue = nbt.getDouble("SugarGumValue");
			ScarFaceValue = nbt.getDouble("ScarFaceValue");
			RedRawrFaceValue = nbt.getDouble("RedRawrFaceValue");
			InfernoFlavorValue = nbt.getDouble("InfernoFlavorValue");
			CrimsonWrathFaceValue = nbt.getDouble("CrimsonWrathFaceValue");
			IcecreamFlavorValue = nbt.getDouble("IcecreamFlavorValue");
			DonutFlavor = nbt.getDouble("DonutFlavor");
			BubbleTroubleFace = nbt.getDouble("BubbleTroubleFace");
			ExtraStretchyGum = nbt.getDouble("ExtraStretchyGum");
			ScarFace = nbt.getDouble("ScarFace");
			SuperDuperGum = nbt.getDouble("SuperDuperGum");
			HeroicGum = nbt.getDouble("HeroicGum");
			Experiment54Gum = nbt.getDouble("Experiment54Gum");
			WatermelonFlavorValue = nbt.getDouble("WatermelonFlavorValue");
			VoidFlavor = nbt.getDouble("VoidFlavor");
			RubyFlavorValue = nbt.getDouble("RubyFlavorValue");
			IntenseFlavor = nbt.getDouble("IntenseFlavor");
			ExtraChewyGumValue = nbt.getDouble("ExtraChewyGumValue");
			OmegaGumValue = nbt.getDouble("OmegaGumValue");
			AlienGum = nbt.getDouble("AlienGum");
			LavaFlavorValue = nbt.getDouble("LavaFlavorValue");
			MythicalGumValue = nbt.getDouble("MythicalGumValue");
			AquaFlavor = nbt.getDouble("AquaFlavor");
			YumFace = nbt.getDouble("YumFace");
			ChocolateFlavor = nbt.getDouble("ChocolateFlavor");
			PopcornFlavor = nbt.getDouble("PopcornFlavor");
			VIPFlavor = nbt.getDouble("VIPFlavor");
			CherryFlavorValue = nbt.getDouble("CherryFlavorValue");
			UnrealGumValue = nbt.getDouble("UnrealGumValue");
			ChewyGum = nbt.getDouble("ChewyGum");
			BlueberryFlavorValue = nbt.getDouble("BlueberryFlavorValue");
			StretchyGumValue = nbt.getDouble("StretchyGumValue");
			OmegaGum = nbt.getDouble("OmegaGum");
			ContrastFlavorValue = nbt.getDouble("ContrastFlavorValue");
			LegendaryGum = nbt.getDouble("LegendaryGum");
			PlasmaFlavor = nbt.getDouble("PlasmaFlavor");
			CrimsonEvilEyeFace = nbt.getDouble("CrimsonEvilEyeFace");
			BlueberryFlavor = nbt.getDouble("BlueberryFlavor");
			DoggyCoins = nbt.getDouble("DoggyCoins");
			DoubleChewGamePass = nbt.getDouble("DoubleChewGamePass");
			FishGum = nbt.getDouble("FishGum");
			GreenBubbleFaceValue = nbt.getDouble("GreenBubbleFaceValue");
			SourGum = nbt.getDouble("SourGum");
			EvilSkepticFaceValue = nbt.getDouble("EvilSkepticFaceValue");
			PuzzleFlavorValue = nbt.getDouble("PuzzleFlavorValue");
			VampireFaceValue = nbt.getDouble("VampireFaceValue");
			WatermelonFlavor = nbt.getDouble("WatermelonFlavor");
			FinnMcCoolFace = nbt.getDouble("FinnMcCoolFace");
			EpicGumValue = nbt.getDouble("EpicGumValue");
			UnrealGum = nbt.getDouble("UnrealGum");
			GoldFlavorValue = nbt.getDouble("GoldFlavorValue");
			RedTangoFace = nbt.getDouble("RedTangoFace");
			VoidFlavorValue = nbt.getDouble("VoidFlavorValue");
			NormalGum = nbt.getDouble("NormalGum");
			CommonEggValue = nbt.getDouble("CommonEggValue");
			ExtraChewyGum = nbt.getDouble("ExtraChewyGum");
			LavaFlavor = nbt.getDouble("LavaFlavor");
			MythicalGum = nbt.getDouble("MythicalGum");
			RadioactiveGum = nbt.getDouble("RadioactiveGum");
			MonsterGumValue = nbt.getDouble("MonsterGumValue");
			GodlyGumValue = nbt.getDouble("GodlyGumValue");
			AlienGumValue = nbt.getDouble("AlienGumValue");
			PuzzleFlavor = nbt.getDouble("PuzzleFlavor");
			TrippleHatchGamePass = nbt.getDouble("TrippleHatchGamePass");
			SandyGumValue = nbt.getDouble("SandyGumValue");
			SpicyFlavorValue = nbt.getDouble("SpicyFlavorValue");
			YumFaceValue = nbt.getDouble("YumFaceValue");
			Experiment32GumValue = nbt.getDouble("Experiment32GumValue");
			ContrastFlavor = nbt.getDouble("ContrastFlavor");
			EpicGum = nbt.getDouble("EpicGum");
			FriendlyPirateFace = nbt.getDouble("FriendlyPirateFace");
			RedGlowingEyesFace = nbt.getDouble("RedGlowingEyesFace");
			LemonFlavorValue = nbt.getDouble("LemonFlavorValue");
			VenomFlavorValue = nbt.getDouble("VenomFlavorValue");
			DonutFlavorValue = nbt.getDouble("DonutFlavorValue");
			RedRawrFace = nbt.getDouble("RedRawrFace");
			VIPFlavorValue = nbt.getDouble("VIPFlavorValue");
			GoldFlavor = nbt.getDouble("GoldFlavor");
			MonsterGum = nbt.getDouble("MonsterGum");
			UltraGumValue = nbt.getDouble("UltraGumValue");
			SprinklesFlavor = nbt.getDouble("SprinklesFlavor");
			EvilSkepticFace = nbt.getDouble("EvilSkepticFace");
			PizzaFlavor = nbt.getDouble("PizzaFlavor");
			StitchesFaceValue = nbt.getDouble("StitchesFaceValue");
			BlueBubbleFaceValue = nbt.getDouble("BlueBubbleFaceValue");
			OceanGum = nbt.getDouble("OceanGum");
			MoltonFlavorValue = nbt.getDouble("MoltonFlavorValue");
			SweetGumValue = nbt.getDouble("SweetGumValue");
			ExtraStretchyGumValue = nbt.getDouble("ExtraStretchyGumValue");
			BubbleTroubleFaceValue = nbt.getDouble("BubbleTroubleFaceValue");
			AquaFlavorValue = nbt.getDouble("AquaFlavorValue");
			PineappleFlavor = nbt.getDouble("PineappleFlavor");
			LemonFlavor = nbt.getDouble("LemonFlavor");
			UniversalGumValue = nbt.getDouble("UniversalGumValue");
			BeastModeFace = nbt.getDouble("BeastModeFace");
			SwirlFlavorValue = nbt.getDouble("SwirlFlavorValue");
			StretchyGum = nbt.getDouble("StretchyGum");
			SuperGumValue = nbt.getDouble("SuperGumValue");
			VenomFlavor = nbt.getDouble("VenomFlavor");
			EmeraldWrathFace = nbt.getDouble("EmeraldWrathFace");
			MagmaGumValue = nbt.getDouble("MagmaGumValue");
			RedTangoFaceValue = nbt.getDouble("RedTangoFaceValue");
			SurgeFlavorValue = nbt.getDouble("SurgeFlavorValue");
			BeastModeFaceValue = nbt.getDouble("BeastModeFaceValue");
			PopcornFlavorValue = nbt.getDouble("PopcornFlavorValue");
			CrimsonEvilEyeFaceValue = nbt.getDouble("CrimsonEvilEyeFaceValue");
			SwirlFlavor = nbt.getDouble("SwirlFlavor");
			PizzaFlavorValue = nbt.getDouble("PizzaFlavorValue");
			GodlyGum = nbt.getDouble("GodlyGum");
			HeroicGumValue = nbt.getDouble("HeroicGumValue");
			Experiment32Gum = nbt.getDouble("Experiment32Gum");
			SugarGum = nbt.getDouble("SugarGum");
			OrangeFlavor = nbt.getDouble("OrangeFlavor");
			GalaxyFlavorValue = nbt.getDouble("GalaxyFlavorValue");
			AzureWrathFace = nbt.getDouble("AzureWrathFace");
			ChocolateFlavorValue = nbt.getDouble("ChocolateFlavorValue");
			GalaxyFlavor = nbt.getDouble("GalaxyFlavor");
			SuperGum = nbt.getDouble("SuperGum");
			UltraGum = nbt.getDouble("UltraGum");
			GreenBubbleFace = nbt.getDouble("GreenBubbleFace");
			CherryFlavor = nbt.getDouble("CherryFlavor");
			MagmaGum = nbt.getDouble("MagmaGum");
			DaringBeardFaceValue = nbt.getDouble("DaringBeardFaceValue");
			FrostFlavor = nbt.getDouble("FrostFlavor");
			IcecreamFlavor = nbt.getDouble("IcecreamFlavor");
			PlasmaFlavorValue = nbt.getDouble("PlasmaFlavorValue");
			FrostFlavorValue = nbt.getDouble("FrostFlavorValue");
			FinnMcCoolFaceValue = nbt.getDouble("FinnMcCoolFaceValue");
			RadioactiveGumValue = nbt.getDouble("RadioactiveGumValue");
			BlueBubbleFace = nbt.getDouble("BlueBubbleFace");
			CrimsonWrathFace = nbt.getDouble("CrimsonWrathFace");
			MoltonFlavor = nbt.getDouble("MoltonFlavor");
			IntenseFlavorValue = nbt.getDouble("IntenseFlavorValue");
			RedGoofFaceValue = nbt.getDouble("RedGoofFaceValue");
			FishGumValue = nbt.getDouble("FishGumValue");
			DaringBeardFace = nbt.getDouble("DaringBeardFace");
			RainbowFlavor = nbt.getDouble("RainbowFlavor");
			RedGoofFace = nbt.getDouble("RedGoofFace");
			QuantumGumValue = nbt.getDouble("QuantumGumValue");
			FlamesFlavor = nbt.getDouble("FlamesFlavor");
			UniversalGum = nbt.getDouble("UniversalGum");
			VampireFace = nbt.getDouble("VampireFace");
			SourGumValue = nbt.getDouble("SourGumValue");
			OrangeFlavorValue = nbt.getDouble("OrangeFlavorValue");
			EmeraldWrathFaceValue = nbt.getDouble("EmeraldWrathFaceValue");
			RubyFlavor = nbt.getDouble("RubyFlavor");
			SurgeFlavor = nbt.getDouble("SurgeFlavor");
			SuperDuperGumValue = nbt.getDouble("SuperDuperGumValue");
			InfernoFlavor = nbt.getDouble("InfernoFlavor");
			PineappleFlavorValue = nbt.getDouble("PineappleFlavorValue");
			Experiment54GumValue = nbt.getDouble("Experiment54GumValue");
			FlamesFlavorValue = nbt.getDouble("FlamesFlavorValue");
			ChewyGumValue = nbt.getDouble("ChewyGumValue");
			XDFace = nbt.getDouble("XDFace");
			StitchesFace = nbt.getDouble("StitchesFace");
			TriangularFlavor = nbt.getDouble("TriangularFlavor");
			LegendaryGumValue = nbt.getDouble("LegendaryGumValue");
			SpicyFlavor = nbt.getDouble("SpicyFlavor");
			Common = nbt.getString("Common");
			Epic = nbt.getString("Epic");
			Legendary = nbt.getString("Legendary");
			Mythic = nbt.getString("Mythic");
			Rare = nbt.getString("Rare");
			Secret = nbt.getString("Secret");
			Shiny = nbt.getString("Shiny");
			Unique = nbt.getString("Unique");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putDouble("NormalFace", NormalFace);
			nbt.putDouble("NormalFaceValue", NormalFaceValue);
			nbt.putDouble("BubbleGumFlavorValue", BubbleGumFlavorValue);
			nbt.putDouble("NormalGumValue", NormalGumValue);
			nbt.putDouble("BubbleGumFlavor", BubbleGumFlavor);
			nbt.putDouble("RedGlowingEyesFaceValue", RedGlowingEyesFaceValue);
			nbt.putDouble("RainbowFlavorValue", RainbowFlavorValue);
			nbt.putDouble("FireGumValue", FireGumValue);
			nbt.putDouble("QuantumGum", QuantumGum);
			nbt.putDouble("SweetGum", SweetGum);
			nbt.putDouble("FireGum", FireGum);
			nbt.putDouble("OceanGumValue", OceanGumValue);
			nbt.putDouble("AzureWrathFaceValue", AzureWrathFaceValue);
			nbt.putDouble("FriendlyPirateFaceValue", FriendlyPirateFaceValue);
			nbt.putDouble("SprinklesFlavorValue", SprinklesFlavorValue);
			nbt.putDouble("SandyGum", SandyGum);
			nbt.putDouble("XDFaceValue", XDFaceValue);
			nbt.putDouble("TriangularFlavorValue", TriangularFlavorValue);
			nbt.putDouble("SugarGumValue", SugarGumValue);
			nbt.putDouble("ScarFaceValue", ScarFaceValue);
			nbt.putDouble("RedRawrFaceValue", RedRawrFaceValue);
			nbt.putDouble("InfernoFlavorValue", InfernoFlavorValue);
			nbt.putDouble("CrimsonWrathFaceValue", CrimsonWrathFaceValue);
			nbt.putDouble("IcecreamFlavorValue", IcecreamFlavorValue);
			nbt.putDouble("DonutFlavor", DonutFlavor);
			nbt.putDouble("BubbleTroubleFace", BubbleTroubleFace);
			nbt.putDouble("ExtraStretchyGum", ExtraStretchyGum);
			nbt.putDouble("ScarFace", ScarFace);
			nbt.putDouble("SuperDuperGum", SuperDuperGum);
			nbt.putDouble("HeroicGum", HeroicGum);
			nbt.putDouble("Experiment54Gum", Experiment54Gum);
			nbt.putDouble("WatermelonFlavorValue", WatermelonFlavorValue);
			nbt.putDouble("VoidFlavor", VoidFlavor);
			nbt.putDouble("RubyFlavorValue", RubyFlavorValue);
			nbt.putDouble("IntenseFlavor", IntenseFlavor);
			nbt.putDouble("ExtraChewyGumValue", ExtraChewyGumValue);
			nbt.putDouble("OmegaGumValue", OmegaGumValue);
			nbt.putDouble("AlienGum", AlienGum);
			nbt.putDouble("LavaFlavorValue", LavaFlavorValue);
			nbt.putDouble("MythicalGumValue", MythicalGumValue);
			nbt.putDouble("AquaFlavor", AquaFlavor);
			nbt.putDouble("YumFace", YumFace);
			nbt.putDouble("ChocolateFlavor", ChocolateFlavor);
			nbt.putDouble("PopcornFlavor", PopcornFlavor);
			nbt.putDouble("VIPFlavor", VIPFlavor);
			nbt.putDouble("CherryFlavorValue", CherryFlavorValue);
			nbt.putDouble("UnrealGumValue", UnrealGumValue);
			nbt.putDouble("ChewyGum", ChewyGum);
			nbt.putDouble("BlueberryFlavorValue", BlueberryFlavorValue);
			nbt.putDouble("StretchyGumValue", StretchyGumValue);
			nbt.putDouble("OmegaGum", OmegaGum);
			nbt.putDouble("ContrastFlavorValue", ContrastFlavorValue);
			nbt.putDouble("LegendaryGum", LegendaryGum);
			nbt.putDouble("PlasmaFlavor", PlasmaFlavor);
			nbt.putDouble("CrimsonEvilEyeFace", CrimsonEvilEyeFace);
			nbt.putDouble("BlueberryFlavor", BlueberryFlavor);
			nbt.putDouble("DoggyCoins", DoggyCoins);
			nbt.putDouble("DoubleChewGamePass", DoubleChewGamePass);
			nbt.putDouble("FishGum", FishGum);
			nbt.putDouble("GreenBubbleFaceValue", GreenBubbleFaceValue);
			nbt.putDouble("SourGum", SourGum);
			nbt.putDouble("EvilSkepticFaceValue", EvilSkepticFaceValue);
			nbt.putDouble("PuzzleFlavorValue", PuzzleFlavorValue);
			nbt.putDouble("VampireFaceValue", VampireFaceValue);
			nbt.putDouble("WatermelonFlavor", WatermelonFlavor);
			nbt.putDouble("FinnMcCoolFace", FinnMcCoolFace);
			nbt.putDouble("EpicGumValue", EpicGumValue);
			nbt.putDouble("UnrealGum", UnrealGum);
			nbt.putDouble("GoldFlavorValue", GoldFlavorValue);
			nbt.putDouble("RedTangoFace", RedTangoFace);
			nbt.putDouble("VoidFlavorValue", VoidFlavorValue);
			nbt.putDouble("NormalGum", NormalGum);
			nbt.putDouble("CommonEggValue", CommonEggValue);
			nbt.putDouble("ExtraChewyGum", ExtraChewyGum);
			nbt.putDouble("LavaFlavor", LavaFlavor);
			nbt.putDouble("MythicalGum", MythicalGum);
			nbt.putDouble("RadioactiveGum", RadioactiveGum);
			nbt.putDouble("MonsterGumValue", MonsterGumValue);
			nbt.putDouble("GodlyGumValue", GodlyGumValue);
			nbt.putDouble("AlienGumValue", AlienGumValue);
			nbt.putDouble("PuzzleFlavor", PuzzleFlavor);
			nbt.putDouble("TrippleHatchGamePass", TrippleHatchGamePass);
			nbt.putDouble("SandyGumValue", SandyGumValue);
			nbt.putDouble("SpicyFlavorValue", SpicyFlavorValue);
			nbt.putDouble("YumFaceValue", YumFaceValue);
			nbt.putDouble("Experiment32GumValue", Experiment32GumValue);
			nbt.putDouble("ContrastFlavor", ContrastFlavor);
			nbt.putDouble("EpicGum", EpicGum);
			nbt.putDouble("FriendlyPirateFace", FriendlyPirateFace);
			nbt.putDouble("RedGlowingEyesFace", RedGlowingEyesFace);
			nbt.putDouble("LemonFlavorValue", LemonFlavorValue);
			nbt.putDouble("VenomFlavorValue", VenomFlavorValue);
			nbt.putDouble("DonutFlavorValue", DonutFlavorValue);
			nbt.putDouble("RedRawrFace", RedRawrFace);
			nbt.putDouble("VIPFlavorValue", VIPFlavorValue);
			nbt.putDouble("GoldFlavor", GoldFlavor);
			nbt.putDouble("MonsterGum", MonsterGum);
			nbt.putDouble("UltraGumValue", UltraGumValue);
			nbt.putDouble("SprinklesFlavor", SprinklesFlavor);
			nbt.putDouble("EvilSkepticFace", EvilSkepticFace);
			nbt.putDouble("PizzaFlavor", PizzaFlavor);
			nbt.putDouble("StitchesFaceValue", StitchesFaceValue);
			nbt.putDouble("BlueBubbleFaceValue", BlueBubbleFaceValue);
			nbt.putDouble("OceanGum", OceanGum);
			nbt.putDouble("MoltonFlavorValue", MoltonFlavorValue);
			nbt.putDouble("SweetGumValue", SweetGumValue);
			nbt.putDouble("ExtraStretchyGumValue", ExtraStretchyGumValue);
			nbt.putDouble("BubbleTroubleFaceValue", BubbleTroubleFaceValue);
			nbt.putDouble("AquaFlavorValue", AquaFlavorValue);
			nbt.putDouble("PineappleFlavor", PineappleFlavor);
			nbt.putDouble("LemonFlavor", LemonFlavor);
			nbt.putDouble("UniversalGumValue", UniversalGumValue);
			nbt.putDouble("BeastModeFace", BeastModeFace);
			nbt.putDouble("SwirlFlavorValue", SwirlFlavorValue);
			nbt.putDouble("StretchyGum", StretchyGum);
			nbt.putDouble("SuperGumValue", SuperGumValue);
			nbt.putDouble("VenomFlavor", VenomFlavor);
			nbt.putDouble("EmeraldWrathFace", EmeraldWrathFace);
			nbt.putDouble("MagmaGumValue", MagmaGumValue);
			nbt.putDouble("RedTangoFaceValue", RedTangoFaceValue);
			nbt.putDouble("SurgeFlavorValue", SurgeFlavorValue);
			nbt.putDouble("BeastModeFaceValue", BeastModeFaceValue);
			nbt.putDouble("PopcornFlavorValue", PopcornFlavorValue);
			nbt.putDouble("CrimsonEvilEyeFaceValue", CrimsonEvilEyeFaceValue);
			nbt.putDouble("SwirlFlavor", SwirlFlavor);
			nbt.putDouble("PizzaFlavorValue", PizzaFlavorValue);
			nbt.putDouble("GodlyGum", GodlyGum);
			nbt.putDouble("HeroicGumValue", HeroicGumValue);
			nbt.putDouble("Experiment32Gum", Experiment32Gum);
			nbt.putDouble("SugarGum", SugarGum);
			nbt.putDouble("OrangeFlavor", OrangeFlavor);
			nbt.putDouble("GalaxyFlavorValue", GalaxyFlavorValue);
			nbt.putDouble("AzureWrathFace", AzureWrathFace);
			nbt.putDouble("ChocolateFlavorValue", ChocolateFlavorValue);
			nbt.putDouble("GalaxyFlavor", GalaxyFlavor);
			nbt.putDouble("SuperGum", SuperGum);
			nbt.putDouble("UltraGum", UltraGum);
			nbt.putDouble("GreenBubbleFace", GreenBubbleFace);
			nbt.putDouble("CherryFlavor", CherryFlavor);
			nbt.putDouble("MagmaGum", MagmaGum);
			nbt.putDouble("DaringBeardFaceValue", DaringBeardFaceValue);
			nbt.putDouble("FrostFlavor", FrostFlavor);
			nbt.putDouble("IcecreamFlavor", IcecreamFlavor);
			nbt.putDouble("PlasmaFlavorValue", PlasmaFlavorValue);
			nbt.putDouble("FrostFlavorValue", FrostFlavorValue);
			nbt.putDouble("FinnMcCoolFaceValue", FinnMcCoolFaceValue);
			nbt.putDouble("RadioactiveGumValue", RadioactiveGumValue);
			nbt.putDouble("BlueBubbleFace", BlueBubbleFace);
			nbt.putDouble("CrimsonWrathFace", CrimsonWrathFace);
			nbt.putDouble("MoltonFlavor", MoltonFlavor);
			nbt.putDouble("IntenseFlavorValue", IntenseFlavorValue);
			nbt.putDouble("RedGoofFaceValue", RedGoofFaceValue);
			nbt.putDouble("FishGumValue", FishGumValue);
			nbt.putDouble("DaringBeardFace", DaringBeardFace);
			nbt.putDouble("RainbowFlavor", RainbowFlavor);
			nbt.putDouble("RedGoofFace", RedGoofFace);
			nbt.putDouble("QuantumGumValue", QuantumGumValue);
			nbt.putDouble("FlamesFlavor", FlamesFlavor);
			nbt.putDouble("UniversalGum", UniversalGum);
			nbt.putDouble("VampireFace", VampireFace);
			nbt.putDouble("SourGumValue", SourGumValue);
			nbt.putDouble("OrangeFlavorValue", OrangeFlavorValue);
			nbt.putDouble("EmeraldWrathFaceValue", EmeraldWrathFaceValue);
			nbt.putDouble("RubyFlavor", RubyFlavor);
			nbt.putDouble("SurgeFlavor", SurgeFlavor);
			nbt.putDouble("SuperDuperGumValue", SuperDuperGumValue);
			nbt.putDouble("InfernoFlavor", InfernoFlavor);
			nbt.putDouble("PineappleFlavorValue", PineappleFlavorValue);
			nbt.putDouble("Experiment54GumValue", Experiment54GumValue);
			nbt.putDouble("FlamesFlavorValue", FlamesFlavorValue);
			nbt.putDouble("ChewyGumValue", ChewyGumValue);
			nbt.putDouble("XDFace", XDFace);
			nbt.putDouble("StitchesFace", StitchesFace);
			nbt.putDouble("TriangularFlavor", TriangularFlavor);
			nbt.putDouble("LegendaryGumValue", LegendaryGumValue);
			nbt.putDouble("SpicyFlavor", SpicyFlavor);
			nbt.putString("Common", Common);
			nbt.putString("Epic", Epic);
			nbt.putString("Legendary", Legendary);
			nbt.putString("Mythic", Mythic);
			nbt.putString("Rare", Rare);
			nbt.putString("Secret", Secret);
			nbt.putString("Shiny", Shiny);
			nbt.putString("Unique", Unique);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}
		static WorldVariables clientSide = new WorldVariables();
		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "bubble_gum_simulator_mapvars";
		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}
		static MapVariables clientSide = new MapVariables();
		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;
		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("bubble_gum_simulator", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("BlockCurrency", instance.BlockCurrency);
			nbt.putDouble("CandyCurrency", instance.CandyCurrency);
			nbt.putDouble("DoggyCollections", instance.DoggyCollections);
			nbt.putDouble("LuckChance", instance.LuckChance);
			nbt.putDouble("MobuxCurrency", instance.MobuxCurrency);
			nbt.putDouble("MultiCurrency", instance.MultiCurrency);
			nbt.putDouble("MysticCurrency", instance.MysticCurrency);
			nbt.putDouble("MythicChance", instance.MythicChance);
			nbt.putDouble("PearlCurrency", instance.PearlCurrency);
			nbt.putDouble("RainbowCurrency", instance.RainbowCurrency);
			nbt.putDouble("ShardCurrency", instance.ShardCurrency);
			nbt.putDouble("ShellCurrency", instance.ShellCurrency);
			nbt.putDouble("ShinyChance", instance.ShinyChance);
			nbt.putDouble("TeamsBubbleStats", instance.TeamsBubbleStats);
			nbt.putDouble("TotalBubbles", instance.TotalBubbles);
			nbt.putDouble("TotalEggs", instance.TotalEggs);
			nbt.putDouble("TotalLegendsHatched", instance.TotalLegendsHatched);
			nbt.putDouble("TotalSecretsHatched", instance.TotalSecretsHatched);
			nbt.putDouble("BubblesPerClick", instance.BubblesPerClick);
			nbt.putDouble("CoinCurrency", instance.CoinCurrency);
			nbt.putDouble("CurrentBubbles", instance.CurrentBubbles);
			nbt.putDouble("CurrentFace", instance.CurrentFace);
			nbt.putDouble("CurrentFlavor", instance.CurrentFlavor);
			nbt.putDouble("CurrentGum", instance.CurrentGum);
			nbt.putDouble("GemCurrency", instance.GemCurrency);
			nbt.putDouble("MagmaCurrency", instance.MagmaCurrency);
			nbt.putDouble("PlayerSpeed", instance.PlayerSpeed);
			nbt.putDouble("DoggyBubbles", instance.DoggyBubbles);
			nbt.putDouble("DoggyGems", instance.DoggyGems);
			nbt.putDouble("PlayerGravity", instance.PlayerGravity);
			nbt.putDouble("PlayerLuck", instance.PlayerLuck);
			nbt.putBoolean("AlienGumOwned", instance.AlienGumOwned);
			nbt.putBoolean("AquaFlavorOwned", instance.AquaFlavorOwned);
			nbt.putBoolean("AzureWrathFaceOwned", instance.AzureWrathFaceOwned);
			nbt.putBoolean("BeastModeFaceOwned", instance.BeastModeFaceOwned);
			nbt.putBoolean("BlueberryFlavorOwned", instance.BlueberryFlavorOwned);
			nbt.putBoolean("BlueBubbleFaceOwned", instance.BlueBubbleFaceOwned);
			nbt.putBoolean("BubbleGumFlavorOwned", instance.BubbleGumFlavorOwned);
			nbt.putBoolean("BubbleTroubleFaceOwned", instance.BubbleTroubleFaceOwned);
			nbt.putBoolean("CherryFlavorOwned", instance.CherryFlavorOwned);
			nbt.putBoolean("ChewFasterGamePass", instance.ChewFasterGamePass);
			nbt.putBoolean("ChewyGumOwned", instance.ChewyGumOwned);
			nbt.putBoolean("ChocolateFlavorOwned", instance.ChocolateFlavorOwned);
			nbt.putBoolean("CodeUsed", instance.CodeUsed);
			nbt.putBoolean("CodeVerified", instance.CodeVerified);
			nbt.putBoolean("ContrastFlavorOwned", instance.ContrastFlavorOwned);
			nbt.putBoolean("CrimsonEvilEyeFaceOwned", instance.CrimsonEvilEyeFaceOwned);
			nbt.putBoolean("CrimsonWrathFaceOwned", instance.CrimsonWrathFaceOwned);
			nbt.putBoolean("DaringBeardFaceOwned", instance.DaringBeardFaceOwned);
			nbt.putBoolean("DonutFlavorOwned", instance.DonutFlavorOwned);
			nbt.putBoolean("DoubleBubbleGamePass", instance.DoubleBubbleGamePass);
			nbt.putBoolean("DoubleCoinsGamePass", instance.DoubleCoinsGamePass);
			nbt.putBoolean("DoubleGemsGamePass", instance.DoubleGemsGamePass);
			nbt.putBoolean("EmeraldWrathFaceOwned", instance.EmeraldWrathFaceOwned);
			nbt.putBoolean("EpicGumOwned", instance.EpicGumOwned);
			nbt.putBoolean("EvilSkepticFaceOwned", instance.EvilSkepticFaceOwned);
			nbt.putBoolean("Experiment32GumOwned", instance.Experiment32GumOwned);
			nbt.putBoolean("Experiment54GumOwned", instance.Experiment54GumOwned);
			nbt.putBoolean("ExtraChewyGumOwned", instance.ExtraChewyGumOwned);
			nbt.putBoolean("ExtraStretchyGumOwned", instance.ExtraStretchyGumOwned);
			nbt.putBoolean("FastHatchGamePass", instance.FastHatchGamePass);
			nbt.putBoolean("FinnMcCoolFaceOwned", instance.FinnMcCoolFaceOwned);
			nbt.putBoolean("FireGumOwned", instance.FireGumOwned);
			nbt.putBoolean("FishGumOwned", instance.FishGumOwned);
			nbt.putBoolean("FlamesFlavorOwned", instance.FlamesFlavorOwned);
			nbt.putBoolean("FriendlyPirateFaceOwned", instance.FriendlyPirateFaceOwned);
			nbt.putBoolean("FrostFlavorOwned", instance.FrostFlavorOwned);
			nbt.putBoolean("GalaxyFlavorOwned", instance.GalaxyFlavorOwned);
			nbt.putBoolean("GodlyGumOwned", instance.GodlyGumOwned);
			nbt.putBoolean("GoldFlavorOwned", instance.GoldFlavorOwned);
			nbt.putBoolean("GreenBubbleFaceOwned", instance.GreenBubbleFaceOwned);
			nbt.putBoolean("HeroicGumOwned", instance.HeroicGumOwned);
			nbt.putBoolean("IcecreamFlavorOwned", instance.IcecreamFlavorOwned);
			nbt.putBoolean("InfernoFlavorOwned", instance.InfernoFlavorOwned);
			nbt.putBoolean("InfiniteBubbleGamePass", instance.InfiniteBubbleGamePass);
			nbt.putBoolean("IntenseFlavorOwned", instance.IntenseFlavorOwned);
			nbt.putBoolean("LavaFlavorOwned", instance.LavaFlavorOwned);
			nbt.putBoolean("LegendaryGumOwned", instance.LegendaryGumOwned);
			nbt.putBoolean("LemonFlavorOwned", instance.LemonFlavorOwned);
			nbt.putBoolean("LuckyChancesGamePass", instance.LuckyChancesGamePass);
			nbt.putBoolean("MagmaGumOwned", instance.MagmaGumOwned);
			nbt.putBoolean("MoltonFlavorOwned", instance.MoltonFlavorOwned);
			nbt.putBoolean("MonsterGumOwned", instance.MonsterGumOwned);
			nbt.putBoolean("MultiEggGamePass", instance.MultiEggGamePass);
			nbt.putBoolean("MythicalGumOwned", instance.MythicalGumOwned);
			nbt.putBoolean("NormalFaceOwned", instance.NormalFaceOwned);
			nbt.putBoolean("NormalGumOwned", instance.NormalGumOwned);
			nbt.putBoolean("OceanGumOwned", instance.OceanGumOwned);
			nbt.putBoolean("OmegaGumOwned", instance.OmegaGumOwned);
			nbt.putBoolean("OrangeFlavorOwned", instance.OrangeFlavorOwned);
			nbt.putBoolean("PineappleFlavorOwned", instance.PineappleFlavorOwned);
			nbt.putBoolean("PizzaFlavorOwned", instance.PizzaFlavorOwned);
			nbt.putBoolean("PlasmaFlavorOwned", instance.PlasmaFlavorOwned);
			nbt.putBoolean("PopcornFlavorOwned", instance.PopcornFlavorOwned);
			nbt.putBoolean("PuzzleFlavorOwned", instance.PuzzleFlavorOwned);
			nbt.putBoolean("QuantumGumOwned", instance.QuantumGumOwned);
			nbt.putBoolean("RadioactiveGumOwned", instance.RadioactiveGumOwned);
			nbt.putBoolean("RainbowFlavorOwned", instance.RainbowFlavorOwned);
			nbt.putBoolean("RedGlowingEyesFaceOwned", instance.RedGlowingEyesFaceOwned);
			nbt.putBoolean("RedGoofFaceOwned", instance.RedGoofFaceOwned);
			nbt.putBoolean("RedRawrFaceOwned", instance.RedRawrFaceOwned);
			nbt.putBoolean("RedTangoFaceOwned", instance.RedTangoFaceOwned);
			nbt.putBoolean("RubyFlavorOwned", instance.RubyFlavorOwned);
			nbt.putBoolean("SandyGumOwned", instance.SandyGumOwned);
			nbt.putBoolean("ScarFaceOwned", instance.ScarFaceOwned);
			nbt.putBoolean("SourGumOwned", instance.SourGumOwned);
			nbt.putBoolean("SpaceBootsGamePass", instance.SpaceBootsGamePass);
			nbt.putBoolean("SpicyFlavorOwned", instance.SpicyFlavorOwned);
			nbt.putBoolean("SprinklesFlavorOwned", instance.SprinklesFlavorOwned);
			nbt.putBoolean("SprintGamePass", instance.SprintGamePass);
			nbt.putBoolean("StitchesFaceOwned", instance.StitchesFaceOwned);
			nbt.putBoolean("StretchyGumOwned", instance.StretchyGumOwned);
			nbt.putBoolean("SugarGumOwned", instance.SugarGumOwned);
			nbt.putBoolean("SuperDuperGumOwned", instance.SuperDuperGumOwned);
			nbt.putBoolean("SuperGumOwned", instance.SuperGumOwned);
			nbt.putBoolean("SurgeFlavorOwned", instance.SurgeFlavorOwned);
			nbt.putBoolean("SweetGumOwned", instance.SweetGumOwned);
			nbt.putBoolean("SwirlFlavorOwned", instance.SwirlFlavorOwned);
			nbt.putBoolean("TriangularFlavorOwned", instance.TriangularFlavorOwned);
			nbt.putBoolean("UltraGumOwned", instance.UltraGumOwned);
			nbt.putBoolean("UniversalGumOwned", instance.UniversalGumOwned);
			nbt.putBoolean("UnrealGumOwned", instance.UnrealGumOwned);
			nbt.putBoolean("UsedCodeBlueCrew", instance.UsedCodeBlueCrew);
			nbt.putBoolean("UsedCodeFreeCoins", instance.UsedCodeFreeCoins);
			nbt.putBoolean("UsedCodeLotsOfGems", instance.UsedCodeLotsOfGems);
			nbt.putBoolean("UsedCodeMinime", instance.UsedCodeMinime);
			nbt.putBoolean("UsedCodeObscureEntity", instance.UsedCodeObscureEntity);
			nbt.putBoolean("UsedCodepinkarmypet", instance.UsedCodepinkarmypet);
			nbt.putBoolean("UsedCodeSuperCoins", instance.UsedCodeSuperCoins);
			nbt.putBoolean("UsedCodeSuperGems", instance.UsedCodeSuperGems);
			nbt.putBoolean("UsedCodeTofuu", instance.UsedCodeTofuu);
			nbt.putBoolean("UsedCodeTwisted", instance.UsedCodeTwisted);
			nbt.putBoolean("VampireFaceOwned", instance.VampireFaceOwned);
			nbt.putBoolean("VenomFlavorOwned", instance.VenomFlavorOwned);
			nbt.putBoolean("VIPFlavorOwned", instance.VIPFlavorOwned);
			nbt.putBoolean("VIPGamePass", instance.VIPGamePass);
			nbt.putBoolean("VoidFlavorOwned", instance.VoidFlavorOwned);
			nbt.putBoolean("WatermelonFlavorOwned", instance.WatermelonFlavorOwned);
			nbt.putBoolean("XDFaceOwned", instance.XDFaceOwned);
			nbt.putBoolean("YumFaceOwned", instance.YumFaceOwned);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.BlockCurrency = nbt.getDouble("BlockCurrency");
			instance.CandyCurrency = nbt.getDouble("CandyCurrency");
			instance.DoggyCollections = nbt.getDouble("DoggyCollections");
			instance.LuckChance = nbt.getDouble("LuckChance");
			instance.MobuxCurrency = nbt.getDouble("MobuxCurrency");
			instance.MultiCurrency = nbt.getDouble("MultiCurrency");
			instance.MysticCurrency = nbt.getDouble("MysticCurrency");
			instance.MythicChance = nbt.getDouble("MythicChance");
			instance.PearlCurrency = nbt.getDouble("PearlCurrency");
			instance.RainbowCurrency = nbt.getDouble("RainbowCurrency");
			instance.ShardCurrency = nbt.getDouble("ShardCurrency");
			instance.ShellCurrency = nbt.getDouble("ShellCurrency");
			instance.ShinyChance = nbt.getDouble("ShinyChance");
			instance.TeamsBubbleStats = nbt.getDouble("TeamsBubbleStats");
			instance.TotalBubbles = nbt.getDouble("TotalBubbles");
			instance.TotalEggs = nbt.getDouble("TotalEggs");
			instance.TotalLegendsHatched = nbt.getDouble("TotalLegendsHatched");
			instance.TotalSecretsHatched = nbt.getDouble("TotalSecretsHatched");
			instance.BubblesPerClick = nbt.getDouble("BubblesPerClick");
			instance.CoinCurrency = nbt.getDouble("CoinCurrency");
			instance.CurrentBubbles = nbt.getDouble("CurrentBubbles");
			instance.CurrentFace = nbt.getDouble("CurrentFace");
			instance.CurrentFlavor = nbt.getDouble("CurrentFlavor");
			instance.CurrentGum = nbt.getDouble("CurrentGum");
			instance.GemCurrency = nbt.getDouble("GemCurrency");
			instance.MagmaCurrency = nbt.getDouble("MagmaCurrency");
			instance.PlayerSpeed = nbt.getDouble("PlayerSpeed");
			instance.DoggyBubbles = nbt.getDouble("DoggyBubbles");
			instance.DoggyGems = nbt.getDouble("DoggyGems");
			instance.PlayerGravity = nbt.getDouble("PlayerGravity");
			instance.PlayerLuck = nbt.getDouble("PlayerLuck");
			instance.AlienGumOwned = nbt.getBoolean("AlienGumOwned");
			instance.AquaFlavorOwned = nbt.getBoolean("AquaFlavorOwned");
			instance.AzureWrathFaceOwned = nbt.getBoolean("AzureWrathFaceOwned");
			instance.BeastModeFaceOwned = nbt.getBoolean("BeastModeFaceOwned");
			instance.BlueberryFlavorOwned = nbt.getBoolean("BlueberryFlavorOwned");
			instance.BlueBubbleFaceOwned = nbt.getBoolean("BlueBubbleFaceOwned");
			instance.BubbleGumFlavorOwned = nbt.getBoolean("BubbleGumFlavorOwned");
			instance.BubbleTroubleFaceOwned = nbt.getBoolean("BubbleTroubleFaceOwned");
			instance.CherryFlavorOwned = nbt.getBoolean("CherryFlavorOwned");
			instance.ChewFasterGamePass = nbt.getBoolean("ChewFasterGamePass");
			instance.ChewyGumOwned = nbt.getBoolean("ChewyGumOwned");
			instance.ChocolateFlavorOwned = nbt.getBoolean("ChocolateFlavorOwned");
			instance.CodeUsed = nbt.getBoolean("CodeUsed");
			instance.CodeVerified = nbt.getBoolean("CodeVerified");
			instance.ContrastFlavorOwned = nbt.getBoolean("ContrastFlavorOwned");
			instance.CrimsonEvilEyeFaceOwned = nbt.getBoolean("CrimsonEvilEyeFaceOwned");
			instance.CrimsonWrathFaceOwned = nbt.getBoolean("CrimsonWrathFaceOwned");
			instance.DaringBeardFaceOwned = nbt.getBoolean("DaringBeardFaceOwned");
			instance.DonutFlavorOwned = nbt.getBoolean("DonutFlavorOwned");
			instance.DoubleBubbleGamePass = nbt.getBoolean("DoubleBubbleGamePass");
			instance.DoubleCoinsGamePass = nbt.getBoolean("DoubleCoinsGamePass");
			instance.DoubleGemsGamePass = nbt.getBoolean("DoubleGemsGamePass");
			instance.EmeraldWrathFaceOwned = nbt.getBoolean("EmeraldWrathFaceOwned");
			instance.EpicGumOwned = nbt.getBoolean("EpicGumOwned");
			instance.EvilSkepticFaceOwned = nbt.getBoolean("EvilSkepticFaceOwned");
			instance.Experiment32GumOwned = nbt.getBoolean("Experiment32GumOwned");
			instance.Experiment54GumOwned = nbt.getBoolean("Experiment54GumOwned");
			instance.ExtraChewyGumOwned = nbt.getBoolean("ExtraChewyGumOwned");
			instance.ExtraStretchyGumOwned = nbt.getBoolean("ExtraStretchyGumOwned");
			instance.FastHatchGamePass = nbt.getBoolean("FastHatchGamePass");
			instance.FinnMcCoolFaceOwned = nbt.getBoolean("FinnMcCoolFaceOwned");
			instance.FireGumOwned = nbt.getBoolean("FireGumOwned");
			instance.FishGumOwned = nbt.getBoolean("FishGumOwned");
			instance.FlamesFlavorOwned = nbt.getBoolean("FlamesFlavorOwned");
			instance.FriendlyPirateFaceOwned = nbt.getBoolean("FriendlyPirateFaceOwned");
			instance.FrostFlavorOwned = nbt.getBoolean("FrostFlavorOwned");
			instance.GalaxyFlavorOwned = nbt.getBoolean("GalaxyFlavorOwned");
			instance.GodlyGumOwned = nbt.getBoolean("GodlyGumOwned");
			instance.GoldFlavorOwned = nbt.getBoolean("GoldFlavorOwned");
			instance.GreenBubbleFaceOwned = nbt.getBoolean("GreenBubbleFaceOwned");
			instance.HeroicGumOwned = nbt.getBoolean("HeroicGumOwned");
			instance.IcecreamFlavorOwned = nbt.getBoolean("IcecreamFlavorOwned");
			instance.InfernoFlavorOwned = nbt.getBoolean("InfernoFlavorOwned");
			instance.InfiniteBubbleGamePass = nbt.getBoolean("InfiniteBubbleGamePass");
			instance.IntenseFlavorOwned = nbt.getBoolean("IntenseFlavorOwned");
			instance.LavaFlavorOwned = nbt.getBoolean("LavaFlavorOwned");
			instance.LegendaryGumOwned = nbt.getBoolean("LegendaryGumOwned");
			instance.LemonFlavorOwned = nbt.getBoolean("LemonFlavorOwned");
			instance.LuckyChancesGamePass = nbt.getBoolean("LuckyChancesGamePass");
			instance.MagmaGumOwned = nbt.getBoolean("MagmaGumOwned");
			instance.MoltonFlavorOwned = nbt.getBoolean("MoltonFlavorOwned");
			instance.MonsterGumOwned = nbt.getBoolean("MonsterGumOwned");
			instance.MultiEggGamePass = nbt.getBoolean("MultiEggGamePass");
			instance.MythicalGumOwned = nbt.getBoolean("MythicalGumOwned");
			instance.NormalFaceOwned = nbt.getBoolean("NormalFaceOwned");
			instance.NormalGumOwned = nbt.getBoolean("NormalGumOwned");
			instance.OceanGumOwned = nbt.getBoolean("OceanGumOwned");
			instance.OmegaGumOwned = nbt.getBoolean("OmegaGumOwned");
			instance.OrangeFlavorOwned = nbt.getBoolean("OrangeFlavorOwned");
			instance.PineappleFlavorOwned = nbt.getBoolean("PineappleFlavorOwned");
			instance.PizzaFlavorOwned = nbt.getBoolean("PizzaFlavorOwned");
			instance.PlasmaFlavorOwned = nbt.getBoolean("PlasmaFlavorOwned");
			instance.PopcornFlavorOwned = nbt.getBoolean("PopcornFlavorOwned");
			instance.PuzzleFlavorOwned = nbt.getBoolean("PuzzleFlavorOwned");
			instance.QuantumGumOwned = nbt.getBoolean("QuantumGumOwned");
			instance.RadioactiveGumOwned = nbt.getBoolean("RadioactiveGumOwned");
			instance.RainbowFlavorOwned = nbt.getBoolean("RainbowFlavorOwned");
			instance.RedGlowingEyesFaceOwned = nbt.getBoolean("RedGlowingEyesFaceOwned");
			instance.RedGoofFaceOwned = nbt.getBoolean("RedGoofFaceOwned");
			instance.RedRawrFaceOwned = nbt.getBoolean("RedRawrFaceOwned");
			instance.RedTangoFaceOwned = nbt.getBoolean("RedTangoFaceOwned");
			instance.RubyFlavorOwned = nbt.getBoolean("RubyFlavorOwned");
			instance.SandyGumOwned = nbt.getBoolean("SandyGumOwned");
			instance.ScarFaceOwned = nbt.getBoolean("ScarFaceOwned");
			instance.SourGumOwned = nbt.getBoolean("SourGumOwned");
			instance.SpaceBootsGamePass = nbt.getBoolean("SpaceBootsGamePass");
			instance.SpicyFlavorOwned = nbt.getBoolean("SpicyFlavorOwned");
			instance.SprinklesFlavorOwned = nbt.getBoolean("SprinklesFlavorOwned");
			instance.SprintGamePass = nbt.getBoolean("SprintGamePass");
			instance.StitchesFaceOwned = nbt.getBoolean("StitchesFaceOwned");
			instance.StretchyGumOwned = nbt.getBoolean("StretchyGumOwned");
			instance.SugarGumOwned = nbt.getBoolean("SugarGumOwned");
			instance.SuperDuperGumOwned = nbt.getBoolean("SuperDuperGumOwned");
			instance.SuperGumOwned = nbt.getBoolean("SuperGumOwned");
			instance.SurgeFlavorOwned = nbt.getBoolean("SurgeFlavorOwned");
			instance.SweetGumOwned = nbt.getBoolean("SweetGumOwned");
			instance.SwirlFlavorOwned = nbt.getBoolean("SwirlFlavorOwned");
			instance.TriangularFlavorOwned = nbt.getBoolean("TriangularFlavorOwned");
			instance.UltraGumOwned = nbt.getBoolean("UltraGumOwned");
			instance.UniversalGumOwned = nbt.getBoolean("UniversalGumOwned");
			instance.UnrealGumOwned = nbt.getBoolean("UnrealGumOwned");
			instance.UsedCodeBlueCrew = nbt.getBoolean("UsedCodeBlueCrew");
			instance.UsedCodeFreeCoins = nbt.getBoolean("UsedCodeFreeCoins");
			instance.UsedCodeLotsOfGems = nbt.getBoolean("UsedCodeLotsOfGems");
			instance.UsedCodeMinime = nbt.getBoolean("UsedCodeMinime");
			instance.UsedCodeObscureEntity = nbt.getBoolean("UsedCodeObscureEntity");
			instance.UsedCodepinkarmypet = nbt.getBoolean("UsedCodepinkarmypet");
			instance.UsedCodeSuperCoins = nbt.getBoolean("UsedCodeSuperCoins");
			instance.UsedCodeSuperGems = nbt.getBoolean("UsedCodeSuperGems");
			instance.UsedCodeTofuu = nbt.getBoolean("UsedCodeTofuu");
			instance.UsedCodeTwisted = nbt.getBoolean("UsedCodeTwisted");
			instance.VampireFaceOwned = nbt.getBoolean("VampireFaceOwned");
			instance.VenomFlavorOwned = nbt.getBoolean("VenomFlavorOwned");
			instance.VIPFlavorOwned = nbt.getBoolean("VIPFlavorOwned");
			instance.VIPGamePass = nbt.getBoolean("VIPGamePass");
			instance.VoidFlavorOwned = nbt.getBoolean("VoidFlavorOwned");
			instance.WatermelonFlavorOwned = nbt.getBoolean("WatermelonFlavorOwned");
			instance.XDFaceOwned = nbt.getBoolean("XDFaceOwned");
			instance.YumFaceOwned = nbt.getBoolean("YumFaceOwned");
		}
	}

	public static class PlayerVariables {
		public double BlockCurrency = 0;
		public double CandyCurrency = 0;
		public double DoggyCollections = 0;
		public double LuckChance = 1.0;
		public double MobuxCurrency = 0;
		public double MultiCurrency = 0;
		public double MysticCurrency = 0;
		public double MythicChance = 1.0;
		public double PearlCurrency = 0;
		public double RainbowCurrency = 0;
		public double ShardCurrency = 0;
		public double ShellCurrency = 0;
		public double ShinyChance = 1.0;
		public double TeamsBubbleStats = 0;
		public double TotalBubbles = 0;
		public double TotalEggs = 0;
		public double TotalLegendsHatched = 0;
		public double TotalSecretsHatched = 0;
		public double BubblesPerClick = 0.0;
		public double CoinCurrency = 0.0;
		public double CurrentBubbles = 0.0;
		public double CurrentFace = 0.0;
		public double CurrentFlavor = 0.0;
		public double CurrentGum = 0.0;
		public double GemCurrency = 0.0;
		public double MagmaCurrency = 0.0;
		public double PlayerSpeed = 0.0;
		public double DoggyBubbles = 1.0;
		public double DoggyGems = 1.0;
		public double PlayerGravity = 1.0;
		public double PlayerLuck = 1.0;
		public boolean AlienGumOwned = false;
		public boolean AquaFlavorOwned = false;
		public boolean AzureWrathFaceOwned = false;
		public boolean BeastModeFaceOwned = false;
		public boolean BlueberryFlavorOwned = false;
		public boolean BlueBubbleFaceOwned = false;
		public boolean BubbleGumFlavorOwned = false;
		public boolean BubbleTroubleFaceOwned = false;
		public boolean CherryFlavorOwned = false;
		public boolean ChewFasterGamePass = false;
		public boolean ChewyGumOwned = false;
		public boolean ChocolateFlavorOwned = false;
		public boolean CodeUsed = false;
		public boolean CodeVerified = false;
		public boolean ContrastFlavorOwned = false;
		public boolean CrimsonEvilEyeFaceOwned = false;
		public boolean CrimsonWrathFaceOwned = false;
		public boolean DaringBeardFaceOwned = false;
		public boolean DonutFlavorOwned = false;
		public boolean DoubleBubbleGamePass = false;
		public boolean DoubleCoinsGamePass = false;
		public boolean DoubleGemsGamePass = false;
		public boolean EmeraldWrathFaceOwned = false;
		public boolean EpicGumOwned = false;
		public boolean EvilSkepticFaceOwned = false;
		public boolean Experiment32GumOwned = false;
		public boolean Experiment54GumOwned = false;
		public boolean ExtraChewyGumOwned = false;
		public boolean ExtraStretchyGumOwned = false;
		public boolean FastHatchGamePass = false;
		public boolean FinnMcCoolFaceOwned = false;
		public boolean FireGumOwned = false;
		public boolean FishGumOwned = false;
		public boolean FlamesFlavorOwned = false;
		public boolean FriendlyPirateFaceOwned = false;
		public boolean FrostFlavorOwned = false;
		public boolean GalaxyFlavorOwned = false;
		public boolean GodlyGumOwned = false;
		public boolean GoldFlavorOwned = false;
		public boolean GreenBubbleFaceOwned = false;
		public boolean HeroicGumOwned = false;
		public boolean IcecreamFlavorOwned = false;
		public boolean InfernoFlavorOwned = false;
		public boolean InfiniteBubbleGamePass = false;
		public boolean IntenseFlavorOwned = false;
		public boolean LavaFlavorOwned = false;
		public boolean LegendaryGumOwned = false;
		public boolean LemonFlavorOwned = false;
		public boolean LuckyChancesGamePass = false;
		public boolean MagmaGumOwned = false;
		public boolean MoltonFlavorOwned = false;
		public boolean MonsterGumOwned = false;
		public boolean MultiEggGamePass = false;
		public boolean MythicalGumOwned = false;
		public boolean NormalFaceOwned = false;
		public boolean NormalGumOwned = false;
		public boolean OceanGumOwned = false;
		public boolean OmegaGumOwned = false;
		public boolean OrangeFlavorOwned = false;
		public boolean PineappleFlavorOwned = false;
		public boolean PizzaFlavorOwned = false;
		public boolean PlasmaFlavorOwned = false;
		public boolean PopcornFlavorOwned = false;
		public boolean PuzzleFlavorOwned = false;
		public boolean QuantumGumOwned = false;
		public boolean RadioactiveGumOwned = false;
		public boolean RainbowFlavorOwned = false;
		public boolean RedGlowingEyesFaceOwned = false;
		public boolean RedGoofFaceOwned = false;
		public boolean RedRawrFaceOwned = false;
		public boolean RedTangoFaceOwned = false;
		public boolean RubyFlavorOwned = false;
		public boolean SandyGumOwned = false;
		public boolean ScarFaceOwned = false;
		public boolean SourGumOwned = false;
		public boolean SpaceBootsGamePass = false;
		public boolean SpicyFlavorOwned = false;
		public boolean SprinklesFlavorOwned = false;
		public boolean SprintGamePass = false;
		public boolean StitchesFaceOwned = false;
		public boolean StretchyGumOwned = false;
		public boolean SugarGumOwned = false;
		public boolean SuperDuperGumOwned = false;
		public boolean SuperGumOwned = false;
		public boolean SurgeFlavorOwned = false;
		public boolean SweetGumOwned = false;
		public boolean SwirlFlavorOwned = false;
		public boolean TriangularFlavorOwned = false;
		public boolean UltraGumOwned = false;
		public boolean UniversalGumOwned = false;
		public boolean UnrealGumOwned = false;
		public boolean UsedCodeBlueCrew = false;
		public boolean UsedCodeFreeCoins = false;
		public boolean UsedCodeLotsOfGems = false;
		public boolean UsedCodeMinime = false;
		public boolean UsedCodeObscureEntity = false;
		public boolean UsedCodepinkarmypet = false;
		public boolean UsedCodeSuperCoins = false;
		public boolean UsedCodeSuperGems = false;
		public boolean UsedCodeTofuu = false;
		public boolean UsedCodeTwisted = false;
		public boolean VampireFaceOwned = false;
		public boolean VenomFlavorOwned = false;
		public boolean VIPFlavorOwned = false;
		public boolean VIPGamePass = false;
		public boolean VoidFlavorOwned = false;
		public boolean WatermelonFlavorOwned = false;
		public boolean XDFaceOwned = false;
		public boolean YumFaceOwned = false;
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				BubbleGumSimulatorMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.BlockCurrency = original.BlockCurrency;
			clone.CandyCurrency = original.CandyCurrency;
			clone.DoggyCollections = original.DoggyCollections;
			clone.LuckChance = original.LuckChance;
			clone.MobuxCurrency = original.MobuxCurrency;
			clone.MultiCurrency = original.MultiCurrency;
			clone.MysticCurrency = original.MysticCurrency;
			clone.MythicChance = original.MythicChance;
			clone.PearlCurrency = original.PearlCurrency;
			clone.RainbowCurrency = original.RainbowCurrency;
			clone.ShardCurrency = original.ShardCurrency;
			clone.ShellCurrency = original.ShellCurrency;
			clone.ShinyChance = original.ShinyChance;
			clone.TeamsBubbleStats = original.TeamsBubbleStats;
			clone.TotalBubbles = original.TotalBubbles;
			clone.TotalEggs = original.TotalEggs;
			clone.TotalLegendsHatched = original.TotalLegendsHatched;
			clone.TotalSecretsHatched = original.TotalSecretsHatched;
			clone.BubblesPerClick = original.BubblesPerClick;
			clone.CoinCurrency = original.CoinCurrency;
			clone.CurrentBubbles = original.CurrentBubbles;
			clone.CurrentFace = original.CurrentFace;
			clone.CurrentFlavor = original.CurrentFlavor;
			clone.CurrentGum = original.CurrentGum;
			clone.GemCurrency = original.GemCurrency;
			clone.MagmaCurrency = original.MagmaCurrency;
			clone.PlayerSpeed = original.PlayerSpeed;
			clone.DoggyBubbles = original.DoggyBubbles;
			clone.DoggyGems = original.DoggyGems;
			clone.PlayerGravity = original.PlayerGravity;
			clone.PlayerLuck = original.PlayerLuck;
			clone.AlienGumOwned = original.AlienGumOwned;
			clone.AquaFlavorOwned = original.AquaFlavorOwned;
			clone.AzureWrathFaceOwned = original.AzureWrathFaceOwned;
			clone.BeastModeFaceOwned = original.BeastModeFaceOwned;
			clone.BlueberryFlavorOwned = original.BlueberryFlavorOwned;
			clone.BlueBubbleFaceOwned = original.BlueBubbleFaceOwned;
			clone.BubbleGumFlavorOwned = original.BubbleGumFlavorOwned;
			clone.BubbleTroubleFaceOwned = original.BubbleTroubleFaceOwned;
			clone.CherryFlavorOwned = original.CherryFlavorOwned;
			clone.ChewFasterGamePass = original.ChewFasterGamePass;
			clone.ChewyGumOwned = original.ChewyGumOwned;
			clone.ChocolateFlavorOwned = original.ChocolateFlavorOwned;
			clone.CodeUsed = original.CodeUsed;
			clone.CodeVerified = original.CodeVerified;
			clone.ContrastFlavorOwned = original.ContrastFlavorOwned;
			clone.CrimsonEvilEyeFaceOwned = original.CrimsonEvilEyeFaceOwned;
			clone.CrimsonWrathFaceOwned = original.CrimsonWrathFaceOwned;
			clone.DaringBeardFaceOwned = original.DaringBeardFaceOwned;
			clone.DonutFlavorOwned = original.DonutFlavorOwned;
			clone.DoubleBubbleGamePass = original.DoubleBubbleGamePass;
			clone.DoubleCoinsGamePass = original.DoubleCoinsGamePass;
			clone.DoubleGemsGamePass = original.DoubleGemsGamePass;
			clone.EmeraldWrathFaceOwned = original.EmeraldWrathFaceOwned;
			clone.EpicGumOwned = original.EpicGumOwned;
			clone.EvilSkepticFaceOwned = original.EvilSkepticFaceOwned;
			clone.Experiment32GumOwned = original.Experiment32GumOwned;
			clone.Experiment54GumOwned = original.Experiment54GumOwned;
			clone.ExtraChewyGumOwned = original.ExtraChewyGumOwned;
			clone.ExtraStretchyGumOwned = original.ExtraStretchyGumOwned;
			clone.FastHatchGamePass = original.FastHatchGamePass;
			clone.FinnMcCoolFaceOwned = original.FinnMcCoolFaceOwned;
			clone.FireGumOwned = original.FireGumOwned;
			clone.FishGumOwned = original.FishGumOwned;
			clone.FlamesFlavorOwned = original.FlamesFlavorOwned;
			clone.FriendlyPirateFaceOwned = original.FriendlyPirateFaceOwned;
			clone.FrostFlavorOwned = original.FrostFlavorOwned;
			clone.GalaxyFlavorOwned = original.GalaxyFlavorOwned;
			clone.GodlyGumOwned = original.GodlyGumOwned;
			clone.GoldFlavorOwned = original.GoldFlavorOwned;
			clone.GreenBubbleFaceOwned = original.GreenBubbleFaceOwned;
			clone.HeroicGumOwned = original.HeroicGumOwned;
			clone.IcecreamFlavorOwned = original.IcecreamFlavorOwned;
			clone.InfernoFlavorOwned = original.InfernoFlavorOwned;
			clone.InfiniteBubbleGamePass = original.InfiniteBubbleGamePass;
			clone.IntenseFlavorOwned = original.IntenseFlavorOwned;
			clone.LavaFlavorOwned = original.LavaFlavorOwned;
			clone.LegendaryGumOwned = original.LegendaryGumOwned;
			clone.LemonFlavorOwned = original.LemonFlavorOwned;
			clone.LuckyChancesGamePass = original.LuckyChancesGamePass;
			clone.MagmaGumOwned = original.MagmaGumOwned;
			clone.MoltonFlavorOwned = original.MoltonFlavorOwned;
			clone.MonsterGumOwned = original.MonsterGumOwned;
			clone.MultiEggGamePass = original.MultiEggGamePass;
			clone.MythicalGumOwned = original.MythicalGumOwned;
			clone.NormalFaceOwned = original.NormalFaceOwned;
			clone.NormalGumOwned = original.NormalGumOwned;
			clone.OceanGumOwned = original.OceanGumOwned;
			clone.OmegaGumOwned = original.OmegaGumOwned;
			clone.OrangeFlavorOwned = original.OrangeFlavorOwned;
			clone.PineappleFlavorOwned = original.PineappleFlavorOwned;
			clone.PizzaFlavorOwned = original.PizzaFlavorOwned;
			clone.PlasmaFlavorOwned = original.PlasmaFlavorOwned;
			clone.PopcornFlavorOwned = original.PopcornFlavorOwned;
			clone.PuzzleFlavorOwned = original.PuzzleFlavorOwned;
			clone.QuantumGumOwned = original.QuantumGumOwned;
			clone.RadioactiveGumOwned = original.RadioactiveGumOwned;
			clone.RainbowFlavorOwned = original.RainbowFlavorOwned;
			clone.RedGlowingEyesFaceOwned = original.RedGlowingEyesFaceOwned;
			clone.RedGoofFaceOwned = original.RedGoofFaceOwned;
			clone.RedRawrFaceOwned = original.RedRawrFaceOwned;
			clone.RedTangoFaceOwned = original.RedTangoFaceOwned;
			clone.RubyFlavorOwned = original.RubyFlavorOwned;
			clone.SandyGumOwned = original.SandyGumOwned;
			clone.ScarFaceOwned = original.ScarFaceOwned;
			clone.SourGumOwned = original.SourGumOwned;
			clone.SpaceBootsGamePass = original.SpaceBootsGamePass;
			clone.SpicyFlavorOwned = original.SpicyFlavorOwned;
			clone.SprinklesFlavorOwned = original.SprinklesFlavorOwned;
			clone.SprintGamePass = original.SprintGamePass;
			clone.StitchesFaceOwned = original.StitchesFaceOwned;
			clone.StretchyGumOwned = original.StretchyGumOwned;
			clone.SugarGumOwned = original.SugarGumOwned;
			clone.SuperDuperGumOwned = original.SuperDuperGumOwned;
			clone.SuperGumOwned = original.SuperGumOwned;
			clone.SurgeFlavorOwned = original.SurgeFlavorOwned;
			clone.SweetGumOwned = original.SweetGumOwned;
			clone.SwirlFlavorOwned = original.SwirlFlavorOwned;
			clone.TriangularFlavorOwned = original.TriangularFlavorOwned;
			clone.UltraGumOwned = original.UltraGumOwned;
			clone.UniversalGumOwned = original.UniversalGumOwned;
			clone.UnrealGumOwned = original.UnrealGumOwned;
			clone.UsedCodeBlueCrew = original.UsedCodeBlueCrew;
			clone.UsedCodeFreeCoins = original.UsedCodeFreeCoins;
			clone.UsedCodeLotsOfGems = original.UsedCodeLotsOfGems;
			clone.UsedCodeMinime = original.UsedCodeMinime;
			clone.UsedCodeObscureEntity = original.UsedCodeObscureEntity;
			clone.UsedCodepinkarmypet = original.UsedCodepinkarmypet;
			clone.UsedCodeSuperCoins = original.UsedCodeSuperCoins;
			clone.UsedCodeSuperGems = original.UsedCodeSuperGems;
			clone.UsedCodeTofuu = original.UsedCodeTofuu;
			clone.UsedCodeTwisted = original.UsedCodeTwisted;
			clone.VampireFaceOwned = original.VampireFaceOwned;
			clone.VenomFlavorOwned = original.VenomFlavorOwned;
			clone.VIPFlavorOwned = original.VIPFlavorOwned;
			clone.VIPGamePass = original.VIPGamePass;
			clone.VoidFlavorOwned = original.VoidFlavorOwned;
			clone.WatermelonFlavorOwned = original.WatermelonFlavorOwned;
			clone.XDFaceOwned = original.XDFaceOwned;
			clone.YumFaceOwned = original.YumFaceOwned;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.BlockCurrency = message.data.BlockCurrency;
					variables.CandyCurrency = message.data.CandyCurrency;
					variables.DoggyCollections = message.data.DoggyCollections;
					variables.LuckChance = message.data.LuckChance;
					variables.MobuxCurrency = message.data.MobuxCurrency;
					variables.MultiCurrency = message.data.MultiCurrency;
					variables.MysticCurrency = message.data.MysticCurrency;
					variables.MythicChance = message.data.MythicChance;
					variables.PearlCurrency = message.data.PearlCurrency;
					variables.RainbowCurrency = message.data.RainbowCurrency;
					variables.ShardCurrency = message.data.ShardCurrency;
					variables.ShellCurrency = message.data.ShellCurrency;
					variables.ShinyChance = message.data.ShinyChance;
					variables.TeamsBubbleStats = message.data.TeamsBubbleStats;
					variables.TotalBubbles = message.data.TotalBubbles;
					variables.TotalEggs = message.data.TotalEggs;
					variables.TotalLegendsHatched = message.data.TotalLegendsHatched;
					variables.TotalSecretsHatched = message.data.TotalSecretsHatched;
					variables.BubblesPerClick = message.data.BubblesPerClick;
					variables.CoinCurrency = message.data.CoinCurrency;
					variables.CurrentBubbles = message.data.CurrentBubbles;
					variables.CurrentFace = message.data.CurrentFace;
					variables.CurrentFlavor = message.data.CurrentFlavor;
					variables.CurrentGum = message.data.CurrentGum;
					variables.GemCurrency = message.data.GemCurrency;
					variables.MagmaCurrency = message.data.MagmaCurrency;
					variables.PlayerSpeed = message.data.PlayerSpeed;
					variables.DoggyBubbles = message.data.DoggyBubbles;
					variables.DoggyGems = message.data.DoggyGems;
					variables.PlayerGravity = message.data.PlayerGravity;
					variables.PlayerLuck = message.data.PlayerLuck;
					variables.AlienGumOwned = message.data.AlienGumOwned;
					variables.AquaFlavorOwned = message.data.AquaFlavorOwned;
					variables.AzureWrathFaceOwned = message.data.AzureWrathFaceOwned;
					variables.BeastModeFaceOwned = message.data.BeastModeFaceOwned;
					variables.BlueberryFlavorOwned = message.data.BlueberryFlavorOwned;
					variables.BlueBubbleFaceOwned = message.data.BlueBubbleFaceOwned;
					variables.BubbleGumFlavorOwned = message.data.BubbleGumFlavorOwned;
					variables.BubbleTroubleFaceOwned = message.data.BubbleTroubleFaceOwned;
					variables.CherryFlavorOwned = message.data.CherryFlavorOwned;
					variables.ChewFasterGamePass = message.data.ChewFasterGamePass;
					variables.ChewyGumOwned = message.data.ChewyGumOwned;
					variables.ChocolateFlavorOwned = message.data.ChocolateFlavorOwned;
					variables.CodeUsed = message.data.CodeUsed;
					variables.CodeVerified = message.data.CodeVerified;
					variables.ContrastFlavorOwned = message.data.ContrastFlavorOwned;
					variables.CrimsonEvilEyeFaceOwned = message.data.CrimsonEvilEyeFaceOwned;
					variables.CrimsonWrathFaceOwned = message.data.CrimsonWrathFaceOwned;
					variables.DaringBeardFaceOwned = message.data.DaringBeardFaceOwned;
					variables.DonutFlavorOwned = message.data.DonutFlavorOwned;
					variables.DoubleBubbleGamePass = message.data.DoubleBubbleGamePass;
					variables.DoubleCoinsGamePass = message.data.DoubleCoinsGamePass;
					variables.DoubleGemsGamePass = message.data.DoubleGemsGamePass;
					variables.EmeraldWrathFaceOwned = message.data.EmeraldWrathFaceOwned;
					variables.EpicGumOwned = message.data.EpicGumOwned;
					variables.EvilSkepticFaceOwned = message.data.EvilSkepticFaceOwned;
					variables.Experiment32GumOwned = message.data.Experiment32GumOwned;
					variables.Experiment54GumOwned = message.data.Experiment54GumOwned;
					variables.ExtraChewyGumOwned = message.data.ExtraChewyGumOwned;
					variables.ExtraStretchyGumOwned = message.data.ExtraStretchyGumOwned;
					variables.FastHatchGamePass = message.data.FastHatchGamePass;
					variables.FinnMcCoolFaceOwned = message.data.FinnMcCoolFaceOwned;
					variables.FireGumOwned = message.data.FireGumOwned;
					variables.FishGumOwned = message.data.FishGumOwned;
					variables.FlamesFlavorOwned = message.data.FlamesFlavorOwned;
					variables.FriendlyPirateFaceOwned = message.data.FriendlyPirateFaceOwned;
					variables.FrostFlavorOwned = message.data.FrostFlavorOwned;
					variables.GalaxyFlavorOwned = message.data.GalaxyFlavorOwned;
					variables.GodlyGumOwned = message.data.GodlyGumOwned;
					variables.GoldFlavorOwned = message.data.GoldFlavorOwned;
					variables.GreenBubbleFaceOwned = message.data.GreenBubbleFaceOwned;
					variables.HeroicGumOwned = message.data.HeroicGumOwned;
					variables.IcecreamFlavorOwned = message.data.IcecreamFlavorOwned;
					variables.InfernoFlavorOwned = message.data.InfernoFlavorOwned;
					variables.InfiniteBubbleGamePass = message.data.InfiniteBubbleGamePass;
					variables.IntenseFlavorOwned = message.data.IntenseFlavorOwned;
					variables.LavaFlavorOwned = message.data.LavaFlavorOwned;
					variables.LegendaryGumOwned = message.data.LegendaryGumOwned;
					variables.LemonFlavorOwned = message.data.LemonFlavorOwned;
					variables.LuckyChancesGamePass = message.data.LuckyChancesGamePass;
					variables.MagmaGumOwned = message.data.MagmaGumOwned;
					variables.MoltonFlavorOwned = message.data.MoltonFlavorOwned;
					variables.MonsterGumOwned = message.data.MonsterGumOwned;
					variables.MultiEggGamePass = message.data.MultiEggGamePass;
					variables.MythicalGumOwned = message.data.MythicalGumOwned;
					variables.NormalFaceOwned = message.data.NormalFaceOwned;
					variables.NormalGumOwned = message.data.NormalGumOwned;
					variables.OceanGumOwned = message.data.OceanGumOwned;
					variables.OmegaGumOwned = message.data.OmegaGumOwned;
					variables.OrangeFlavorOwned = message.data.OrangeFlavorOwned;
					variables.PineappleFlavorOwned = message.data.PineappleFlavorOwned;
					variables.PizzaFlavorOwned = message.data.PizzaFlavorOwned;
					variables.PlasmaFlavorOwned = message.data.PlasmaFlavorOwned;
					variables.PopcornFlavorOwned = message.data.PopcornFlavorOwned;
					variables.PuzzleFlavorOwned = message.data.PuzzleFlavorOwned;
					variables.QuantumGumOwned = message.data.QuantumGumOwned;
					variables.RadioactiveGumOwned = message.data.RadioactiveGumOwned;
					variables.RainbowFlavorOwned = message.data.RainbowFlavorOwned;
					variables.RedGlowingEyesFaceOwned = message.data.RedGlowingEyesFaceOwned;
					variables.RedGoofFaceOwned = message.data.RedGoofFaceOwned;
					variables.RedRawrFaceOwned = message.data.RedRawrFaceOwned;
					variables.RedTangoFaceOwned = message.data.RedTangoFaceOwned;
					variables.RubyFlavorOwned = message.data.RubyFlavorOwned;
					variables.SandyGumOwned = message.data.SandyGumOwned;
					variables.ScarFaceOwned = message.data.ScarFaceOwned;
					variables.SourGumOwned = message.data.SourGumOwned;
					variables.SpaceBootsGamePass = message.data.SpaceBootsGamePass;
					variables.SpicyFlavorOwned = message.data.SpicyFlavorOwned;
					variables.SprinklesFlavorOwned = message.data.SprinklesFlavorOwned;
					variables.SprintGamePass = message.data.SprintGamePass;
					variables.StitchesFaceOwned = message.data.StitchesFaceOwned;
					variables.StretchyGumOwned = message.data.StretchyGumOwned;
					variables.SugarGumOwned = message.data.SugarGumOwned;
					variables.SuperDuperGumOwned = message.data.SuperDuperGumOwned;
					variables.SuperGumOwned = message.data.SuperGumOwned;
					variables.SurgeFlavorOwned = message.data.SurgeFlavorOwned;
					variables.SweetGumOwned = message.data.SweetGumOwned;
					variables.SwirlFlavorOwned = message.data.SwirlFlavorOwned;
					variables.TriangularFlavorOwned = message.data.TriangularFlavorOwned;
					variables.UltraGumOwned = message.data.UltraGumOwned;
					variables.UniversalGumOwned = message.data.UniversalGumOwned;
					variables.UnrealGumOwned = message.data.UnrealGumOwned;
					variables.UsedCodeBlueCrew = message.data.UsedCodeBlueCrew;
					variables.UsedCodeFreeCoins = message.data.UsedCodeFreeCoins;
					variables.UsedCodeLotsOfGems = message.data.UsedCodeLotsOfGems;
					variables.UsedCodeMinime = message.data.UsedCodeMinime;
					variables.UsedCodeObscureEntity = message.data.UsedCodeObscureEntity;
					variables.UsedCodepinkarmypet = message.data.UsedCodepinkarmypet;
					variables.UsedCodeSuperCoins = message.data.UsedCodeSuperCoins;
					variables.UsedCodeSuperGems = message.data.UsedCodeSuperGems;
					variables.UsedCodeTofuu = message.data.UsedCodeTofuu;
					variables.UsedCodeTwisted = message.data.UsedCodeTwisted;
					variables.VampireFaceOwned = message.data.VampireFaceOwned;
					variables.VenomFlavorOwned = message.data.VenomFlavorOwned;
					variables.VIPFlavorOwned = message.data.VIPFlavorOwned;
					variables.VIPGamePass = message.data.VIPGamePass;
					variables.VoidFlavorOwned = message.data.VoidFlavorOwned;
					variables.WatermelonFlavorOwned = message.data.WatermelonFlavorOwned;
					variables.XDFaceOwned = message.data.XDFaceOwned;
					variables.YumFaceOwned = message.data.YumFaceOwned;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
