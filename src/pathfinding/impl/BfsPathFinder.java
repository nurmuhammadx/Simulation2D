package pathfinding.impl;

import core.SimulationConfig;
import map.Coordinates;
import pathfinding.IPathfinder;

import java.util.*;

public class BfsPathFinder implements IPathfinder {

    public List<Coordinates> findPath(Coordinates start, Coordinates target, SimulationConfig simulationConfig) {
        Queue<Coordinates> queue = new LinkedList<>();
        boolean[][] visited = new boolean[simulationConfig.getMapWidth()][simulationConfig.getMapHeight()];
        Map<Coordinates, Coordinates> parentMap = new HashMap<>();

        queue.offer(start);
        visited[start.getPositionX()][start.getPositionY()] = true;

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();

            if (current.equals(target)) {
                return buildPath(start, target, parentMap);
            }

            // Обход 4-х соседей
            for (int i = 0; i < 4; i++) {
                int nextRow = current.getPositionX() + dRow[i];
                int nextCol = current.getPositionY() + dCol[i];

                // Проверка границ, стен и посещенных клеток
                if (nextRow >= 0 && nextRow < simulationConfig.getMapWidth() &&
                        nextCol >= 0 && nextCol < simulationConfig.getMapHeight()
                        && !visited[nextRow][nextCol]) {

                    visited[nextRow][nextCol] = true;
                    parentMap.put(new Coordinates(nextRow, nextCol), current);
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
