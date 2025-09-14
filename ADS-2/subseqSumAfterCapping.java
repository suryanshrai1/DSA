import java.util.Arrays;

public class subseqSumAfterCapping {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        /*
         this is a subsequence sum problem
         we will use dp in this approach
         TC = O(n+k), SC is also O(n+k)
        */
        int n = nums.length;
        // to store inp per requirement
        int [] inppReq = nums;
        // freq count for each no
        int[] cnt = new int[n+1]; // cause of the constraint  nums[i] < n
        for(int num : inppReq){
            cnt[num]++;
        }
        // now we create a suffix sum arr of cnt
        // store how many nos from nums, greater than = i;
        //n+2 is for cntLeast[n+1] i.e 0
        int cntLeast[] = new int[n+2];
        for(int i=n; i>=1; i--){
            cntLeast[i] = cntLeast[i+1]+ cnt[i];
        }
        // the primary algo
        boolean [] ans = new boolean[n];
        boolean[] dp = new boolean[k+1];
        dp[0] = true;

        for(int x = 1; x<=n; x++){
            int ownCoins = cnt[x];
            for(int c = 0; c< ownCoins; c++){
                for(int s=k; s>=x; s--){
                    if(dp[s-x]){
                        dp[s] = true;
                    }
                }
            }
            // now dp knows all possible sums
            // need to find ans for cap x
            boolean fnd = false;
            int remCoins = cntLeast[x+1];
            for(int j = 0; j<=k; j++){
                if(dp[j]){
                    int remaindNeed = k-j;
                    if(remaindNeed >= 0 && remaindNeed % x == 0){
                        int coinNeed = remaindNeed/x;
                        if(coinNeed <= remCoins){
                            fnd = true; //can make k
                            break; // found, check for nxt x
                        }
                    }
                }
            }
            ans[x-1] = fnd;
        }
        return ans;
    }

    public static void main(String[] args) {
        subseqSumAfterCapping solution = new subseqSumAfterCapping();

        // sample input
        int[] nums = {1, 2, 2, 3};
        int k = 5;

        // get result
        boolean[] result = solution.subsequenceSumAfterCapping(nums, k);

        // print output
        System.out.println("Output:");
        for (boolean val : result) {
            System.out.print(val + " ");
        }
        System.out.println(); // newline
    }
}
