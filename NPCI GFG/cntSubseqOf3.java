import java.util.ArrayList;

public class cntSubseqOf3 {

    public ArrayList<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        int[] smaller = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= min) {
                min = arr[i];
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }
        int[] greater = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                result.add(smaller[i]);
                result.add(arr[i]);
                result.add(greater[i]);
                return result;
            }
        }
        return result;
    }
}