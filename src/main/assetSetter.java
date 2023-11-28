package main;

import entidad.NPC_OldMan;
<<<<<<< HEAD
import object.OBJ_Boots;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
=======
import monster.MOM_GreenSlime;
import object.OBJ_Door;
>>>>>>> Benjamín-Cantero

public class assetSetter {
	
	GamePanel gp;
	
	public assetSetter (GamePanel gp) {
		this.gp = gp;
		
	}
	
	public void setObject() {
<<<<<<< HEAD
=======
	
>>>>>>> Benjamín-Cantero
		
	}
	
	public void setNPC() {
<<<<<<< HEAD
		
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;
=======
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].worldX = gp.tileSize*21;
		gp.npc[0].worldY = gp.tileSize*21;

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
>>>>>>> Benjamín-Cantero
	}

}
