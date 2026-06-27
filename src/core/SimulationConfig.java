package core;

public final class SimulationConfig {
    public static final int MAP_WIDTH = 17;
    public static final int MAP_HEIGHT = 15;
    public static final int HERBIVORE_COUNT = 1;
    public static final int PREDATOR_COUNT = 1;
    public static final int ROCK_COUNT = 10;
    public static final int TREE_COUNT = 10;
    public static final int GRASS_COUNT = 2;

    public static final int PREDATOR_HEALTH = 100;
    public static final int PREDATOR_SPEED = 2;
    public static final int PREDATOR_ATTACK_POWER = 10;

    public static final int HERBIVORE_HEALTH = 100;
    public static final int HERBIVORE_SPEED = 3;

    public static final int CREATURE_MAX_HEALTH = 100;
    public static final int HEAL_AMOUNT = 15;
    public static final int HUNGER_DAMAGE = 5;

    private SimulationConfig() {}
}
