package object;

import java.io.IOException;

import javax.imageio.ImageIO;

<<<<<<< HEAD
import main.GamePanel;

public class OBJ_Chest extends SuperObject{

	GamePanel gp;

	public OBJ_Chest (GamePanel gp) {

		this.gp = gp;

		name = "Chest";
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));

				uTool.scaleImage(image, gp.tileSize, gp.tileSize);

		}catch (IOException e) {
			e.printStackTrace();
			
		}
=======
import entidad.Entity;
import main.GamePanel;

public class OBJ_Chest extends Entity{

	public OBJ_Chest (GamePanel gp) {
		
		super(gp);


		name = "Chest";
		down1 = setup("/objects/chest");
>>>>>>> Benjamín-Cantero
		
	}

}
