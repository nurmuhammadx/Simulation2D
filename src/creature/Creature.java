package creature;

import entity.Entity;
import map.Coordinates;

public abstract class Creature extends Entity {
    private final Integer speed;
    private final Integer health;

    public Creature(Coordinates coordinates,Integer speed, Integer health) {
        super(coordinates);
        this.health = speed;
        this.speed = health;
    }

    public abstract void makeMove();
}
