package advent.of.code.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import advent.of.code.common.HelperService;

public class Main {
    public static void main(String[] args) {
        HelperService helperService = new HelperService();
        List<Integer> sonarData = helperService.readLinesFromFile("src/advent/of/code/first/input.txt")
                                                .stream()
                                                .map(Integer::parseInt)
                                                .collect(Collectors.toList());
        System.out.println(countIncreases(sonarData));
        System.out.println(countIncreasesWhenUsingSum(sonarData));
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

    private static int countIncreasesWhenUsingSum(List<Integer> measurements) {
        int counter = -1;
        int prevSum = 0;
        for(int i = 0, j = 1, k = 2; k < measurements.size(); i++, j++, k++) {
            int sum = measurements.get(i) + measurements.get(j) + measurements.get(k);
            if(prevSum < sum) {
                counter++;
            }

            prevSum = sum;
        }

        return counter;
    }
}