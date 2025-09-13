// lasers
// we have to return the minimum number of crossings required to reach x, y 
//from 0,0, one laser crossing is counted when we cross a vertical or 
//horizontal laser, if we cross an intersection it is counted as two

import java.util.Scanner;

public class lasers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // number of horizontal lasers
            int m = scanner.nextInt(); // number of vertical lasers
            int x = scanner.nextInt(); // destination x
            int y = scanner.nextInt(); // destination y

            int[] a = new int[n]; // y-coordinates of horizontal lasers
            int[] b = new int[m]; // x-coordinates of vertical lasers

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            for (int i = 0; i < m; i++) {
                b[i] = scanner.nextInt();
            }

            // Count how many horizontal lasers are below y
            int hCrosses = countLessThan(a, y);

            // Count how many vertical lasers are left of x
            int vCrosses = countLessThan(b, x);

            // Total crossings = horizontal + vertical
            System.out.println(hCrosses + vCrosses);
        }
        scanner.close();
    }

    // Helper method to count elements less than value (used binary search here)
    private static int countLessThan(int[] arr, int value) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
