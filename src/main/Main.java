package main;

import javax.swing.JFrame;

public class Main {

public static void main(String [] arg){
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    window.setResizable(false) ;
    window.setTitle("las locas aventuras de juan maziso") ;

    GamePanel gamePanel = new GamePanel(gp);
    window.add(gamePanel);

    window.pack();


    window.setLocationRelativeTo(null) ; 
    window.setVisible(true) ;

    gamePanel.setupGame();
    gamePanel.startGameThread();
    

    }
}