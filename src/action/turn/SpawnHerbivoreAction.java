package action.turn;

import action.Action;
import core.SimulationConfig;
import creature.impl.Herbivore;
import map.Coordinates;
import map.Map;

public class SpawnHerbivoreAction extends Action {

    public SpawnHerbivoreAction(Map map, SimulationConfig simulationConfig) {
        super(map, simulationConfig);
    }

    @Override
    public void init() {
        spawnHerbivore();
    }

    public void spawnHerbivore() {
        for (int i = 0; i < simulationConfig.getHerbivoreCount(); i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0],position[1]), new Herbivore(new Coordinates(position[0],position[1]), 5, 50));
            }
        }
    }
}
