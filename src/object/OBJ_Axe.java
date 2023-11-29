package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Axe extends Entity {

    public OBJ_Axe(GamePanel gp) {
        super(gp);

        type = type_axe;
        name = "Woodcutter's Axe";
        down1 = setup("/res/objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[Hacha del leñador]\\n" + //
                "Un poco oxidada pero aún puede \\n" + //
                "cortar algunos árboles.";
        price = 65;
        knockBackPower = 5;
    }
}
