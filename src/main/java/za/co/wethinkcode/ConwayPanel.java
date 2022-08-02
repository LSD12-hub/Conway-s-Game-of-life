package za.co.wethinkcode;

import java.awt.Dimension;

import javax.swing.JPanel;

public class ConwayPanel extends JPanel{

    private final int WIDTH = 500, HEIGHT = 500;

    public ConwayPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

}
