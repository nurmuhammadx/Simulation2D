package action.interaction;

import entity.GameEntity;
import entity.creature.Creature;
import map.Coordinates;

public class MoveRequest {
    private final Coordinates from;
    private final Coordinates to;
    private final Creature creature;
    private final GameEntity target;

    public MoveRequest(Coordinates from, Coordinates to, Creature creature,  GameEntity entity) {
        this.from = from;
        this.to = to;
        this.creature = creature;
        this.target = entity;
    }

    public Coordinates getFrom() {
        return from;
    }

    public Coordinates getTo() {
        return to;
    }

    public Creature getCreature() {
        return creature;
    }

    public GameEntity getTarget() {
        return target;
    }
}
