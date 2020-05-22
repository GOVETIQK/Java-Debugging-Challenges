package challenges;

import java.util.Random;

public class Challenge2 {
    /*
     * Challenge is to return Fair results from a Tail baised coin Hence the output
     * should be near fifty when the coin is tossed 10^5 times Answers may wary but
     * the Percentages will be approx to 50
     */
    private static final int HEADS = 1;
    private static final int TAILS = 0;

    // Generates a pseudo-random integer in the range [min, max]
    public static int rand(int min, int max) {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Invalid range");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    // Biased function
    public static int biased() {
        int r = rand(0, 100);
        return (r <= 70) ? TAILS : HEADS;
    }

    public static int generate() {
        while (true) {
            int first = biased();
            int second = biased();

            if (first == second) {
                return first;
            }
        }
    }

    // Program to generate fair results from a biased coin
    public static void main(String[] args) {
        int x = 0, y = 0;

        for (int i = 0; i < 100000; i++) {
            int val = generate();
            if (val == HEADS) {
                x++;
            } else {
                y++;
            }
        }

        System.out.println("HEADS ~ " + x / 1000.0 + "%"); // ~50%
        System.out.println("TAILS ~ " + y / 1000.0 + "%"); // ~50%
    }
}