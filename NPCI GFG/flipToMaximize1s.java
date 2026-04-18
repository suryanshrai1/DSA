
public class flipToMaximize1s{
    int maxOnes(int[] arr) {
        int totalOnes = 0;

        for (int num : arr) {
            if (num == 1) totalOnes++;
        }

        int maxGain = 0;
        int currGain = 0;

        for (int num : arr) {
            int val = (num == 0) ? 1 : -1;

            currGain = Math.max(val, currGain + val);
            maxGain = Math.max(maxGain, currGain);
        }
        return totalOnes + maxGain;
    }
}