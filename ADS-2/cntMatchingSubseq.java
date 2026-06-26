import java.util.Arrays;

public class cntMatchingSubseq {
    static int mod= 1000000007;
    private static int helper(int i, int j, String s1, String s2, int[][] dp){
        if(j==s2.length()){
            return 1;
        }
        if(i==s1.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans;
        if(s1.charAt(i)== s2.charAt(j)){
            int take= helper(i+1,j+1, s1,s2, dp);
            int notTake= helper(i+1, j, s1, s2, dp);

            ans= (take+notTake)%mod;
        }
        else{
            ans= helper(i+1, j, s1, s2, dp);
        }
        return dp[i][j]= ans;
    }
        public static int countWays(String s1, String s2) {
        // code here
        int n= s1.length();
        int m= s2.length();
        int [][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(0,0,s1, s2, dp);
    }
}
