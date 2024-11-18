package flyweight;

import java.util.Random;

public abstract class Map {
    protected Random random = new Random();

    protected abstract Tile createTile();
    public abstract Tile[][] getTiles();

    public void display(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}