package object;

import entidad.Entity;
import main.GamePanel;

public class OBJ_Boots extends Entity {
	

	public OBJ_Boots (GamePanel gp) {
		
		super(gp);

		name = "Boots";
		down1 = setup("/objects/boots", gp.tileSize,gp.tileSize);
		
	}

}
