package action.turn;

import action.Action;
import core.SimulationConfig;
import environment.Grass;
import map.Coordinates;
import map.Map;

public class SpawnGrassAction extends Action {
    private final Integer DEFAULT_GRASS_QUANTITY = 10;

    public SpawnGrassAction(Map map, SimulationConfig simulationConfig) {
        super(map, simulationConfig);
    }
    @Override
    public void init() {
        spawnGrass();
    }
    public void spawnGrass() {
        for (int i = 0; i < simulationConfig.getGrassCount(); i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Grass(new Coordinates(position[0], position[1])));
            }
        }
    }


}
