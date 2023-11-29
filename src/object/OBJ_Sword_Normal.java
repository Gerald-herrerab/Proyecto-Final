package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Sword_Normal extends Entity {

    public OBJ_Sword_Normal(GamePanel gp) {
        super(gp);

        type = type_sword;
        name = "Espada";
        down1 = setup("/res/objects/sword_normal", gp.tileSize, gp.tileSize);
        attackValue = 1;
        attackArea.width = 34;
        attackArea.height = 34;
        description = "[" + name + "]\nUna espada muy vieja.";
        price = 35;
        knockBackPower = 10;
    }

}
