package flyweight;

import javafx.scene.image.Image;
import java.util.HashMap;
import java.util.Map;

public class TileGraphicFactory {
    private static final Map<String, Image> tileGraphics = new HashMap<>();

    public static Image getTileGraphic(String type) {
        Image image = tileGraphics.get(type);
        if (image == null) {
            switch (type) {
                case "swamp":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/swamp.jpg"));
                    break;
                case "water":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/ocean.png"));
                    break;
                case "forest":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/forest.png"));
                    break;
                case "road":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/road.png"));
                    break;
                case "building":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/building.png"));
                    break;
                default:
                    System.out.println("NOTHING");
                    throw new IllegalArgumentException("Unknown tile type: " + type);

            }
            tileGraphics.put(type, image);
        }
        return image;
    }
}