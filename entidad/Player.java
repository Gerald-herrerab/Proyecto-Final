package entidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Key;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler KeyH;

    public Player (GamePanel gp, KeyHandler KeyH) {

        this.gp = gp;
        this.KeyH = KeyH;
        
        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues () {

        x = 100;
        y = 100;
        speed = 4;
        direccion = "down";


    }

    public void getPlayerImage() {

        try {

            up2 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader() .getResourceAsStream("player/boy_down_2.png"));
            left1 = ImageIO.read(getClass() .getClassLoader().getResourceAsStream("player/boy_left_1.png"));
            left2 = ImageIO.read(getClass() .getClassLoader().getResourceAsStream("player/boy_left_2.png"));
            rigth1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_1.png"));
            rigth2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/boy_right_2.png"));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update () {

        if(KeyH.upPressed == true) {
            direccion = "up";
            y -= speed;

        }

        else if(KeyH.downPressed == true) {
            direccion = "down";
            y += speed;

        }

        else if(KeyH.leftPressed == true) {
            direccion = "left";
            x -= speed;

        }

        else if(KeyH.rigthpressed == true) {
            direccion = "rigth";
            x += speed;
        
        }

    }

    public void draw (Graphics2D g2) {

       //g2.setColor(Color.white);
       //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

      BufferedImage image = null;

      switch (direccion) {
      case "up":
          image = up1;
          break;
      case "down":
          image = down1;
          break;
      case "left":
          image = left1;
          break;
      case "rigth":
          image = rigth1;
          break;
      }

      g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,  null);


    }
    
}
