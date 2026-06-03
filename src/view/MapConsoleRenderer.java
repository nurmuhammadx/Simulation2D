package view;

import core.SimulationConfig;
import entity.Entity;
import map.Coordinates;
import map.Map;

public class MapConsoleRenderer {
    private final static String ROCK = "\uD83E\uDEA8";
    private final static String GRASS = "\uD83C\uDF31";
    private final static String TREE = "\uD83C\uDF32";
    private final static String PREDATOR = "\uD83D\uDC3A";
    private final static String HERBIVORE = "\uD83D\uDC30";
    private final static String BG_SAND = "\u001B[48;5;222m";
    private final static String BG_ORANGE = "\u001B[48;5;215m";
    private final static String RESET = "\u001B[0m";

    public void render(Map map, SimulationConfig simulationConfig) {
        for (int y = 0; y < simulationConfig.getMapHeight(); y++) {
            StringBuilder line = new StringBuilder();
            for (int x = 0; x < simulationConfig.getMapWidth(); x++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (map.isSquareEmpty(coordinates)) {
                    line.append(setBackgroundColor(coordinates));
                }else {
                    line.append(setEntitySprite(map.getEntity(coordinates)));
                }
            }
            line.append(RESET);
            System.out.println(line);
        }
    }

    private String setBackgroundColor(Coordinates coordinates) {
        return defaultBackgroundColor("    ", Map.isSquareOrange(coordinates));
    }

    private String setEntitySprite(Entity entity) {
        return defaultBackgroundColor(" " + selectEntitySprite(entity) + " ", Map.isSquareOrange(entity.coordinates));
    }

    private String selectEntitySprite(Entity entity) {
        return switch (entity.getClass().getSimpleName()) {
            case "Rock" -> ROCK;
            case "Grass" -> GRASS;
            case "Tree" -> TREE;
            case "Predator" -> PREDATOR;
            case "Herbivore" -> HERBIVORE;
            default -> "";
        };
    }

    private String defaultBackgroundColor(String sprite, boolean isSquareOrange) {
        String result = sprite;
        if (isSquareOrange) {
            result = BG_ORANGE + result;
        } else {
            result = BG_SAND + result;
        }
        return result;
    }
}
