package action.turn;

import action.Action;
import core.SimulationConfig;
import environment.Rock;
import map.Coordinates;
import map.Map;

public class SpawnRockAction extends Action {

    public SpawnRockAction(Map map, SimulationConfig simulationConfig) {
        super(map, simulationConfig);
    }

    @Override
    public void init() {
        spawnRock();
    }

    public void spawnRock() {
        for (int i = 0; i < simulationConfig.getRockCount(); i++) {
            int[] position = generateRandomPosition();
            if (map.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                map.setEntity(new Coordinates(position[0], position[1]), new Rock(new Coordinates(position[0], position[1])));
            }
        }
    }


}
