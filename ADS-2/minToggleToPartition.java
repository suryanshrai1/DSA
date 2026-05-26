public class minToggleToPartition{
    int minToggle(int[] arr) {
        int n = arr.length;
        int totalOnes = 0;
        for (int x : arr) {
            if (x == 1) totalOnes++;
        }

        int totalZeros = n - totalOnes;
        int minToggles = totalZeros; 

        int onesSoFar = 0;
        int zerosSoFar = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) onesSoFar++;
            else zerosSoFar++;

            int zerosInRight = totalZeros - zerosSoFar;
            int currentToggles = onesSoFar + zerosInRight;

            minToggles = Math.min(minToggles, currentToggles);
        }
        return minToggles;
    }
}
