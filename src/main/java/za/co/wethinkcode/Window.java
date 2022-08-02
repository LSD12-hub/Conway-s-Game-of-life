package za.co.wethinkcode;

import javax.swing.JFrame;

public class Window extends JFrame{

    public Window() {
        this.add(new ConwayPanel());
        this.setTitle("BFS Visualisation");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
