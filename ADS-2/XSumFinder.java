import java.util.*;

public class XSumFinder {

    public int[] findXSum(int[] nums, int k, int x) {
        int[] freq = new int[51];
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Arrays.fill(freq, 0);

            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            List<int[]> freqList = new ArrayList<>();
            for (int value = 0; value < 51; value++) {
                if (freq[value] > 0) {
                    freqList.add(new int[] { value, freq[value] });
                }
            }

            freqList.sort((a, b) -> {
                if (b[1] == a[1]) {
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            });

            int xSum = 0;
            int count = 0;
            for (int[] pair : freqList) {
                if (count == x)
                    break;
                xSum += pair[0] * pair[1];
                count++;
            }

            ans[i] = xSum;
        }
        return ans;
    }

    // ---- Main method for testing ----
    public static void main(String[] args) {
        XSumFinder finder = new XSumFinder();

        // Example test cases
        int[] nums1 = {1, 2, 2, 3, 3, 3, 4};
        int k1 = 3, x1 = 2;
        System.out.println("Test 1:");
        System.out.println(Arrays.toString(finder.findXSum(nums1, k1, x1)));
        // Explanation: Sliding windows of size 3; picks top 2 frequent numbers

        int[] nums2 = {5, 5, 5, 2, 2, 3};
        int k2 = 4, x2 = 1;
        System.out.println("\nTest 2:");
        System.out.println(Arrays.toString(finder.findXSum(nums2, k2, x2)));

        int[] nums3 = {1, 1, 2, 2, 3, 3};
        int k3 = 2, x3 = 1;
        System.out.println("\nTest 3:");
        System.out.println(Arrays.toString(finder.findXSum(nums3, k3, x3)));
    }
}
