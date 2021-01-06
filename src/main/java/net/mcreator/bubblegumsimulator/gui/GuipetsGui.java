
package net.mcreator.bubblegumsimulator.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.network.IContainerFactory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.Minecraft;

import net.mcreator.bubblegumsimulator.procedures.CloseallguisProcedure;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorModElements;
import net.mcreator.bubblegumsimulator.BubbleGumSimulatorMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

@BubbleGumSimulatorModElements.ModElement.Tag
public class GuipetsGui extends BubbleGumSimulatorModElements.ModElement {
	public static HashMap guistate = new HashMap();
	private static ContainerType<GuiContainerMod> containerType = null;
	public GuipetsGui(BubbleGumSimulatorModElements instance) {
		super(instance, 264);
		elements.addNetworkMessage(ButtonPressedMessage.class, ButtonPressedMessage::buffer, ButtonPressedMessage::new,
				ButtonPressedMessage::handler);
		elements.addNetworkMessage(GUISlotChangedMessage.class, GUISlotChangedMessage::buffer, GUISlotChangedMessage::new,
				GUISlotChangedMessage::handler);
		containerType = new ContainerType<>(new GuiContainerModFactory());
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@OnlyIn(Dist.CLIENT)
	public void initElements() {
		DeferredWorkQueue.runLater(() -> ScreenManager.registerFactory(containerType, GuiWindow::new));
	}

	@SubscribeEvent
	public void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().register(containerType.setRegistryName("guipets"));
	}
	public static class GuiContainerModFactory implements IContainerFactory {
		public GuiContainerMod create(int id, PlayerInventory inv, PacketBuffer extraData) {
			return new GuiContainerMod(id, inv, extraData);
		}
	}

