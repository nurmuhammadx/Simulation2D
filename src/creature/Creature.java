package creature;

import entity.Entity;

public abstract class Creature extends Entity {
    private final Integer speed;
    private final Integer health;

    public Creature(Integer speed, Integer health) {
        this.health = speed;
        this.speed = health;
    }

    public abstract void makeMove();
}
