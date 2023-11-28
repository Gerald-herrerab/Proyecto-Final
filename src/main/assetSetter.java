package main;

import entidad.NPC_OldMan;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import object.OBJ_Boots;
import object.OBJ_Chest;
=======
import monster.MOM_GreenSlime;
>>>>>>> 0813235112290c37b567c6e989af2bf89029e20a
=======
import object.OBJ_Boots;
import object.OBJ_Chest;
>>>>>>> parent of 11d7c92 (update 21)
=======
import object.OBJ_Boots;
import object.OBJ_Chest;
>>>>>>> parent of 11d7c92 (update 21)
import object.OBJ_Door;
import object.OBJ_Key;

public class assetSetter {
	
	GamePanel gp;
	
	public assetSetter (GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
>>>>>>> 0813235112290c37b567c6e989af2bf89029e20a
=======
>>>>>>> parent of 11d7c92 (update 21)
=======
>>>>>>> parent of 11d7c92 (update 21)
		
	}
	
	public void setNPC() {
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======

//		gp.npc[0] = new NPC_OldMan(gp);
//		gp.npc[0].worldX = gp.tileSize*9;
//		gp.npc[0].worldY = gp.tileSize*10;
	}

	public void setMonster(){
		gp.monster[0] = new MOM_GreenSlime(gp);
		gp.monster[0].worldX = gp.tileSize*23;
		gp.monster[0].worldY = gp.tileSize*36;
		
		gp.monster[1] = new MOM_GreenSlime(gp);
		gp.monster[1].worldX = gp.tileSize*23;
		gp.monster[1].worldY = gp.tileSize*37;

//		gp.monster[0] = new MOM_GreenSlime(gp);
//		gp.monster[0].worldX = gp.tileSize*11;
//		gp.monster[0].worldY = gp.tileSize*10;
		
//		gp.monster[1] = new MOM_GreenSlime(gp);
//		gp.monster[1].worldX = gp.tileSize*11;
//		gp.monster[1].worldY = gp.tileSize*11;
>>>>>>> 0813235112290c37b567c6e989af2bf89029e20a
=======
>>>>>>> parent of 11d7c92 (update 21)
=======
>>>>>>> parent of 11d7c92 (update 21)
	}

}
