package entidad;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class Entity {

	GamePanel gp;
    public int worldX, worldY;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direccion;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter = 0;
    
    public Entity(GamePanel gp) {
    	this.gp = gp;
    	
    }
    
    public void setAction() {}
    public void update() {
    	
    	setAction();
    	
    	collisionOn = false;
    	gp.coCheck.checkTile(this);
    	gp.coCheck.checkObjects(this, false);
    	gp.coCheck.checkPlayer(this);
    	
        if(collisionOn == false) {
        	
    		switch(direccion) {
    		case "up": worldY -= speed; break;
    		case "down": worldY += speed; break;
    		case "left": worldX -= speed; break;
    		case "rigth": worldX += speed; break;
        }
    }
    		
        
        spriteCounter++;
        if(spriteCounter > 15) {
        	if(spriteNum == 1) {
        		spriteNum = 2; 
        	}
        	else if (spriteNum == 2) {
        		spriteNum = 1;
        	}
        	
        	spriteCounter = 0;
		
        }
    }
    public void draw(Graphics2D g2) {
    	
        BufferedImage image = null;
    	
		int screenX = worldX - gp.player.worldX + gp.player.screenX;
		int screenY = worldY - gp.player.worldY + gp.player.screenY;
		
		//genera automaticamente solo las valdosas que estan en la vision del jugador y al mismo tiempo quita las que ya 
		// no se ven por el movimiento del jugador 
		if( worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
			worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
			worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
			worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
			
		      switch (direccion) {
		      case "up":
		    	  if(spriteNum == 1) {
		              image = up1; 
		    	  }
		    	  if(spriteNum == 2) {
		              image = up2; 
		    	  }
		          break;
		      case "down":
		    	  if(spriteNum == 1) {
		              image = down1; 
		    	  }
		    	  if(spriteNum == 2) {
		              image = down2; 
		    	  }
		          break;
		      case "left":
		    	  if(spriteNum == 1) {
		              image = left1; 
		    	  }
		    	  if(spriteNum == 2) {
		              image = left2; 
		    	  }
		          break;
		      case "rigth":
		    	  if(spriteNum == 1) {
		              image = right1; 
		    	  }
		    	  if(spriteNum == 2) {
		              image = right2; 
		    	  }
		          break;
		      }
			
			g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
				
		}
    }
    
    public BufferedImage setup (String imagePath){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream(imagePath +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }
    
    

}
 