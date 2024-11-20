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
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/one.png"));
                    break;
                case "water":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/two.png"));
                    break;
                case "forest":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/three.png"));
                    break;
                case "road":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/four.png"));
                    break;
                case "building":
                    image = new Image(TileGraphicFactory.class.getResourceAsStream("/img/five.png"));
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