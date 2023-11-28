package object;

<<<<<<< HEAD
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class OBJ_Boots extends SuperObject {
	
	GamePanel gp;

	public OBJ_Boots (GamePanel gp) {

		this.gp = gp;

		name = "Boots";
		try {
			
			image = ImageIO.read(getClass().getResourceAsStream("/objects/boots.png"));
			
			uTool.scaleImage(image, gp.tileSize, gp.tileSize);

		}catch (IOException e) {
			e.printStackTrace();
			
		}
=======
import entidad.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity {
	

	public OBJ_Boots (GamePanel gp) {
		
		super(gp);

		name = "Boots";
		down1 = setup("/objects/boots");
>>>>>>> Benjamín-Cantero
		
	}

}
