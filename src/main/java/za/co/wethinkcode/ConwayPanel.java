package za.co.wethinkcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class ConwayPanel extends JPanel implements ActionListener{

    static final int WIDTH = 500, HEIGHT = 500;
    static final int ROWS = 5, COLS = 5;

    private final int DELAY = 300;

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
        
        grid[2][2].setIsAlive(true);
        grid[2][1].setIsAlive(true);
        grid[2][3].setIsAlive(true);
        // grid[3][2].setIsAlive(true);
        // grid[1][2].setIsAlive(true);
        
        addNeighbours();

        for (Cell c : grid[2][2].getNeighbours()) {
            System.out.println(c);
        }
    }


    private void addNeighbours() {
        for(int i = 0; i < COLS; i++){
            for(int j = 0; j < ROWS; j++){
                
                // adjecent
                if(i > 0)
                    grid[i][j].addNeighour(grid[i - 1][j]);
                if(j < grid.length - 1)
                    grid[i][j].addNeighour(grid[i][j + 1]);
                if(i < grid.length - 1)
                    grid[i][j].addNeighour(grid[i + 1][j]);
                if(j > 0)
                    grid[i][j].addNeighour(grid[i][j - 1]);
             
                // diagonals
                if (i > 0 && j > 0)
                    grid[i][j].addNeighour(grid[i - 1][j - 1]);
                if (i > 0 && j < grid.length - 1)
                    grid[i][j].addNeighour(grid[i - 1][j + 1]);
                if (i < grid.length - 1 && j < grid.length - 1)
                    grid[i][j].addNeighour(grid[i + 1][j + 1]);
                if (i < grid.length - 1 && j > 0)
                    grid[i][j].addNeighour(grid[i + 1][j - 1]);
            }
        }
    }


    private void createGrid() {
        for (int i = 0; i < COLS; i++) {
            for (int j = 0; j < ROWS; j++) {
                grid[i][j] = new Cell(j, i);
            }
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].draw_cell(g, Color.GREEN);
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


    private void updateGrid() {
        Cell[][] updatedGrid = new Cell[COLS][ROWS];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].getIsAlive()) {
                    updatedGrid[i][j] = liveCell(grid[i][j], i, j);
                } else {
                    updatedGrid[i][j] = deadCell(grid[i][j], i, j); 
                }
            }
        }

        grid = updatedGrid;
        addNeighbours();
    }


    private Cell deadCell(Cell c, int i, int j) {
        if (c.getNeighbours().size() == 3) {    
            Cell newCell = new Cell(j, i);
            newCell.setIsAlive(true);
            return newCell;
        }

        return new Cell(j, i);
    }


    private Cell liveCell(Cell c, int i, int j) {
        Cell newCell = new Cell(j, i);

        if (c.getNeighbours().size() < 2) {
            newCell.setIsAlive(false);
            return newCell;
        }

        if (c.getNeighbours().size() == 2 || c.getNeighbours().size() == 3) {
            return newCell;
        }

        if (c.getNeighbours().size() > 3) {
            newCell.setIsAlive(false);
            return newCell;
        }
        
        return newCell;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        updateGrid();

        repaint();
    }
}
