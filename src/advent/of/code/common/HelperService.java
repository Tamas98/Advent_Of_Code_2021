package advent.of.code.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TODO docme.
 */
public class HelperService {

    public List<String> readLinesFromFile(String path) {
        List<String> result = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error while reading file from path: " + path);
            System.exit(-1);
        }

        while(scanner.hasNext()) {
            result.add(scanner.nextLine());
        }

        return result;
    }
}
