package za.co.wethinkcode;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

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

        if (e.getKeyChar() == 'c') {
            for (int i = 0; i < ConwayPanel.ROWS; i++) {
                for (int j = 0; j < ConwayPanel.COLS; j++) {      
                    conwayPanel.getGrid()[i][j].setIsAlive(false);
                }
            }                        
            conwayPanel.repaint();
        }

        if (e.getKeyChar() == 'r') {
            conwayPanel.populateGrid();
            conwayPanel.repaint();
        }

        if (e.getKeyChar() == 'q') {
            System.exit(0);
        }

        if (e.getKeyChar() == 'h') {
            JOptionPane.showMessageDialog(null, "SPACE BAR - pause and play simulation\n" + 
                                    "C - to clear the screen\n"+
                                    "R - reset or populate the world\n"+
                                    "Q - to exit the program");
        }
    }
}
