import java.util.*;

class PythagoreanTripletChecker {

    boolean pythagoreanTriplet(int[] arr) {
        int max = 1000;
        boolean[] present = new boolean[max + 1];

        for (int x : arr) {
            present[x] = true;
        }

        for (int a = 1; a <= max; a++) {
            if (!present[a]) continue;

            for (int b = a; b <= max; b++) {
                if (!present[b]) continue;

                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);

                if (c <= max && c * c == c2 && present[c]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        PythagoreanTripletChecker obj = new PythagoreanTripletChecker();

        int[] arr = {3, 1, 4, 6, 5};

        boolean result = obj.pythagoreanTriplet(arr);

        if (result) {
            System.out.println("Pythagorean Triplet Found ");
        } else {
            System.out.println("No Pythagorean Triplet ");
        }
    }
}