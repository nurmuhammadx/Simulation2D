package threads;

import core.Simulation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SimulationRunner {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture<?> task;
    private RunnerState state = RunnerState.STOPPED;
    private final Simulation simulation;

    public SimulationRunner(Simulation simulation){
        this.simulation = simulation;
    }

    public  void start() {
        if (state == RunnerState.RUNNING) {
            System.out.println("Simulation is already running.");
            return;
        }

        state = RunnerState.RUNNING;

        task = executorService.scheduleAtFixedRate(
                simulation::nextTurn,
                0,
                3500,
                TimeUnit.MILLISECONDS
        );
    }

    public void pause() {
        if (state != RunnerState.RUNNING) {
            System.out.println("Simulation is not running.");
            return;
        }

        state = RunnerState.PAUSED;
        if (task != null) {
            task.cancel(false);
        }
    }

    public void stop() {
        executorService.shutdown();
        state = RunnerState.STOPPED;
    }
}
