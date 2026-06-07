package pathfinding;

import core.SimulationConfig;
import map.Coordinates;

import java.util.List;

public interface IPathfinder {
    List<Coordinates> findPath(Coordinates start, Coordinates target);
}
