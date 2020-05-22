package resources;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InputUtil {

    public static List<Integer> readIntFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("resources\\" + fileName));
            List<Integer> result = new ArrayList<>();
            for(String s : lines)
            {
                result.add(Integer.parseInt(s));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public static List<List<Integer>> readListOfIntFromFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("resources\\" + fileName));
            List<List<Integer>> result = new ArrayList<>();
            for(String s : lines)
            {
                List<String> intArray = Arrays.asList(s.split(" "));
                List<Integer> temp = new ArrayList<>();
                for(String ele : intArray)
                {
                    temp.add(Integer.parseInt(ele));
                }
            result.add(temp);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}