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
        for (int i = 0; i < simulationConfig.getTreeCount(); i++) {
            int[] position = generateRandomPosition();
            if (simulationMap.isSquareEmpty(new Coordinates(position[0], position[1]))) {
                simulationMap.setEntity(new Coordinates(position[0], position[1]), new Tree(new Coordinates(position[0], position[1])));
            }
        }
    }
}
