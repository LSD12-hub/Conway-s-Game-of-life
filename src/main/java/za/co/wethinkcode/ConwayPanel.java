package za.co.wethinkcode;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ConwayPanel extends JPanel implements ActionListener{

    static final int WIDTH = 500, HEIGHT = 500;
    static final int ROWS = 20, COLS = 20;

    private final int DELAY = 100;

    private Cell [][] grid;

    private boolean isRunning = false;

    private Timer timer;

    public ConwayPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.MAGENTA);
        this.setFocusable(true);

        grid = new Cell[ROWS][COLS];

        startGame();
        createGrid();

        grid[5][5].setIsAlive(1);
        grid[6][6].setIsAlive(1);
        grid[6][7].setIsAlive(1);
        grid[7][6].setIsAlive(1);
        grid[5][7].setIsAlive(1);
    }


    private void createGrid() {
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                grid[j][i] = new Cell(j, i);
            }
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[j][i].draw_cell(g, Color.GREEN);
            }
        }
    }


    public void stopGame(){
        isRunning = false;
        timer.stop();
    }


    public void startGame(){
        isRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        

        repaint();
    }
}
