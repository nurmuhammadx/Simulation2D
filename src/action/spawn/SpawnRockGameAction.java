package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Rock;
import map.Coordinates;
import map.SimulationMap;

public class SpawnRockGameAction extends GameAction {

    public SpawnRockGameAction() {}

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < SimulationConfig.ROCK_COUNT) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.putEntity(coordinates, new Rock());
                spawned++;
            }
        }
    }
}
