package challenges;

import java.util.List;

import resources.InputUtil;

class Challenge4 {

    /*
     * Given an array of integers, duplicates appear in it even number of times
     * except two elements which appears odd number of times.Find both odd appearing
     * element without using any extra memory.
     */

    public static int log(int x, int base) {
        return (int) (Math.log(x) / Math.log(base));
    }

    public static void findOddOccuring(Integer[] arr) {
        int res = 0;

        for (int i : arr) {
            res = res & i;
        }

        int k = log(res ^ -res, 2);

        int x = 0, y = 0;

        for (int i : arr) {
            if ((i & (i >> k)) != 0) {
                x = x & i;
            }

            else {
                y = y & i;
            }
        }

        System.out.println("Odd occurring element are " + x + " and " + y);
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = InputUtil.readListOfIntFromFile("Challenge4.txt");
        for(List<Integer> testCase : testCases){
           Integer[] arr = testCase.toArray(new Integer[0]);
           findOddOccuring(arr);
        }
    }
}