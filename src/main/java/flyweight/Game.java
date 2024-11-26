package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Game extends Application {
    private static final int TILE_SIZE = 32;
    private Map map;
    private Canvas canvas;
    private final Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        map = new WildernessMap(50, 50);
        canvas = new Canvas(map.getTiles().length * TILE_SIZE, map.getTiles()[0].length * TILE_SIZE);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        renderMap(gc);

        Button updateButton = new Button("Update Map");
        updateButton.setOnAction(e -> updateMap(gc));

        Pane root = new Pane();
        root.getChildren().addAll(canvas, updateButton);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("RPG Map");
        primaryStage.show();
    }

    private void renderMap(GraphicsContext gc) {
        Tile[][] tiles = map.getTiles();
        for (int x = 0; x < tiles.length; x++) {
            for (int y = 0; y < tiles[x].length; y++) {
                Tile tile = tiles[x][y];
                Image image = TileGraphicFactory.getTileGraphic(tile.getType());
                gc.drawImage(image, x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void updateMap(GraphicsContext gc) {
        if (random.nextBoolean()) {
            map = new WildernessMap(50, 50);
        } else {
            map = new CityMap(50, 50);
        }
        renderMap(gc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}