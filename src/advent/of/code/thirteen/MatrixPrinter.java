package advent.of.code.thirteen;

import java.util.Comparator;
import java.util.Set;

/**
 * TODO docme.
 */
public class MatrixPrinter {

    public void printMatrix(Set<Point> matrix) {
        int maxX = calculateMaxX(matrix);
        int maxY = calculateMaxY(matrix);
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {

                Point point = new Point(j,i);
                if(matrix.contains(point)) {
                    System.out.print("%");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    private int calculateMaxY(Set<Point> matrix) {
        return matrix.stream().map(Point::getY).max(Integer::compareTo).get();
    }

    private int calculateMaxX(Set<Point> matrix) {
        return matrix.stream().map(Point::getX).max(Integer::compareTo).get();
    }



}
