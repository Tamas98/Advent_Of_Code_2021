package advent.of.code.thirteen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import advent.of.code.common.HelperService;

/**
 * TODO docme.
 */
public class Main {

    public static void main(String[] args) {
        MatrixPrinter mp = new MatrixPrinter();
        HelperService helperService = new HelperService();
        List<String> drawingDataList = helperService.readLinesFromFile("src/advent/of/code/thirteen/input.txt");
        List<String> foldInstructions = getFoldInstructions(drawingDataList);
        Set<Point> matrix = matrixBuilder(drawingDataList);
        matrix = fold(matrix, foldInstructions.get(0));
        System.out.println(matrix.size());

        Set<Point> matrix2 = matrixBuilder(drawingDataList);
        for(String foldInstruction: foldInstructions) {
            matrix2 = fold(matrix2, foldInstruction);
        }

        mp.printMatrix(matrix2);
    }

    private static Set<Point> matrixBuilder(List<String> pointList) {
        Set<Point> matrix = new HashSet<>();
        pointList.stream().filter(pointData -> pointData.matches("[0-9]+,[0-9]+")).forEach(pointData -> {
            String[] points = pointData.split(",");
            matrix.add(new Point(Integer.parseInt(points[0]), Integer.parseInt(points[1])));
        });

        return matrix;
    }

    private static Set<Point> fold(Set<Point> matrix, String instructions) {
        String[] instructionParts = instructions.split("=");
        int foldBy = Integer.parseInt(instructionParts[1]);
        if(instructionParts[0].equals("y")) {
            matrix.forEach(point -> {
                if(foldBy < point.getY()) {
                    point.setY((point.getY() - foldBy*2) * -1);
                }
            });
        } else {
            matrix.forEach(point -> {
                if(foldBy < point.getX()) {
                    point.setX((point.getX() - foldBy*2) * -1);
                }
            });
        }

        return new HashSet<>(matrix);
    }

    private static List<String> getFoldInstructions(List<String> drawingDataList) {
        return drawingDataList.stream().filter(data -> data.matches("[a-z]+ [a-z]+ [x,y]=[0-9]+")).map(data -> data.split(" ")[2]).collect(Collectors.toList());
    }
}
