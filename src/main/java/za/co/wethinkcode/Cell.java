package za.co.wethinkcode;

import java.awt.Color;
import java.awt.Graphics;

public class Cell {

    private int pos_x, pos_y;    

    int w = ConwayPanel.WIDTH / ConwayPanel.COLS, h = ConwayPanel.HEIGHT / ConwayPanel.ROWS;

    public Cell(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }

    public void draw_cell(Graphics g, Color c){
        g.setColor(c);
        g.fillRect(pos_x * w, pos_y * h, w, h);
        g.setColor(Color.black);
        g.drawRect(pos_x * w, pos_y * h, w, h);
    }    
}
