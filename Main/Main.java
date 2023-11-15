package Main;

import javax.swing.JFrame;

public class Main {

public static void main(String [] arg){
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    window.setResizable(false) ;
    window.setTitle("2D Adventure") ;

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();


    window.setLocationRelativeTo(null) ;
    window.setVisible(true) ;
<<<<<<< HEAD

    gamePanel.startGameThread();
=======
>>>>>>> d5638840c9a913d3ee1c3eb1122086e5378f0e73
    

    }
}