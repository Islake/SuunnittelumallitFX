package flyweight;

public class WaterTile implements Tile {
    @Override
    public String getCharacter() {
        return "🌊";
    }

    @Override
    public String getType() {
        return "water";
    }
}
