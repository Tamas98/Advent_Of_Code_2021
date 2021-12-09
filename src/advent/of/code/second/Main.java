package advent.of.code.second;

import java.util.List;
import java.util.stream.Collectors;

import advent.of.code.common.HelperService;
import advent.of.code.second.domain.Submarine;

/**
 * TODO docme.
 */
public class Main {
    public static void main(String[] args) {
        HelperService helperService = new HelperService();
        List<String> movementInfo = helperService.readLinesFromFile("src/advent/of/code/second/input.txt");

        Submarine submarine = new Submarine();
        executeMovePlanOnSubmarine(submarine, movementInfo);
        System.out.println(submarine.getPositionX() * submarine.getPositionY());

        Submarine submarine2 = new Submarine();
        executeMovePlanOnSubmarineWithAim(submarine2, movementInfo);
        System.out.println(submarine2.getPositionX() * submarine2.getPositionY());
    }

    private static void executeMovePlanOnSubmarine(Submarine submarine, List<String> movementInfo) {
        movementInfo.forEach(information -> {
            String[] directionAndMeasure = information.split(" ");
            moveSubmarine(submarine, directionAndMeasure[0], directionAndMeasure[1]);
        });
    }

    private static void executeMovePlanOnSubmarineWithAim(Submarine submarine, List<String> movementInfo) {
        movementInfo.forEach(information -> {
            String[] directionAndMeasure = information.split(" ");
            moveSubmarineWithAim(submarine, directionAndMeasure[0], directionAndMeasure[1]);
        });
    }

    private static void moveSubmarine(Submarine submarine, String direction, String measure) {
        int measureAsNumber = Integer.parseInt(measure);
        switch (direction) {
        case "forward":
            submarine.setPositionX(submarine.getPositionX() + measureAsNumber);
            break;
        case "down":
            submarine.setPositionY(submarine.getPositionY() + measureAsNumber);
            break;
        case "up":
            submarine.setPositionY(submarine.getPositionY() - measureAsNumber);
            break;
        }
    }

    private static void moveSubmarineWithAim(Submarine submarine, String direction, String measure) {
        int measureAsNumber = Integer.parseInt(measure);
        switch (direction) {
        case "forward":
            submarine.setPositionX(submarine.getPositionX() + measureAsNumber);
            submarine.setPositionY(submarine.getPositionY() + measureAsNumber * submarine.getAim());
            break;
        case "down":
            submarine.setAim(submarine.getAim() + measureAsNumber);
            break;
        case "up":
            submarine.setAim(submarine.getAim() - measureAsNumber);
            break;
        }
    }
}
