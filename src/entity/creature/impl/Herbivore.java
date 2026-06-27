package entity.creature.impl;

import core.SimulationConfig;
import entity.GameEntity;
import entity.creature.Creature;
import entity.environment.Grass;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.List;

public class Herbivore extends Creature {

    public Herbivore(Integer speed, Integer health) {
        super(speed, health);
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
    protected boolean canEnter(GameEntity entity) {
        return entity == null || entity instanceof Grass;
    }

    @Override
    protected boolean isResourceOrTargetExhausted(SimulationMap simulationMap) {
        int grass_count = simulationMap.getGrass().size();
        return grass_count == 0;
    }

    @Override
    public void interact(GameEntity target, SimulationMap simulationMap) {
        if (target instanceof Grass) {
            simulationMap.removeEntity(target.getCoordinates());
            heal(SimulationConfig.HEAL_AMOUNT);
            reachedTarget();
        }
    }
}
