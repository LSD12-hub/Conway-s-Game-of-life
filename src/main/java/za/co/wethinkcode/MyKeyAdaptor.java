package za.co.wethinkcode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdaptor extends KeyAdapter{

    private ConwayPanel conwayPanel;
    

    public MyKeyAdaptor(ConwayPanel conwayPanel){
        this.conwayPanel = conwayPanel;
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyChar() == ' ') {
            if(conwayPanel.getIsRunning()){
              conwayPanel.stopGame();
            }else{
              conwayPanel.startGame();
            }
        }
    }
}
