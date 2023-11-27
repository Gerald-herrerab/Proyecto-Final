package main;

import entidad.NPC_OldMan;
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class assetSetter {
	
	GamePanel gp;
	
	public assetSetter (GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
		
	}
	
	public void setNPC() {
		
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
	}

}
