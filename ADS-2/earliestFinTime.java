public class earliestFinTime {
        private int solve(int[] start1, int[] dur1, int[] start2, int[] dur2) {
        int finish1 = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++)
            finish1 = Math.min(finish1, start1[i] + dur1[i]);

        int finish2 = Integer.MAX_VALUE;
        for (int j = 0; j < start2.length; j++)
            finish2 = Math.min(finish2, Math.max(start2[j], finish1) + dur2[j]);

        return finish2;
    }

    public int earliestFinishTime(int[] landStart, int[] landDur,
            int[] waterStart, int[] waterDur) {
        return Math.min(
                solve(landStart, landDur, waterStart, waterDur),
                solve(waterStart, waterDur, landStart, landDur));
    }
}
    