	public static class GuiContainerMod extends Container implements Supplier<Map<Integer, Slot>> {
		private World world;
		private PlayerEntity entity;
		private int x, y, z;
		private IItemHandler internal;
		private Map<Integer, Slot> customSlots = new HashMap<>();
		private boolean bound = false;
		public GuiContainerMod(int id, PlayerInventory inv, PacketBuffer extraData) {
			super(containerType, id);
			this.entity = inv.player;
			this.world = inv.player.world;
			this.internal = new ItemStackHandler(49);
			BlockPos pos = null;
			if (extraData != null) {
				pos = extraData.readBlockPos();
				this.x = pos.getX();
				this.y = pos.getY();
				this.z = pos.getZ();
			}
			if (pos != null) {
				if (extraData.readableBytes() == 1) { // bound to item
					byte hand = extraData.readByte();
					ItemStack itemstack;
					if (hand == 0)
						itemstack = this.entity.getHeldItemMainhand();
					else
						itemstack = this.entity.getHeldItemOffhand();
					itemstack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						this.internal = capability;
						this.bound = true;
					});
				} else if (extraData.readableBytes() > 1) {
					extraData.readByte(); // drop padding
					Entity entity = world.getEntityByID(extraData.readVarInt());
					if (entity != null)
						entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
				} else { // might be bound to block
					TileEntity ent = inv.player != null ? inv.player.world.getTileEntity(pos) : null;
					if (ent != null) {
						ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							this.internal = capability;
							this.bound = true;
						});
					}
				}
			}
			this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 52, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 69, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 86, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 103, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 120, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 137, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(6, this.addSlot(new SlotItemHandler(internal, 6, 154, 36) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(7, this.addSlot(new SlotItemHandler(internal, 7, 52, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(8, this.addSlot(new SlotItemHandler(internal, 8, 69, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(9, this.addSlot(new SlotItemHandler(internal, 9, 86, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(10, this.addSlot(new SlotItemHandler(internal, 10, 103, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(11, this.addSlot(new SlotItemHandler(internal, 11, 120, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(12, this.addSlot(new SlotItemHandler(internal, 12, 137, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(13, this.addSlot(new SlotItemHandler(internal, 13, 154, 53) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(14, this.addSlot(new SlotItemHandler(internal, 14, 52, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(15, this.addSlot(new SlotItemHandler(internal, 15, 69, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(16, this.addSlot(new SlotItemHandler(internal, 16, 86, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(17, this.addSlot(new SlotItemHandler(internal, 17, 103, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(18, this.addSlot(new SlotItemHandler(internal, 18, 120, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(19, this.addSlot(new SlotItemHandler(internal, 19, 137, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(20, this.addSlot(new SlotItemHandler(internal, 20, 154, 70) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(21, this.addSlot(new SlotItemHandler(internal, 21, 52, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(22, this.addSlot(new SlotItemHandler(internal, 22, 69, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(23, this.addSlot(new SlotItemHandler(internal, 23, 86, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(24, this.addSlot(new SlotItemHandler(internal, 24, 103, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(25, this.addSlot(new SlotItemHandler(internal, 25, 120, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(26, this.addSlot(new SlotItemHandler(internal, 26, 137, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(27, this.addSlot(new SlotItemHandler(internal, 27, 154, 87) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(28, this.addSlot(new SlotItemHandler(internal, 28, 52, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(29, this.addSlot(new SlotItemHandler(internal, 29, 69, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(30, this.addSlot(new SlotItemHandler(internal, 30, 86, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(31, this.addSlot(new SlotItemHandler(internal, 31, 103, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(32, this.addSlot(new SlotItemHandler(internal, 32, 120, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(33, this.addSlot(new SlotItemHandler(internal, 33, 137, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(34, this.addSlot(new SlotItemHandler(internal, 34, 154, 104) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(35, this.addSlot(new SlotItemHandler(internal, 35, 52, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(36, this.addSlot(new SlotItemHandler(internal, 36, 69, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(37, this.addSlot(new SlotItemHandler(internal, 37, 86, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(38, this.addSlot(new SlotItemHandler(internal, 38, 103, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(39, this.addSlot(new SlotItemHandler(internal, 39, 120, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(40, this.addSlot(new SlotItemHandler(internal, 40, 137, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(41, this.addSlot(new SlotItemHandler(internal, 41, 154, 121) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(42, this.addSlot(new SlotItemHandler(internal, 42, 52, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(43, this.addSlot(new SlotItemHandler(internal, 43, 69, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(44, this.addSlot(new SlotItemHandler(internal, 44, 86, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(45, this.addSlot(new SlotItemHandler(internal, 45, 103, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(46, this.addSlot(new SlotItemHandler(internal, 46, 120, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(47, this.addSlot(new SlotItemHandler(internal, 47, 137, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			this.customSlots.put(48, this.addSlot(new SlotItemHandler(internal, 48, 154, 138) {
				@Override
				public boolean isItemValid(ItemStack stack) {
					return false;
				}
			}));
			int si;
			int sj;
			for (si = 0; si < 3; ++si)
				for (sj = 0; sj < 9; ++sj)
					this.addSlot(new Slot(inv, sj + (si + 1) * 9, 3 + 8 + sj * 18, 120 + 84 + si * 18));
			for (si = 0; si < 9; ++si)
				this.addSlot(new Slot(inv, si, 3 + 8 + si * 18, 120 + 142));
		}

		public Map<Integer, Slot> get() {
			return customSlots;
		}

		@Override
		public boolean canInteractWith(PlayerEntity player) {
			return true;
		}

		@Override
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			ItemStack itemstack = ItemStack.EMPTY;
			Slot slot = (Slot) this.inventorySlots.get(index);
			if (slot != null && slot.getHasStack()) {
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();
				if (index < 49) {
					if (!this.mergeItemStack(itemstack1, 49, this.inventorySlots.size(), true)) {
						return ItemStack.EMPTY;
					}
					slot.onSlotChange(itemstack1, itemstack);
				} else if (!this.mergeItemStack(itemstack1, 0, 49, false)) {
					if (index < 49 + 27) {
						if (!this.mergeItemStack(itemstack1, 49 + 27, this.inventorySlots.size(), true)) {
							return ItemStack.EMPTY;
						}
					} else {
						if (!this.mergeItemStack(itemstack1, 49, 49 + 27, false)) {
							return ItemStack.EMPTY;
						}
					}
					return ItemStack.EMPTY;
				}
				if (itemstack1.getCount() == 0) {
					slot.putStack(ItemStack.EMPTY);
				} else {
					slot.onSlotChanged();
				}
				if (itemstack1.getCount() == itemstack.getCount()) {
					return ItemStack.EMPTY;
				}
				slot.onTake(playerIn, itemstack1);
			}
			return itemstack;
		}

		@Override /**
					 * Merges provided ItemStack with the first avaliable one in the
					 * container/player inventor between minIndex (included) and maxIndex
					 * (excluded). Args : stack, minIndex, maxIndex, negativDirection. /!\ the
					 * Container implementation do not check if the item is valid for the slot
					 */
		protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
			boolean flag = false;
			int i = startIndex;
			if (reverseDirection) {
				i = endIndex - 1;
			}
			if (stack.isStackable()) {
				while (!stack.isEmpty()) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot = this.inventorySlots.get(i);
					ItemStack itemstack = slot.getStack();
					if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && areItemsAndTagsEqual(stack, itemstack)) {
						int j = itemstack.getCount() + stack.getCount();
						int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
						if (j <= maxSize) {
							stack.setCount(0);
							itemstack.setCount(j);
							slot.putStack(itemstack);
							flag = true;
						} else if (itemstack.getCount() < maxSize) {
							stack.shrink(maxSize - itemstack.getCount());
							itemstack.setCount(maxSize);
							slot.putStack(itemstack);
							flag = true;
						}
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			if (!stack.isEmpty()) {
				if (reverseDirection) {
					i = endIndex - 1;
				} else {
					i = startIndex;
				}
				while (true) {
					if (reverseDirection) {
						if (i < startIndex) {
							break;
						}
					} else if (i >= endIndex) {
						break;
					}
					Slot slot1 = this.inventorySlots.get(i);
					ItemStack itemstack1 = slot1.getStack();
					if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
						if (stack.getCount() > slot1.getSlotStackLimit()) {
							slot1.putStack(stack.split(slot1.getSlotStackLimit()));
						} else {
							slot1.putStack(stack.split(stack.getCount()));
						}
						slot1.onSlotChanged();
						flag = true;
						break;
					}
					if (reverseDirection) {
						--i;
					} else {
						++i;
					}
				}
			}
			return flag;
		}

		@Override
		public void onContainerClosed(PlayerEntity playerIn) {
			super.onContainerClosed(playerIn);
			if (!bound && (playerIn instanceof ServerPlayerEntity)) {
				if (!playerIn.isAlive() || playerIn instanceof ServerPlayerEntity && ((ServerPlayerEntity) playerIn).hasDisconnected()) {
					for (int j = 0; j < internal.getSlots(); ++j) {
						playerIn.dropItem(internal.extractItem(j, internal.getStackInSlot(j).getCount(), false), false);
					}
				} else {
					for (int i = 0; i < internal.getSlots(); ++i) {
						playerIn.inventory.placeItemBackInInventory(playerIn.world,
								internal.extractItem(i, internal.getStackInSlot(i).getCount(), false));
					}
				}
			}
		}

		private void slotChanged(int slotid, int ctype, int meta) {
			if (this.world != null && this.world.isRemote) {
				BubbleGumSimulatorMod.PACKET_HANDLER.sendToServer(new GUISlotChangedMessage(slotid, x, y, z, ctype, meta));
				handleSlotAction(entity, slotid, ctype, meta, x, y, z);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class GuiWindow extends ContainerScreen<GuiContainerMod> {
		private World world;
		private int x, y, z;
		private PlayerEntity entity;
		public GuiWindow(GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
			super(container, inventory, text);
			this.world = container.world;
			this.x = container.x;
			this.y = container.y;
			this.z = container.z;
			this.entity = container.entity;
			this.xSize = 182;
			this.ySize = 166;
		}
		private static final ResourceLocation texture = new ResourceLocation("bubble_gum_simulator:textures/guipets.png");
		@Override
		public void render(int mouseX, int mouseY, float partialTicks) {
			this.renderBackground();
			super.render(mouseX, mouseY, partialTicks);
			this.renderHoveredToolTip(mouseX, mouseY);
		}

		@Override
		protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
			GL11.glColor4f(1, 1, 1, 1);
			Minecraft.getInstance().getTextureManager().bindTexture(texture);
			int k = (this.width - this.xSize) / 2;
			int l = (this.height - this.ySize) / 2;
			this.blit(k, l, 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bubble_gum_simulator:textures/layer_13.png"));
			this.blit(this.guiLeft + -13, this.guiTop + 1, 0, 0, 194, 164, 194, 164);
			Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("bubble_gum_simulator:textures/rersr.png"));
			this.blit(this.guiLeft + 184, this.guiTop + 19, 0, 0, 28, 146, 28, 146);
		}

		@Override
		public boolean keyPressed(int key, int b, int c) {
			if (key == 256) {
				this.minecraft.player.closeScreen();
				return true;
			}
			return super.keyPressed(key, b, c);
		}

		@Override
		public void tick() {
			super.tick();
		}

		@Override
		protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
			this.font.drawString("" + (entity.getPersistentData().getDouble("Totalbubbles")) + "", 24, 166, -52276);
		}

		@Override
		public void removed() {
			super.removed();
			Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
		}

		@Override
		public void init(Minecraft minecraft, int width, int height) {
			super.init(minecraft, width, height);
			minecraft.keyboardListener.enableRepeatEvents(true);
			this.addButton(new Button(this.guiLeft + 149, this.guiTop + 2, 30, 20, "x", e -> {
				BubbleGumSimulatorMod.PACKET_HANDLER.sendToServer(new ButtonPressedMessage(0, x, y, z));
				handleButtonAction(entity, 0, x, y, z);
			}));
		}
	}

	public static class ButtonPressedMessage {
		int buttonID, x, y, z;
		public ButtonPressedMessage(PacketBuffer buffer) {
			this.buttonID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
		}

		public ButtonPressedMessage(int buttonID, int x, int y, int z) {
			this.buttonID = buttonID;
			this.x = x;
			this.y = y;
			this.z = z;
		}

		public static void buffer(ButtonPressedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.buttonID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
		}

		public static void handler(ButtonPressedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}

	public static class GUISlotChangedMessage {
		int slotID, x, y, z, changeType, meta;
		public GUISlotChangedMessage(int slotID, int x, int y, int z, int changeType, int meta) {
			this.slotID = slotID;
			this.x = x;
			this.y = y;
			this.z = z;
			this.changeType = changeType;
			this.meta = meta;
		}

		public GUISlotChangedMessage(PacketBuffer buffer) {
			this.slotID = buffer.readInt();
			this.x = buffer.readInt();
			this.y = buffer.readInt();
			this.z = buffer.readInt();
			this.changeType = buffer.readInt();
			this.meta = buffer.readInt();
		}

		public static void buffer(GUISlotChangedMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.slotID);
			buffer.writeInt(message.x);
			buffer.writeInt(message.y);
			buffer.writeInt(message.z);
			buffer.writeInt(message.changeType);
			buffer.writeInt(message.meta);
		}

		public static void handler(GUISlotChangedMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				PlayerEntity entity = context.getSender();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			});
			context.setPacketHandled(true);
		}
	}
	private static void handleButtonAction(PlayerEntity entity, int buttonID, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				CloseallguisProcedure.executeProcedure($_dependencies);
			}
		}
	}

	private static void handleSlotAction(PlayerEntity entity, int slotID, int changeType, int meta, int x, int y, int z) {
		World world = entity.world;
		// security measure to prevent arbitrary chunk generation
		if (!world.isBlockLoaded(new BlockPos(x, y, z)))
			return;
	}
}
