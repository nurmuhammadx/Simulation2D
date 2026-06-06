package action.impl;

import action.GameAction;
import action.MoveRequest;
import core.SimulationConfig;
import entity.creature.impl.Herbivore;
import entity.GameEntity;
import map.SimulationMap;
import pathfinding.impl.BfsPathFinder;

import java.util.ArrayList;
import java.util.List;

public class MoveCreatureGameAction extends GameAction {
    public List<MoveRequest> moveRequests = new ArrayList<>();

    public MoveCreatureGameAction(SimulationConfig simulationConfig) {
        super(simulationConfig);
    }

    @Override
    public void init(SimulationMap simulationMap) {
        collect(simulationMap);
        remove(simulationMap);
        update(simulationMap);

    }

    private void collect(SimulationMap simulationMap) {
        for (GameEntity gameEntity : simulationMap.getEntities().values()) {
            if (gameEntity instanceof Herbivore herbivore) {
                moveRequests.add(herbivore.getMoveRequest(simulationMap, new BfsPathFinder(), simulationConfig));
                herbivore.remove();
            }
        }
    }

    private void update(SimulationMap simulationMap) {
        for (MoveRequest moveRequest : moveRequests) {
            simulationMap.setEntity(moveRequest.getCoordinates(), moveRequest.getEntity());
        }
        moveRequests.clear();
    }

    private void remove(SimulationMap simulationMap) {
        for (MoveRequest moveRequest : moveRequests) {
            simulationMap.removeEntity(moveRequest.getEntity().getCoordinates());
        }
    }
}
