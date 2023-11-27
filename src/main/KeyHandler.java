package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

    GamePanel gp;

    public boolean upPressed, downPressed, leftPressed, rigthpressed, enterPressed;
    //DEBUG
    boolean checkDrawTime = false;
    
    public KeyHandler (GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    	//estado del juego
        int code = e.getKeyCode(); 

        if(gp.GameState == gp.PlayState) {
        	
            if (code == KeyEvent.VK_W) {
                upPressed = true;

            }
            if (code == KeyEvent.VK_S) {
                downPressed = true;
                
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
                
            }
            if (code == KeyEvent.VK_D) {
                rigthpressed = true;
                
            }
            if (code == KeyEvent.VK_P) {
                gp.GameState = gp.PauseState;
            
            }
            if (code == KeyEvent.VK_ENTER) {
            	enterPressed = true;
            
            }
             
                    //DEBUG
            if (code == KeyEvent.VK_T) {
                if(checkDrawTime == false){
                    checkDrawTime = true;
                    }
            else if ( checkDrawTime == true) {
                        checkDrawTime = false;
                    }
            }
        }
        
        //estado de pausa
        else if(gp.GameState == gp.PauseState) {
            if (code == KeyEvent.VK_P) {
                gp.GameState = gp.PlayState;
            
            }
        }
        
        //estado del dialogo
        else if(gp.GameState == gp.dialogueState) {
        	if(code == KeyEvent.VK_ENTER) {
        		gp.GameState = gp.PlayState;
        	}
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        
        if (code == KeyEvent.VK_W) {
            upPressed = false;

        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
            
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
            
        }
        if (code == KeyEvent.VK_D) {
            rigthpressed = false;
            
        }

    }    
}

