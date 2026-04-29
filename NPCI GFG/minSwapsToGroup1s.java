public class minSwapsToGroup1s {
    public int minSwaps(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;

        for (int num : arr) {
            if (num == 1) totalOnes++;
        }

        if (totalOnes == 0) return -1;

        int currentOnes = 0;
        int maxOnesInWindow = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) currentOnes++;
            if (i >= totalOnes) {
                if (arr[i - totalOnes] == 1) {
                    currentOnes--;
                }
            }

            if (i >= totalOnes - 1) {
                maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
            }
        }
        return totalOnes - maxOnesInWindow;
    }
}
