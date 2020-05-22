package solutions;

import java.util.*;

import resources.InputUtil;

public class Challenge3_Solve {
    /*
     * Debug program to generate all distinct subsets of given set. For example if s
     * is a set {x, y, x} then the sub sets of s are {} (null set) {x} {y} {x} {x,y}
     * {x,x} {y,x} {x,y,z} Therfore the distinct subsets in power set are : { {},
     * {x}, {y}, {x,y}, {x,x}, {x,y,x}}
     */

    // Iterative function to print all distinct subsets of S
    public static void findPowerSet(Integer[] S) {
        int N = (int) Math.pow(2, S.length);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < S.length; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(S[j]);
                }
            }

            set.add(subset);
        }

        // print all subsets present in the set
        for (List<Integer> subset : set) {
            System.out.println(subset);
        }
    }

    // Program to generate all distinct subsets of given set
    public static void main(String[] args) {
        List<List<Integer>> testCases = InputUtil.readListOfIntFromFile("Challenge3.txt");
        for(List<Integer> testCase : testCases){
           Integer[] arr = testCase.toArray(new Integer[0]);
            Arrays.sort(arr);
           findPowerSet(arr);
        }
    }

}