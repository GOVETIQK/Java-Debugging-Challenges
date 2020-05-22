package solutions;

import java.util.List;

import resources.InputUtil;

class Challenge4_Solve {

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

        // take XOR of all array elements
        for (int i : arr) {
            res = res ^ i;
        }

        // find position of the rightmost set bit in res
        int k = log(res & -res, 2);

        // x and y are two odd appearing elements
        int x = 0, y = 0;

        // split the array into two sub-arrays
        for (int i : arr) {
            // elements that have k'th bit set
            if ((i & (1 << k)) != 0) {
                x = x ^ i;
            }

            // elements that don't have k'th bit set
            else {
                y = y ^ i;
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