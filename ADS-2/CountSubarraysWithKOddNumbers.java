public class CountSubarraysWithKOddNumbers {

    public int countSubarrays(int[] arr, int k) {
        return helper(arr, k) - helper(arr, k - 1);
    }

    private int helper(int[] arr, int k) {
        if (k < 0) return 0;

        int l = 0, cnt = 0, res = 0;

        for (int r = 0; r < arr.length; r++) {
            if ((arr[r] & 1) == 1) cnt++;

            while (cnt > k) {
                if ((arr[l] & 1) == 1) cnt--;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountSubarraysWithKOddNumbers solution = new CountSubarraysWithKOddNumbers();

        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        int result = solution.countSubarrays(arr, k);
        System.out.println("Number of subarrays with exactly " + k + " odd numbers: " + result);
    }
}
