import java.util.*;

public class pairWithDiff {
    private int helper(int[] arr, int i, int k, int[] dp){
        if(i<=0) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int notTake= helper(arr, i-1, k, dp);
        int take=0;
        if(arr[i]-arr[i-1]<k){
            take= arr[i-1]+arr[i]+ helper(arr, i-2, k, dp);
        }
        return dp[i]= Math.max(take, notTake);
    }
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int[] dp = new int [arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, arr.length-1, k, dp);
    }
}