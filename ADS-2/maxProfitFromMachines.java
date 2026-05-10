import java.util.Arrays;

public class maxProfitFromMachines {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        // code here
        int n=a.length;
        Integer[] idx = new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        //sort by desc abs diff
        Arrays.sort(idx,(i,j)-> Math.abs(b[j]-a[j]) - Math.abs(b[i]-a[i]));
        int prof =0;
        for(int i : idx){
            if((a[i]>= b[i] && x>0) || y==0){
                prof += a[i];
                x--;
            }
            else{
                prof += b[i];
                y--;
            }
        }
        return prof;
    }
}
}
