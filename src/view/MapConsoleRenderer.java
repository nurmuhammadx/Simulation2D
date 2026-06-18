package view;

import core.SimulationConfig;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;

public class MapConsoleRenderer {
    private final static String ROCK = "\uD83E\uDEA8";
    private final static String GRASS = "\uD83C\uDF31";
    private final static String TREE = "\uD83C\uDF32";
    private final static String PREDATOR = "\uD83D\uDC3A";
    private final static String HERBIVORE = "\uD83D\uDC30";
    private final static String BG_SAND = "\u001B[48;5;222m";
    private final static String BG_ORANGE = "\u001B[48;5;215m";
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
        return isSquareOrange ? BG_ORANGE + sprite : BG_SAND + sprite;
    }
}
