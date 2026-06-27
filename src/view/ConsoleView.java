package view;

import threads.RunnerState;
import threads.SimulationRunner;

import java.util.Scanner;

public class ConsoleView {
    private  final SimulationRunner simulationRunner;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleView(SimulationRunner simulationRunner) {
        this.simulationRunner = simulationRunner;
    }

    public void launch(){
        printMenu();
        while (true) {
            String command = scanner.nextLine();
            int number = Integer.parseInt(command);
            switch (number) {
                case 1, 3 -> simulationRunner.start();
                case 2 -> simulationRunner.pause();
                case 4 -> {
                    simulationRunner.stop();
                    return;
                }
            }
        }
    }

    private  void printMenu() {
        for (RunnerState state : RunnerState.values()) {
            System.out.print(state.getValue()+ " to " + state.getDescription() + "; ");
        }
        System.out.println();
        System.out.print("Enter command to start the simulation: ");
    }
}
