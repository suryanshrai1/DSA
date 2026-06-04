public class wavinessOfNums {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i = num1; i <= num2; i++) {
            ans += helper(i);
        }
        return ans;
    }

    // returns waiviness
    private int helper(int num) {
        int waiv = 0;
        String str = Integer.toString(num);

        for (int i = 1; i < str.length() - 1; i++) {
            boolean isPeak = str.charAt(i) > str.charAt(i + 1) && str.charAt(i) > str.charAt(i - 1);
            boolean isValley = str.charAt(i) < str.charAt(i + 1) && str.charAt(i) < str.charAt(i - 1);

            if (isPeak || isValley) {
                waiv++;
            }
        }
        return waiv;
    }
}
