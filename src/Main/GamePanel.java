package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entidad.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
	
    // Ajustes de la pantalla
    final int originalTileSize = 16;  // 16x16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeigth = tileSize * maxScreenRow;
    
    // Ajustes del mundo 
    
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50; 
    public final int worldHeigth = tileSize * maxWorldCol;
    public final int worldWidth = tileSize * maxWorldRow;
    
    
    int FPS = 60;

    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionCheck coCheck = new CollisionCheck(this);
    public assetSetter aSetter = new assetSetter(this);
    public Player player = new Player (this, keyH);
    public SuperObject obj[] = new SuperObject[10];
    
    
    


    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }
    
    public void setupGame () {
    	aSetter.setObject();
    }

    public void startGameThread () {

        gameThread = new Thread(this);
        gameThread.start();

    }


    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;


        while (gameThread != null) {



            update();


            repaint();



            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0) {
                    remainingTime = 0;

                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
        
    }

    public void update () {

        player.update();

    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //TILE
        tileM.draw(g2);
        
        //OBJECTS
        for(int i = 0; i < obj.length; i++) {
        	if(obj[i] != null) {
        		obj[i].draw(g2, this);
        	}
        }
        
        
        //PLAYER
        player.draw(g2);

        g2.dispose();
}



}