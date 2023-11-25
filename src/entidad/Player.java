package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler KeyH;
    public final int screenX;
    public final int screenY;
    int hasKey = 0;
    

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
        speed = 10;
        direccion = "down";


    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_down_2.png"));
            left1 = ImageIO.read(getClass() .getClassLoader().getResourceAsStream("player/boy_left_1.png"));
            left2 = ImageIO.read(getClass() .getClassLoader().getResourceAsStream("player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png"));


        }catch(IOException e) {
            e.printStackTrace();
        }
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
    			hasKey++;
    			gp.obj[i] = null;
    			System.out.println("Key:"+hasKey);
    			break;
    		case "Door":
    			if(hasKey > 0) {
    				gp.obj[i] = null;
    				hasKey--;
    			}
    			System.out.println("Key:"+hasKey);
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

      g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize,  null);


}

}