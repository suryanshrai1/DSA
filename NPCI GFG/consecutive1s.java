public class consecutive1s {
    int countStrings(int n) {
        if (n == 1) return 2;

        int zeroCount = 1; 
        int oneCount = 1;

        for (int i = 2; i <= n; i++) {
            int prevZeroCount = zeroCount;
            
            zeroCount = zeroCount + oneCount;
            
            oneCount = prevZeroCount;
        }
        return zeroCount + oneCount;
    }
}
