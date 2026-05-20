public class prefixCommonArr {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] freq = new int[n + 1];
        int common = 0;

        for (int i = 0; i < n; i++) {
            freq[A[i]] += 1;
            if (freq[A[i]] == 2)
                common++;

            freq[B[i]] += 1;
            if (freq[B[i]] == 2)
                common++;

            res[i] = common;
        }
        return res;
    }
}