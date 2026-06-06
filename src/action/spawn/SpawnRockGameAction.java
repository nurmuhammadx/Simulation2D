package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Rock;
import map.Coordinates;
import map.SimulationMap;

public class SpawnRockGameAction extends GameAction {

    public SpawnRockGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        for (int i = 0; i < simulationConfig.getRockCount(); i++) {
            int[] position = generateRandomPosition();
            if (simulationMap.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                simulationMap.setEntity(new Coordinates(position[0], position[1]), new Rock(new Coordinates(position[0], position[1])));
            }
        }
    }
}
