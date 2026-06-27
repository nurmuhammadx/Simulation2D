package view;

import core.SimulationConfig;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;

public class MapConsoleRenderer {
    private static final String ROCK = "🪨";
    private static final String GRASS = "🌿";
    private static final String TREE = "🌳";
    private static final String HERBIVORE = "🐇";
    private static final String PREDATOR  = "🐺";
    private static final String BG_LIGHT = "\u001B[48;5;194m";
    private static final String BG_DARK  = "\u001B[48;5;150m";
    private final static String RESET = "\u001B[0m";

    public void render(SimulationMap simulationMap) {
        for (int y = 0; y < SimulationConfig.MAP_HEIGHT; y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < SimulationConfig.MAP_WIDTH; x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (simulationMap.isSquareEmpty(coordinates)) {
                    line.append(setBackgroundColor(coordinates));
                }else {
                    line.append(setEntitySprite(simulationMap.getEntity(coordinates)));
                }
            }
            line.append(RESET);
            System.out.println(line);
        }
    }

    private String setBackgroundColor(Coordinates coordinates) {
        return defaultBackgroundColor("    ", SimulationMap.isSquareOrange(coordinates));
    }

    private String setEntitySprite(GameEntity gameEntity) {
        return defaultBackgroundColor(" " + selectEntitySprite(gameEntity) + " ", SimulationMap.isSquareOrange(gameEntity.getCoordinates()));
    }

    private String selectEntitySprite(GameEntity gameEntity) {
        return switch (gameEntity.getClass().getSimpleName()) {
            case "Rock" -> ROCK;
            case "Grass" -> GRASS;
            case "Tree" -> TREE;
            case "Predator" -> PREDATOR;
            case "Herbivore" -> HERBIVORE;
            default -> "";
        };
    }

    private String defaultBackgroundColor(String sprite, boolean isSquareOrange) {
        return isSquareOrange ? BG_LIGHT + sprite : BG_DARK + sprite;
    }
}
