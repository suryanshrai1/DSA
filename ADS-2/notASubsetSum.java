import java.util.Arrays;

public class notASubsetSum {
    public int findSmallest(int[] arr) {
        // code here
        Arrays.sort(arr);
        int res=1;
        
        for(int a : arr){
            if(a<= res){
                res+=a;
            }
            else{
                break;
            }
        }
        return res;
    }
}