package threads;

public enum RunnerState {
    RUNNING( 1, "Start"),
    PAUSED(2, "Pause"),
    RESUME(3, "Resume"),
    STOPPED(4, "Stop");

    private final int value;
    private final String description;

    RunnerState(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
