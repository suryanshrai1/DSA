import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithTwoDistinct {

    public static int totalElements(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < arr.length; right++) {
            counts.put(arr[right], counts.getOrDefault(arr[right], 0) + 1);

            while (counts.size() > 2) {
                counts.put(arr[left], counts.get(arr[left]) - 1);
                if (counts.get(arr[left]) == 0) {
                    counts.remove(arr[left]);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 2, 2};

        int result = totalElements(arr);

        System.out.println("Longest subarray length with at most 2 distinct elements: " + result);
    }
}