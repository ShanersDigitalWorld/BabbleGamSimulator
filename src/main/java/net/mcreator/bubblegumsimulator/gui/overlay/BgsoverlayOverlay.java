
package net.mcreator.bubblegumsimulator.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@BubbleGumSimulatorModElements.ModElement.Tag
public class BgsoverlayOverlay extends BubbleGumSimulatorModElements.ModElement {
	public BgsoverlayOverlay(BubbleGumSimulatorModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (true) {
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bubble_gum_simulator:textures/untitled-4.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + 164, posY + 4, 0, 0, 48, 115, 48, 115);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bubble_gum_simulator:textures/overlays.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -210, posY + -32, 0, 0, 92, 85, 92, 85);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (entity.getPersistentData().getString("OverlayBubbles")) + "", posX + -194, posY + -3, -65281);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (entity.getPersistentData().getString("OverlayCoinCurrency")) + "", posX + -193, posY + 17, -256);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (entity.getPersistentData().getString("OverlayGemCurrency")) + "", posX + -193, posY + 38, -10092340);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "" + (entity.getPersistentData().getString("Heights")) + "",
						posX + 0, posY + 63, -1);
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bubble_gum_simulator:textures/untitled-3.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -99, posY + 74, 0, 0, 198, 13, 198, 13);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "Height", posX + -99, posY + 63, -1);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(P)", posX + 190, posY + 16, -16777216);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(S)", posX + 191, posY + 47, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(T)", posX + 189, posY + 80, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(M)", posX + 185, posY + 108, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(I)", posX + -184, posY + -25, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(C)", posX + -207, posY + -24, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(B)", posX + -138, posY + -24, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "(R)", posX + -162, posY + -24, -12829636);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + (entity.getPersistentData().getDouble("BubblesPerClick")) + "", posX + -4, posY + -5, -39169);
			}
		}
	}
}
