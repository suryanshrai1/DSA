public class MaxConsecutiveOnesWithFlips {

    public static int maxOnes(int[] arr, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 0, 0, 1, 1, 1 };
        int k = 2;

        int result = maxOnes(arr, k);
        System.out.println("Maximum consecutive ones after flipping at most "
                + k + " zeros: " + result);
    }
}
