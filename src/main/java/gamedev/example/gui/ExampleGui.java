package gamedev.example.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import gamedev.example.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

public class ExampleGui extends GuiScreen {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID, "textures/gui/example_gui.png");
	private int guiWidth = 125;
	private int guiHeight = 160;
	
	private int containerWidth;
	private int containerHeight;
	
	private GuiButton button0;
	
	private final int BUTTON0 = 0;
	
	private enum B {
		BUTTON0(100, 20, "Button"),
		TEXTBOX0(100, 20, null);
		
		private final int width;
		private final int height;
		private final String text;
		
		private B (int width, int height, String text) {
			this.width = width;
			this.height = height;
			this.text = text;
		}
	}
	
	private String title = "Example";
	
	private GuiTextField textBox0;
	
	private int TEXTBOX0;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//Draws faded background
		drawDefaultBackground();
		//I don't know...
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		//Gives the gui a texture
		Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
		//The x position of the gui
		containerWidth = (this.width - guiWidth) / 2;
		//The y position of the gui
		containerHeight = (this.height - guiHeight) / 2;
		//Draws the gui
		this.drawTexturedModalRect(containerWidth, containerHeight, 0, 0, guiWidth, guiHeight);
		//Draws a centered string
		this.drawString(fontRendererObj, title, containerWidth + (guiWidth / 2) - (fontRendererObj.getStringWidth(title) / 2), containerHeight + 2, 0xFF0000);
		//Draws a string
		this.drawString(fontRendererObj, "Hello, World.", containerWidth + 5, containerHeight + 30, 0xFFFFFF);
		
		button0.drawButton(mc, mouseX, mouseY);
		
		textBox0.drawTextBox();
		
		//Tells GuiScreen to do stuff
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(button0 = new GuiButton(BUTTON0, ((this.width - guiWidth) / 2) + ((guiWidth / 2) - (B.BUTTON0.width / 2)), ((this.height - guiHeight) / 2) + (guiHeight - (10 + B.BUTTON0.height)), B.BUTTON0.width, B.BUTTON0.height, B.BUTTON0.text));
		textBox0 = new GuiTextField(TEXTBOX0, fontRendererObj, ((this.width - guiWidth) / 2) + ((guiWidth / 2) - (B.TEXTBOX0.width / 2)), ((this.height - guiHeight) / 2) + (guiHeight - (40 + B.BUTTON0.height)), B.TEXTBOX0.width, B.TEXTBOX0.height);
		super.initGui();
	}
	
	public void updateButtons() {
		if (title.equals("Example")) {
			button0.enabled = true;
		} else {
			button0.enabled = false;
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
			case BUTTON0:
				title = "Button Clicked";
				break;
		}
		updateButtons();
		super.actionPerformed(button);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		textBox0.textboxKeyTyped(typedChar, keyCode);
		super.keyTyped(typedChar, keyCode);
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		textBox0.mouseClicked(mouseX, mouseY, mouseButton);
		super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
