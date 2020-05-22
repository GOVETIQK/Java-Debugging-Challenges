package challenges;

import java.util.List;

import resources.InputUtil;

public class Challenge1 {
    /** A Funtion to compute modulo without using Division */
    public static Integer computeModulo(Integer a, Integer b) {
        if (b != 0 && ((b & (b - 1)) == 0)) {
            return a & (b - 1);
        } else {
            while (a > 0) {
                a -= b;
            }
            return a;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = InputUtil.readListOfIntFromFile("Challenge1.txt");
        for(List<Integer> testCase : testCases){
            System.out.println(computeModulo(testCase.get(0),testCase.get(1)));
        }
    }
}