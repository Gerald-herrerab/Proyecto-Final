package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity {
    GamePanel gp;

    public OBJ_Potion_Red(GamePanel gp) {
        super(gp);

        this.gp = gp;

        type = type_consumable;
        name = "Red Potion";
        value = 5;
        down1 = setup("/res/objects/potion_red", gp.tileSize, gp.tileSize);
        description = "[Poción Roja]\\n" + //
                "Cura tu vida en " + value + ".";
        price = 25;
    }

    public void use(Entity entity) {
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "Tomas la " + name + "!\n" + "Tu vida ha sido recuperada en " + value + ".";
        entity.life += value;
        gp.playSE(2);
    }
}
