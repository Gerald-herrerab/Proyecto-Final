package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler KeyH;
    public final int screenX;
    public final int screenY;
    public int hasKey = 0;
    

    public Player (GamePanel gp, KeyHandler KeyH) {

        this.gp = gp;
        this.KeyH = KeyH;
        
        screenX = gp.screenWidth/2;
        screenY = gp.screenHeigth/2;
        
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        
        
        setDefaultValues();
        getPlayerImage();

    }

    //posicin del jugadr en el mapa
    public void setDefaultValues () {

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direccion = "down";


    }

    public void getPlayerImage() {

        up1 = setup("boy_up_1");
        up2 = setup("boy_up_2");
        down1 = setup("boy_down_1");
        down2 = setup("boy_down_2");
        left1 = setup("boy_left_1");    
        left2 = setup("boy_left_2");    
        right1 = setup("boy_right_1");
        right2 = setup("boy_right_2");

    }
    public BufferedImage setup (String imageName){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/player/"+ imageName +".png"));
            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }



    public void update() {
    	
    	if(KeyH.upPressed == true || KeyH.downPressed == true || KeyH.leftPressed || KeyH.rigthpressed == true) {
    		
            if(KeyH.upPressed == true) {
                direccion = "up";
            }

            else if(KeyH.downPressed == true) {
                direccion = "down";
            }

            else if(KeyH.leftPressed == true) {
                direccion = "left";
            }

            else if(KeyH.rigthpressed == true) {
                direccion = "rigth";
            }
            
            //comprobador de colicion
            
            collisionOn = false;
            gp.coCheck.checkTile(this);
            
            //comprobar la colicion del objecto
            
            int objIndex = gp.coCheck.checkObjects(this, true);
            pickUpObject(objIndex);
            
            
            
            
            //si la colicion es falsa el jugador puede moverse
            
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
//		else { 
//			counter++;
//				if(counter2 == 20) {
//  				spriteNum = 1;
//					couenter2 = 1;
//				}
//			}
    } 
    
    public void pickUpObject(int i) {
    	
    	if(i != 999) {
    		
    		String objectName = gp.obj[i].name;
    		switch(objectName) {
    		case "Key":
    			gp.playSE(1);
    			hasKey++;
    			gp.obj[i] = null;
    			gp.ui.showMessage("conseguiste una llave ");
    			break;
    		case "Door":
    			gp.playSE(3);
    			if(hasKey > 0) {
    				gp.obj[i] = null;
    				hasKey--;
        			gp.ui.showMessage("has abierto una puerta ");
    			}
    			else {
        			gp.ui.showMessage("necesitas una llave");
    			}
    			break;
    		case "Boots":
    			gp.playSE(2);
    			speed += 2;
    			gp.obj[i] = null;
    			gp.ui.showMessage("conseguiste un articulo buff");
    			break;
    		case "Chest":
    			gp.ui.gameFinish = true;
    			gp.stopMusic();
    			gp.playSE(4);
    			break;
    			
    		}
    	}
    	
    }
    	
    	
    public void draw (Graphics2D g2) {

      BufferedImage image = null;

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

      g2.drawImage(image, screenX, screenY, null);


    }
    
}
