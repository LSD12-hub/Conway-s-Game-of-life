package za.co.wethinkcode;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int pos_x, pos_y;    

    private int w = ConwayPanel.WIDTH / ConwayPanel.COLS;
    private int h = ConwayPanel.HEIGHT / ConwayPanel.ROWS;

    private boolean isAlive;

    private List<Cell> neighbours;

    public Cell(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        isAlive = false;
        neighbours = new ArrayList<>();
    }

    public void draw_cell(Graphics g, Color c){
        if (isAlive) {
            g.setColor(c);
            g.fillRect(pos_x * w, pos_y * h, w, h);
            g.setColor(Color.black);
            g.drawRect(pos_x * w, pos_y * h, w, h);
        } else { 
            g.setColor(Color.white);
            g.fillRect(pos_x * w, pos_y * h, w, h);
            g.setColor(Color.black);
            g.drawRect(pos_x * w, pos_y * h, w, h);
        }
    }    

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public List<Cell> getNeighbours() {
        return neighbours;
    }

    public void addNeighour(Cell c) {
        if (c.getIsAlive()) 
            neighbours.add(c);
    }

    @Override
    public String toString() {
        return pos_y + " " + pos_x + " " + isAlive;
    }
}
