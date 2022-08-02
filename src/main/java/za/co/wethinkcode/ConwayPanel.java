package za.co.wethinkcode;

import java.awt.Dimension;

import javax.swing.JPanel;

public class ConwayPanel extends JPanel{

    static final int WIDTH = 500, HEIGHT = 500;
    static final int ROWS = 20, COLS = 20;


    public ConwayPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

}
