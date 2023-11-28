package main;

import java.awt.Rectangle;

public class EventHandler {
	
	GamePanel gp;
	Rectangle eventRect;
	int eventRectDefaultX, eventRectDefaultY;
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		
		eventRect = new Rectangle();
		eventRect.x = 23;
		eventRect.y = 23;
		eventRect.width = 2;
		eventRect.height = 2;
		eventRectDefaultX = eventRect.x;
		eventRectDefaultY = eventRect.y;
	}
	
	public void checkEvent() {
		
		if(hit(27,16,"rigth") == true) {damagePit(gp.dialogueState);}
		if(hit(23,12,"up") == true) {healingPool(gp.dialogueState);}
		
		
	}
	public boolean hit(int eventCol, int eventRow, String reqDirection) {
		
		boolean hit = false;
		
		gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
		gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
		eventRect.x = eventCol*gp.tileSize + eventRect.x;
		eventRect.y = eventRow*gp.tileSize + eventRect.y;
		
		if(gp.player.solidArea.intersects(eventRect)) {
			if(gp.player.direccion.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {                                      
				hit = true;
			}
		}
		
		gp.player.solidArea.x = gp.player.solidAreaDefaultX;
		gp.player.solidArea.y = gp.player.solidAreaDefaultY;
		eventRect.x = eventRectDefaultX;
		eventRect.y = eventRectDefaultY;
		
		
		return hit;
	}
	
	public void damagePit(int GameState) {
		
		gp.GameState = GameState;
		gp.ui.currentDialogue = "caiste en un poso";
		gp.player.life -= 1;
		
		}
	
	public void healingPool(int GameState) {
		
		if(gp.keyH.enterPressed == true) {
			gp.GameState = GameState;
			gp.ui.currentDialogue = "bebiste agua. \ntu vida se a recuperado";
			gp.player.life = gp.player.maxLife;
		}
		
		gp.keyH.enterPressed = false;
	}
	

}















