package action.impl;

import action.GameAction;
import core.SimulationConfig;
import entity.creature.Creature;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MoveCreatureGameAction extends GameAction {
    private final List<MoveRequest> moveRequests = new ArrayList<>();
    private final IPathfinder pathfinder;
    private final InteractionAction interactionAction;

    public MoveCreatureGameAction(SimulationConfig simulationConfig, IPathfinder pathfinder, InteractionAction interactionAction) {
        super(simulationConfig);
        this.pathfinder = pathfinder;
        this.interactionAction = interactionAction;
    }

    @Override
    public void init(SimulationMap simulationMap) {
        collect(simulationMap);
        List<MoveRequest> approved = resolveConflicts();
        interactionAction.interact(simulationMap, approved);
        update(simulationMap,  approved);
    }

    private void collect(SimulationMap simulationMap) {
        moveRequests.clear();
        for (GameEntity entity : simulationMap.getEntities().values()) {
            if (entity instanceof Creature creature) {
                MoveRequest request = creature.getMoveRequest(simulationMap, pathfinder);
                if (request != null) {
                    moveRequests.add(request);
                }
            }
        }
    }

    private void update(SimulationMap simulationMap, List<MoveRequest> approved) {
        removeOldPositions(simulationMap, approved);
        placeNewPositions(simulationMap, approved);
        moveRequests.clear();
    }

    private List<MoveRequest> resolveConflicts() {
        List<MoveRequest> approved = new ArrayList<>();
        Set<Coordinates> occupied = new HashSet<>();
        for (MoveRequest request : moveRequests) {
            if (occupied.contains(request.getTo())) {
                continue;
            }
            occupied.add(request.getTo());
            approved.add(request);
        }

        return approved;
    }

    private void placeNewPositions(SimulationMap simulationMap, List<MoveRequest> approved) {
        for (MoveRequest request : approved) {
            Coordinates newPosition = request.getTo();
            Creature creature = request.getCreature();
            simulationMap.setEntity(newPosition, creature);
        }
    }

    private void removeOldPositions(SimulationMap simulationMap, List<MoveRequest> approved) {
        for (MoveRequest request : approved) {
            simulationMap.removeEntity(request.getFrom());
        }
    }
}
