package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16;  // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeigth = tileSize * maxScreenRow; 

    Thread gameThread;


    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);


    }

    public void startGameThread () {

        gameThread = new Thread(this);
        gameThread.start();


    }


    @Override
    public void run() {
        
    }



    
}
