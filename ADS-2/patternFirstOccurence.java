public class patternFirstOccurence {
    public static int findMatching(String text, String pat) {
        int n = text.length();
        int m = pat.length();
        
        for(int i=0; i<=n-m; i++){
            String slidingWin = text.substring(i, i+m);
            if(slidingWin.equals(pat)){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String text = "HelloWorld";
        String pat = "ell";
        int res = findMatching(text, pat);
        System.out.println(res);
    }     
}
