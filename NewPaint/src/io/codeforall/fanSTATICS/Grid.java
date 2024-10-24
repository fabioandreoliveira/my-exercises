package io.codeforall.fanSTATICS;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
public class Grid {

    int cellSize = 20;
    int PADDING = 10;

    public Grid() {
        drawGrid();
    }
    private void drawGrid() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                Rectangle cell = new Rectangle(i * cellSize + PADDING, j * cellSize + PADDING, cellSize, cellSize);
                cell.setColor(Color.BLACK);
                cell.draw();

            }
        }
    }
}
