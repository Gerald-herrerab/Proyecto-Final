package object;

import main.GamePanel;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Heart extends SuperObject {

    		GamePanel gp;

	public OBJ_Heart (GamePanel gp) {

		this.gp = gp;

		name = "Heart";

		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/heart_blank.png"));
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);
            uTool.scaleImage(image2, gp.tileSize, gp.tileSize);
            uTool.scaleImage(image3, gp.tileSize, gp.tileSize);

		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
}
