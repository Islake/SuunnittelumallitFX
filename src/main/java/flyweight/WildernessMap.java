package flyweight;

public class WildernessMap extends Map {
    private final int width;
    private final int height;
    private final Tile[][] tiles;

    public WildernessMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        generateMap();
    }

    private void generateMap() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = createTile();
            }
        }
    }

    @Override
    protected Tile createTile() {
        int choice = random.nextInt(3); // 0, 1, 2
        switch (choice) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                return null;
        }
    }

    @Override
    public Tile[][] getTiles() {
        return tiles;
    }
}