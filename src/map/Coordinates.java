package map;

import java.util.Objects;

public class Coordinates {
    private final Integer positionX;
    private final Integer positionY;

    public Coordinates(Integer positionX, Integer positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public Integer getPositionY() {
        return positionY;
    }

    public Integer getPositionX() {
        return positionX;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(positionX, that.positionX) && Objects.equals(positionY, that.positionY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }
}
