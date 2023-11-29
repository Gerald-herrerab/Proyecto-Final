package main;

import animales.MON_Ciervo;
import animales.MON_Cocodrilo;
import animales.MON_Conejo;
import animales.MON_Cuervo;
import animales.MON_Elefante;
import animales.MON_GreenSlime;
import animales.MON_Leon;
import animales.MON_Pez;
import animales.MON_Tiburon;
import animales.MON_Tigre;
import entity.NPC_Merchant;
import entity.NPC_OldMan;
import object.OBJ_Axe;
import object.OBJ_Coin_Bronze;
import object.OBJ_Door;
import object.OBJ_Heart;
import object.OBJ_Key;
import object.OBJ_ManaCrystal;
import object.OBJ_Potion_Red;
import object.OBJ_Shield_Blue;
import tile_interactive.IT_DryTree;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        int mapNum = 0;
        int i = 0;

        gp.obj[mapNum][i] = new OBJ_Axe(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 33;
        gp.obj[mapNum][i].worldY = gp.tileSize * 21;
        i++;

        gp.obj[mapNum][i] = new OBJ_Shield_Blue(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 37;
        gp.obj[mapNum][i].worldY = gp.tileSize * 21;
        i++;

        gp.obj[mapNum][i] = new OBJ_Potion_Red(gp);
        gp.obj[mapNum][i].worldX = gp.tileSize * 31;
        gp.obj[mapNum][i].worldY = gp.tileSize * 12;
        i++;
    }

    public void setNPC() {


    }

    public void setMonster() {
        int mapNum = 0;

        int i = 0;
        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 21;
        gp.monster[mapNum][i].worldY = gp.tileSize * 36;
        i++;

        gp.monster[mapNum][i] = new MON_GreenSlime(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 22;
        gp.monster[mapNum][i].worldY = gp.tileSize * 37;
        i++;

        gp.monster[mapNum][i] = new MON_Leon(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 23;
        gp.monster[mapNum][i].worldY = gp.tileSize * 37;
        i++;

        gp.monster[mapNum][i] = new MON_Leon(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 24;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;
        i++;

        gp.monster[mapNum][i] = new MON_Ciervo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 25;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;
        i++;

        gp.monster[mapNum][i] = new MON_Ciervo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 26;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;

        gp.monster[mapNum][i] = new MON_Cocodrilo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 27;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;

        gp.monster[mapNum][i] = new MON_Cocodrilo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 28;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;

        gp.monster[mapNum][i] = new MON_Tiburon(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 29;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;

        gp.monster[mapNum][i] = new MON_Tiburon(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 25;
        gp.monster[mapNum][i].worldY = gp.tileSize * 40;

        gp.monster[mapNum][i] = new MON_Pez(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 26;
        gp.monster[mapNum][i].worldY = gp.tileSize * 41;

        gp.monster[mapNum][i] = new MON_Pez(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 26;
        gp.monster[mapNum][i].worldY = gp.tileSize * 42;

        gp.monster[mapNum][i] = new MON_Elefante(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 27;
        gp.monster[mapNum][i].worldY = gp.tileSize * 40;

        gp.monster[mapNum][i] = new MON_Elefante(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 28;
        gp.monster[mapNum][i].worldY = gp.tileSize * 40;

        gp.monster[mapNum][i] = new MON_Conejo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 30;
        gp.monster[mapNum][i].worldY = gp.tileSize * 41;

        gp.monster[mapNum][i] = new MON_Conejo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 21;
        gp.monster[mapNum][i].worldY = gp.tileSize * 41;

        gp.monster[mapNum][i] = new MON_Tigre(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 31;
        gp.monster[mapNum][i].worldY = gp.tileSize * 41;

        gp.monster[mapNum][i] = new MON_Tigre(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 32;
        gp.monster[mapNum][i].worldY = gp.tileSize * 41;

        gp.monster[mapNum][i] = new MON_Cuervo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 19;
        gp.monster[mapNum][i].worldY = gp.tileSize * 21;

        gp.monster[mapNum][i] = new MON_Cuervo(gp);
        gp.monster[mapNum][i].worldX = gp.tileSize * 18;
        gp.monster[mapNum][i].worldY = gp.tileSize * 21;

    }

    public void setInteractiveTile() {
        int mapNum = 0;

        int i = 0;

        gp.iTile[mapNum][i] = new IT_DryTree(gp, 27, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 28, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 29, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 30, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 32, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 33, 12);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 18, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 17, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 16, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 15, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 14, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 13, 40);
        i++;
        gp.iTile[mapNum][i] = new IT_DryTree(gp, 12, 40);
        i++;
    }
}
