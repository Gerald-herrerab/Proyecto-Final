package entidad;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

import javax.imageio.ImageIO;
import javax.xml.namespace.QName;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {

    KeyHandler KeyH;
    public final int screenX;
    public final int screenY;
    int standCounter = 0;
    

    public Player (GamePanel gp, KeyHandler KeyH) {
    	
    	super(gp);
    	
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
        getPlayerAttackImage();

    }

    //posicin del jugadr en el mapa
    public void setDefaultValues () {

       worldX = gp.tileSize * 23;
       worldY = gp.tileSize * 21;

 //       worldX = gp.tileSize * 10;
 //       worldY = gp.tileSize * 13;

        speed = 6;
        direccion = "down";
        
        //Player Status
        maxLife = 6;
        life = maxLife;


    }

    public void getPlayerImage() {

        up1 = setup("/player/boy_up_1", gp.tileSize,gp.tileSize);
        up2 = setup("/player/boy_up_2", gp.tileSize,gp.tileSize);
        down1 = setup("/player/boy_down_1", gp.tileSize,gp.tileSize);
        down2 = setup("/player/boy_down_2", gp.tileSize,gp.tileSize);
        left1 = setup("/player/boy_left_1", gp.tileSize,gp.tileSize);    
        left2 = setup("/player/boy_left_2", gp.tileSize,gp.tileSize);    
        right1 = setup("/player/boy_right_1", gp.tileSize,gp.tileSize);
        right2 = setup("/player/aboy_right_2", gp.tileSize,gp.tileSize);

    }

    public void getPlayerAttackImage() {
        attackUp1 = setup("/player/boy_attack_up_1", gp.tileSize,gp.tileSize*2);
        attackUp2 = setup("/player/boy_attack_up_2", gp.tileSize,gp.tileSize*2);
        attackDown1 = setup("/player/boy_attack_down_1", gp.tileSize,gp.tileSize*2);
        attackDown2 = setup("/player/boy_attack_down_2", gp.tileSize,gp.tileSize*2);
        attackLeft1 = setup("/player/boy_attack_left_1", gp.tileSize*2,gp.tileSize*2);
        attackLeft2 = setup("/player/boy_attack_left_2", gp.tileSize*2,gp.tileSize*2);
        attackRigth1 = setup("/player/boy_attack_right_1", gp.tileSize*2,gp.tileSize*2);
        attackRigth2 = setup("/player/boy_attack_right_2", gp.tileSize*2,gp.tileSize*2);

    }


    public void update() {

        if(attacKing == true) {
            attacKing();

        }
    	
        else if(KeyH.upPressed == true || KeyH.downPressed == true || KeyH.leftPressed || KeyH.rigthpressed == true || KeyH.enterPressed == true) {
    		
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
                direccion = "right";
            }
            
            //comprobador de colicion
            
            collisionOn = false;
            gp.coCheck.checkTile(this);
            
            //comprobar la colicion del objecto
            
            int objIndex = gp.coCheck.checkObjects(this, true);
            pickUpObject(objIndex);
            
            //check NPC colicion
            int npcIndex = gp.coCheck.checkEntity(this, gp.npc);
            interactNPC(npcIndex);
            
             // COMPROBAR COLISION DEL MOSTER
             int monsterIndex = gp.coCheck.checkEntity(this, gp.monster);
             contactMonster(monsterIndex);
        

            //Check event
            gp.eHandler.checkEvent();
            
            
            
            //si la colicion es falsa el jugador puede moverse
            
            if(collisionOn == false && KeyH.enterPressed == false) {
            	
        		switch(direccion) {
        		case "up": worldY -= speed; break;
        		case "down": worldY += speed; break;
        		case "left": worldX -= speed; break;
        		case "rigth": worldX += speed; break;
            }
        }

            gp.keyH.enterPressed = false;
        		
            
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
            else { 
			standCounter++;
				if(standCounter == 20) {
  				spriteNum = 1;
					standCounter = 0;
				}

			}

        }   	
            //  ESTO DEBE ESTAR FUERA DE LA DECLARACION IF 
                if (invicible == true) {
                    invicibleCounter ++;
                    if (invicibleCounter > 60) {
                        invicible = false;
                        invicibleCounter = 0;
                    } 
                }
    } 
    public void attacKing() {

        spriteCounter++;

        if(spriteCounter <= 5) {
            spriteNum = 1;
        }
        if(spriteCounter > 5 && spriteCounter <= 25) {
            spriteNum = 2;
        }
        if(spriteCounter > 25 ) {
            spriteNum = 1;
            spriteCounter = 0;
            attacKing = false;
        }
    }
    public void pickUpObject(int i) {
    	if (i  != 999) {
            
        }
    }
    
    public void interactNPC(int i) {

        if(gp.keyH.enterPressed == true) {

            if (i  != 999) {
    		    gp.GameState = gp.dialogueState;
        		gp.npc[i].speak();
    		}
        
        else {
            attacKing = true;
            }
        }
    }
    	
    public void contactMonster(int i){
        if (i != 999) {

            if (invicible == false) {
             life -= 1;  
             invicible = true;
             
            }
            
        }
    }
    
    public void draw (Graphics2D g2) {

      BufferedImage image = null;

      switch (direccion) {
        case "up":
        if(attacKing == false) {
            if(spriteNum == 1) {image = up1; }
            if(spriteNum == 2) {image = up2; }
        }

        if(attacKing == true) {
            if(spriteNum == 1) {image = attackUp1; }
            if(spriteNum == 2) {image = attackUp2; }
    }
          break;
      case "down":
        if(attacKing == false) {
            if(spriteNum == 1) {image = down1; }
            if(spriteNum == 2) {image = down2; }
        }

        if(attacKing == true) {
            if(spriteNum == 1) {image = attackDown1; }
            if(spriteNum == 2) {image = attackDown2; }
    }
          break;
      case "left":
        if(attacKing == false) {
            if(spriteNum == 1) {image = left1; }
            if(spriteNum == 2) {image = left2; }
        }

        if(attacKing == true) {
            if(spriteNum == 1) {image = attackLeft1; }
            if(spriteNum == 2) {image = attackLeft2; }
    }
          break;
      case "rigth":
        if(attacKing == false) {
            if(spriteNum == 1) {image = right1; }
            if(spriteNum == 2) {image = right2; }
        }

        if(attacKing == true) {
            if(spriteNum == 1) {image = attackRigth1; }
            if(spriteNum == 2) {image = attackRigth2; }
    }
          break;
      }
      if (invicible == true) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
      }
      g2.drawImage(image, screenX, screenY, null);
      
//RESET ALPHA
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
      //DEBUG
//      g2.setFont(new Font("Arial", Font.PLAIN, 26) );
//      g2.setColor(Color.white);
//      g2.drawString("invicible; "+invicibleCounter, 10, 400);
    }
    
}
