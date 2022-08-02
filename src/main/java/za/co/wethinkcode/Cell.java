package za.co.wethinkcode;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {

    private int pos_x, pos_y;    

    private int w = ConwayPanel.WIDTH / ConwayPanel.COLS;
    private int h = ConwayPanel.HEIGHT / ConwayPanel.ROWS;

    private int isAlive;

    public Cell(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        isAlive = 0;
    }

    public void draw_cell(Graphics g, Color c){
        if (isAlive == 1) {
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

    public int getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(int isAlive) {
        this.isAlive = isAlive;
    }
}
