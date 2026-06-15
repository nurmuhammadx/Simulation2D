package pathfinding;

import map.Coordinates;
import map.SimulationMap;

import java.util.List;

public interface IPathfinder {
    List<Coordinates> findPath(Coordinates start, Coordinates target,  SimulationMap simulationMap);
}
