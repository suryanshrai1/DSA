public class jumpGameVII {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n =s.length();
        if(s.charAt(n-1) !='0') return false;

        boolean[] dp = new boolean [n];
        dp[0]= true;
        int reach=0;
        for(int i=1;i<n;i++){
            if(i- minJump >=0 && dp[i-minJump]){
                reach++;
            }
            if(i-maxJump-1 >=0 && dp[i-maxJump-1]){
                reach--;
            }
            if(s.charAt(i)=='0' && reach >0){
                dp[i]= true;
            }
        }
        return dp[n-1];
    }
}
