package entity.creature;

import action.MoveRequest;
import core.SimulationConfig;
import entity.GameEntity;
import map.Coordinates;
import map.SimulationMap;
import pathfinding.IPathfinder;

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

    public abstract MoveRequest getMoveRequest(SimulationMap simulationMap, IPathfinder pathFinder);
}
