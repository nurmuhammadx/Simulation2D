package action.spawn;

import action.GameAction;
import core.SimulationConfig;
import entity.environment.Tree;
import map.Coordinates;
import map.SimulationMap;

public class SpawnTreeGameAction extends GameAction {

    public SpawnTreeGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        int spawned = 0;
        while (spawned < simulationConfig.getTreeCount()) {
            int[] position = generateRandomPosition();
            Coordinates coordinates = new Coordinates(position[0], position[1]);
            if (simulationMap.isSquareEmpty(coordinates)) {
                simulationMap.setEntity(coordinates, new Tree(coordinates));
                spawned++;
            }
        }
    }
}
