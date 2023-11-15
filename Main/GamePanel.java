package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTileSize = 16;  // 16x16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale; //48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; //758 pixeles
    final int screenHeigth = tileSize * maxScreenRow; //576 pixeles

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //establecer la posición predeterminada del jugador
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;




    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeigth));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void startGameThread () {

        gameThread = new Thread(this);
        gameThread.start();


    }


    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.0166666 segundos
        double nextDrawTime = System.nanoTime() + drawInterval;


        while (gameThread != null) {



            // actualizar la informacion como la posicion del personaje
            update();


            // dibuja la pantalla con la informacion de cada actualizacion 
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
        if(keyH.upPressed == true) {
            playerY -= playerSpeed;

        }

        else if(keyH.downPressed == true) {
            playerY += playerSpeed;

        }

        else if(keyH.leftPressed == true) {
            playerX -= playerSpeed;

        }

        else if(keyH.rigthpressed == true) {
            playerX += playerSpeed;
        
        }


    }

    public void paintComponent (Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }



    
}
