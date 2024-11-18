package flyweight;

public class SwampTile implements Tile {
    @Override
    public String getCharacter() {
        return "🌿";
    }

    @Override
    public String getType() {
        return "swamp";
    }
}