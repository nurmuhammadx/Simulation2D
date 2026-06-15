package pathfinding.impl;

import core.SimulationConfig;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.*;

public class BfsPathFinder implements IPathfinder {
    private final SimulationConfig simulationConfig;

    public BfsPathFinder(SimulationConfig simulationConfig) {
        this.simulationConfig = simulationConfig;
    }

    public List<Coordinates> findPath(Coordinates start, Coordinates target, SimulationMap simulationMap) {
        Queue<Coordinates> queue = new LinkedList<>();
        boolean[][] visited = new boolean[simulationConfig.getMapWidth()][simulationConfig.getMapHeight()];
        Map<Coordinates, Coordinates> parent = new HashMap<>();

        queue.offer(start);
        visited[start.getPositionX()][start.getPositionY()] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(target)) {
                return buildPath(start, target, parent);
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = current.getPositionX() + dRow[i];
                int nextCol = current.getPositionY() + dCol[i];

                Coordinates nextLocation = new Coordinates(nextRow, nextCol);
                GameEntity entity = simulationMap.getEntity(nextLocation);

                if (nextRow >= 0 && nextRow < simulationConfig.getMapWidth()
                        && nextCol >= 0 && nextCol < simulationConfig.getMapHeight()
                        && !visited[nextRow][nextCol]
                        && (entity == null || entity.isWalkable() || nextLocation.equals(target))
                ) {
                    visited[nextRow][nextCol] = true;
                    parent.put(new Coordinates(nextRow, nextCol), current);
                    queue.offer(new Coordinates(nextRow, nextCol));
                }
            }
        }
        return Collections.emptyList();
    }

    private List<Coordinates> buildPath(Coordinates start, Coordinates target, Map<Coordinates, Coordinates> parentMap) {
        List<Coordinates> path = new ArrayList<>();
        Coordinates current = target;

        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }

        Collections.reverse(path);

        if (!path.isEmpty() && path.get(0).equals(start)) {
            path.remove(0);
        }

        return path;
    }
}
