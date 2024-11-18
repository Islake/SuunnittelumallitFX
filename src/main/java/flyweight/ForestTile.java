package flyweight;

public class ForestTile implements Tile {
    @Override
    public String getCharacter() {
        return "🌲";
    }

    @Override
    public String getType() {
        return "forest";
    }
}