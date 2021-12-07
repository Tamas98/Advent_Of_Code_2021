package advent.of.code.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> sonarData = readSonarData("src/advent/of/code/first/input.txt");
        System.out.println(countIncreases(sonarData));
    }

    private static List<Integer> readSonarData(String path)  {
        List<Integer> result = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file from path: " + path);
            System.exit(-1);
        }

        while(scanner.hasNext()) {
            result.add(Integer.parseInt(scanner.nextLine()));
        }

        return result;
    }

    private static int countIncreases(List<Integer> measurements) {
        int counter = 0;
        for(int i = 0, j = 1; i < measurements.size() - 1; i++, j++) {
            if(measurements.get(i) < measurements.get((j))) {
                counter++;
            }
        }

        return counter;
    }
}