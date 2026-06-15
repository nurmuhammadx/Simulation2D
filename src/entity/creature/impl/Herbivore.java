package entity.creature.impl;

import entity.GameEntity;
import entity.creature.Creature;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates, speed, health);
    }

    @Override
    protected Coordinates findNearestTarget(SimulationMap simulationMap, IPathfinder pathfinder) {
        Coordinates nearestGrass = null;
        int shortestPath = Integer.MAX_VALUE;
        for (Coordinates grass : simulationMap.getGrass()) {
            List<Coordinates> path = pathfinder.findPath(coordinates, grass, simulationMap);
            if (!path.isEmpty() && path.size() < shortestPath) {
                shortestPath = path.size();
                nearestGrass = grass;
            }
        }

        return nearestGrass;
    }

    @Override
    protected boolean isTargetAlive(SimulationMap simulationMap) {
        return simulationMap.getGrass().contains(target);
    }

    @Override
    public boolean canEat(GameEntity entity) {
        return entity instanceof Grass;
    }
}
