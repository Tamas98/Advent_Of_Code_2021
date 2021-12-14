package advent.of.code.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import advent.of.code.common.HelperService;

/**
 * TODO docme.
 */
public class Main {
    public static void main(String[] args) {
        HelperService helperService = new HelperService();
        List<String> gammaRateList = helperService.readLinesFromFile("src/advent/of/code/third/input.txt");
        calculateGammaRate(gammaRateList);
        calculateOxygen(gammaRateList);
    }

    private static void calculateOxygen(List<String> gammaRateList) {
        List<String> highestResult = calculateOxygenGeneratingRate(gammaRateList, 0);
        List<String> lowestResult = calculateScrubberRating(gammaRateList, 0);

        int firstParam = Integer.parseInt(highestResult.get(0), 2);
        int secondParam = Integer.parseInt(lowestResult.get(0),2);

        System.out.println(firstParam * secondParam);
    }

    private static List<String> calculateScrubberRating(List<String> dataList, int onPosition) {
        if(dataList.size() == 1) {
            return dataList;
        }

        List<String> startsWithOneList = new ArrayList<>();
        List<String> startsWithZeroList = new ArrayList<>();

        for(String measurement: dataList) {
            if(measurement.charAt(onPosition) == '1') {
                startsWithOneList.add(measurement);
            } else {
                startsWithZeroList.add(measurement);
            }
        }

        if(startsWithOneList.size() == startsWithZeroList.size()) {
            return calculateScrubberRating(startsWithZeroList, onPosition + 1);
        }

        return startsWithOneList.size() < startsWithZeroList.size() ?
                calculateScrubberRating(startsWithOneList, onPosition + 1) :
                calculateScrubberRating(startsWithZeroList, onPosition + 1);
    }

    private static List<String> calculateOxygenGeneratingRate(List<String> dataList, int onPosition) {
        if(dataList.size() == 1) {
            return dataList;
        }

        List<String> startsWithOneList = new ArrayList<>();
        List<String> startsWithZeroList = new ArrayList<>();

        for(String measurement: dataList) {
            if(measurement.charAt(onPosition) == '1') {
                startsWithOneList.add(measurement);
            } else {
                startsWithZeroList.add(measurement);
            }
        }

        if(startsWithOneList.size() == startsWithZeroList.size()) {
            return calculateOxygenGeneratingRate(startsWithOneList, onPosition + 1);
        }

        return startsWithOneList.size() < startsWithZeroList.size() ?
                calculateOxygenGeneratingRate(startsWithZeroList, onPosition + 1) :
                calculateOxygenGeneratingRate(startsWithOneList, onPosition + 1);
    }

    private static void calculateGammaRate(List<String> gammaRateList) {
        int length =  gammaRateList.get(0).length();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < length; i++) {
            stringBuilder.append(calculateMostCommonByte(i, gammaRateList));
        }

        int firstParam = Integer.parseInt(stringBuilder.toString(), 2);
        int secondParam = Integer.parseInt(reverseBinary(stringBuilder.toString()),2);

        System.out.println(firstParam * secondParam);
    }

    private static String calculateMostCommonByte(int onPosition, List<String> gammaRateList) {
        int counter = 0;
        for(String gammaRate: gammaRateList) {
            if(gammaRate.split("")[onPosition].equals("1")) {
                counter++;
            };
        }

        return counter < gammaRateList.size() / 2 ? "0" : "1";
    }

    private static String reverseBinary(String binary) {
        StringBuilder sb = new StringBuilder();
        for(String s : binary.split("")) {
            sb.append(s.equals("1") ? "0" : "1");
        }

        return sb.toString();
    }
}
