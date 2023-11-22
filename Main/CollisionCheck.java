package Main;

import entidad.Entity;

public class CollisionCheck {
	
	GamePanel gp;
	
	public CollisionCheck(GamePanel gp) {
		
		this.gp = gp;
		
	}
	
	public void checkTile(Entity entidad) {
		
		int entidadLeftWorldX = entidad.worldX + entidad.solidArea.x;
		int entidadRightWorldX = entidad.worldX + entidad.solidArea.x + entidad.solidArea.width;
		int entidadTopWorldY = entidad.worldY + entidad.solidArea.y;
		int entidadBottonWorldY = entidad.worldY + entidad.solidArea.y + entidad.solidArea.height;
		
		int entidadLeftCol = entidadLeftWorldX/gp.tileSize;
		int entidadRightCol = entidadRightWorldX/gp.tileSize;
		int entidadTopRow = entidadTopWorldY/gp.tileSize;
		int entidadBottonRow = entidadBottonWorldY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entidad.direccion) {
		case "up":
			entidadTopRow = (entidadTopWorldY - entidad.speed)/gp.tileSize;
			tileNum1 =  gp.tileM.mapTileNum[entidadLeftCol][entidadTopRow];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadTopRow];	
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entidad.collisionOn = true;
				
			}
			break;
		case "down":
			entidadBottonRow = (entidadBottonWorldY + entidad.speed)/gp.tileSize;
			tileNum1 =  gp.tileM.mapTileNum[entidadLeftCol][entidadBottonRow];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadBottonRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entidad.collisionOn = true;
				
			}
			break;
		case "left":
			entidadLeftCol = (entidadLeftWorldX - entidad.speed)/gp.tileSize;
			tileNum1 =  gp.tileM.mapTileNum[entidadLeftCol][entidadTopRow];
			tileNum2 = gp.tileM.mapTileNum[entidadLeftCol][entidadBottonRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entidad.collisionOn = true;
				
			}
			break;
		case "rigth":
			entidadRightCol = (entidadRightWorldX + entidad.speed)/gp.tileSize;
			tileNum1 =  gp.tileM.mapTileNum[entidadRightCol][entidadTopRow];
			tileNum2 = gp.tileM.mapTileNum[entidadRightCol][entidadBottonRow];
			if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
				entidad.collisionOn = true;
				
			}
			break; 
			
		}
		
		
	} 

}
