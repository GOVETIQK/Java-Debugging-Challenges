package challenges;

import java.util.Arrays;
import java.util.List;

import resources.InputUtil;

class Util {

    /*
     * Given an array constructed from another array by taking sum of every distinct
     * pair in it, decode the array to get back the original array elements.</p> If
     * the original array is A[0],A[1],..,A[n-1], then the input array is 
     * { (A[0] +A[1]), (A[0] + A[2]), .. , (A[0] + A[n-1]), 
     * (A[1] + A[2]), (A[1] + A[3]), .. , (A[1] + A[n-1]), 
     * .. 
     * .. 
     * (A[i] + A[i+1]), (A[i] + A[i+2]), . . , (A[i] +A[n-1]),  
     * .. 
     * .. 
     * (A[n-2] + A[n-1]) } 
     * For example, 
     * Input: { 3, 4, 5, 6, 5, 6, 7, 7, 8, 9 }
     * Output: { 1, 2, 3, 4, 5 }
     * Input: { 3, 4, 5 }
     * Output: { 1, 2, 3 }
     */

    // Function to decode given array to get back the original array elements
    public static void decode(Integer[] inp) {

        int n = (int) (Math.sqrt(6 * inp.length + 2)) / 2;

        int[] A = new int[n];

        if (n == 1) {
            A[0] = inp[0];
        } else if (n == 2) {
            A[0] = inp[0] - inp[1];
        } else {
            A[0] = (inp[0] + inp[1] - inp[n - 1]) / 2;
        }

        for (int i = 1; i < n; i++) {
            A[i] = inp[i - 1] - A[0];
        }

        System.out.println(Arrays.toString(A));
    }

    // main function
    public static void main(String[] args) {
        List<List<Integer>> testCases = InputUtil.readListOfIntFromFile("Challenge5.txt");
        for(List<Integer> testCase : testCases){
           Integer[] arr = testCase.toArray(new Integer[0]);
           decode(arr);
        }   
        
    }
}