package action;

import entity.GameEntity;
import map.Coordinates;

public class MoveRequest {
    private final Coordinates coordinates;
    private final GameEntity gameEntity;

    public MoveRequest(Coordinates coordinates, GameEntity gameEntity) {
        this.coordinates = coordinates;
        this.gameEntity = gameEntity;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public GameEntity getEntity() {
        return gameEntity;
    }
}
