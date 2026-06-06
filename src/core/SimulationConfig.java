package core;

public class SimulationConfig {
    private final Integer mapWidth = 17;
    private final Integer mapHeight = 15;
    private final Integer herbivoreCount = 1;
    private final Integer predatorCount = 1;
    private final Integer RockCount = 10;
    private final Integer TreeCount = 10;
    private final Integer GrassCount = 1;

    public SimulationConfig() {}

    public Integer getPredatorCount() {
        return predatorCount;
    }

    public Integer getMapWidth() {
        return mapWidth;
    }

    public Integer getMapHeight() {
        return mapHeight;
    }

    public Integer getHerbivoreCount() {
        return herbivoreCount;
    }

    public Integer getRockCount() {
        return RockCount;
    }

    public Integer getTreeCount() {
        return TreeCount;
    }

    public Integer getGrassCount() {
        return GrassCount;
    }
}
