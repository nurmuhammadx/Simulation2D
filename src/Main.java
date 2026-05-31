import map.Map;
import view.MapConsoleRenderer;

public class Main {
    public static void main(String[] args) {

        Map map = new Map(17, 15);
        map.setDefPos();

        MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
        mapConsoleRenderer.render(map);
    }
}