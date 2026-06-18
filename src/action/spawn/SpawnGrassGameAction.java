package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;

public class SpawnGrassGameAction extends GameAction {

    public SpawnGrassGameAction() {}

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < SimulationConfig.GRASS_COUNT) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.putEntity(coordinates, new Grass());
                spawned++;
            }
        }
    }
}
