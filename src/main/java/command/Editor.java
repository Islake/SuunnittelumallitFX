package command;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Editor {
    private static final int GRID_SIZE = 8;
    private static final int CELL_SIZE = 32;
    private boolean[][] grid;
    private int cursorX;
    private int cursorY;
    private Canvas canvas;

    public Editor(Canvas canvas) {
        this.canvas = canvas;
        grid = new boolean[GRID_SIZE][GRID_SIZE];
        this.cursorX = 0;
        this.cursorY = 0;
        draw();
    }

    public void moveCursor(int dx, int dy) {
        cursorX = Math.max(0, Math.min(GRID_SIZE - 1, cursorX + dx));
        cursorY = Math.max(0, Math.min(GRID_SIZE - 1, cursorY + dy));
        draw();
    }

    public void togglePixel() {
        grid[cursorY][cursorX] = !grid[cursorY][cursorX];
        draw();
    }

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if (grid[y][x]) {
                    gc.setFill(Color.BLACK);
                } else {
                    gc.setFill(Color.WHITE);
                }
                gc.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                gc.setStroke(Color.GRAY);
                gc.strokeRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        gc.setStroke(Color.RED);
        gc.strokeRect(cursorX * CELL_SIZE, cursorY * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    public String generateCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int y = 0; y < GRID_SIZE; y++) {
            sb.append("    {");
            for (int x = 0; x < GRID_SIZE; x++) {
                sb.append(grid[y][x] ? "1" : "0");
                if (x < GRID_SIZE - 1) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            if (y < GRID_SIZE - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }
}