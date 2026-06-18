package action.impl;

import map.SimulationMap;

import java.util.List;

public class InteractionAction {

    public InteractionAction() {}

    public void interact(SimulationMap simulationMap, List<MoveRequest> moveRequests) {
        for (MoveRequest request : moveRequests) {
            if (request.getTarget() != null) {
                request.getCreature().interact(request.getTarget(), simulationMap);
            }
        }
    }
}
