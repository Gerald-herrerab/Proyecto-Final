package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40,  arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinish = false;
    public String currentDialogue = "";




    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);


    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;

    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);

        // estado de juego
        if (gp.GameState == gp.PlayState) {

        }
        
        //estado de pausa
        if (gp.GameState == gp.PauseState) {
            DrawPauseScreen();
        }
        
        //estado de dialogo
        if(gp.GameState == gp.dialogueState) {
        	drawDialogueScreen();
        }
    }

    public void DrawPauseScreen(){
        String text = "Pausa";

        int x = getXforCenterText(text);
        int y = gp.screenHeigth/2;

        g2.drawString(text, x, y);
    }
    
    public void drawDialogueScreen() {
    	
    	//ventana
    	int x = gp.tileSize*2;
    	int y = gp.tileSize/2;
    	int width = gp.screenWidth - (gp.tileSize*4);
    	int higth = gp.tileSize*4;
    	
    	drawSubWindow(x, y, width, higth);
    	
    	g2.setFont(g2.getFont().deriveFont(Font.PLAIN,28F));
    	x += gp.tileSize;
    	y += gp.tileSize;
    	
    	for(String line : currentDialogue.split("\n")) {
    		g2.drawString(line, x, y);
    		
    	}
    	g2.drawString(currentDialogue, x, y);
    }
    
    public void drawSubWindow(int x, int y, int width, int higth) {
    	
    	Color c = new Color(0,0,0,200);
    	g2.setColor(c);
    	g2.fillRoundRect(x, y, width, higth, 35, 35);
    	
    	c = new Color(255,255, 255);
    	g2.setColor(c);
    	g2.setStroke(new BasicStroke(5));
    	g2.drawRoundRect(x+5, y+5, width-10, higth-10, 25, 25);
    	
    	
    	
    	
    	
    }
    public int getXforCenterText(String text){
                int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}






