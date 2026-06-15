package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;

public class SpawnGrassGameAction extends GameAction {

    public SpawnGrassGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < simulationConfig.getGrassCount()) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.setEntity(coordinates, new Grass(coordinates));
                spawned++;
            }
        }
    }
}
