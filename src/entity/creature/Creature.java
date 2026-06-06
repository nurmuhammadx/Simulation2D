package entity.creature;

import core.SimulationConfig;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

import java.util.LinkedList;

public abstract class Creature extends GameEntity {
    private final Integer speed;
    private final Integer health;
//    к этому мы еше вернемся
//    private final LinkedList<Coordinates> currentPath;
//    private GameEntity target;

    public Creature(Coordinates coordinates, Integer speed, Integer health) {
        super(coordinates);
        this.health = speed;
        this.speed = health;
    }

    public abstract void makeMove(SimulationMap simulationMap, IPathfinder pathFinder, SimulationConfig config);
}
