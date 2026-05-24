public class lastCoin {
    public int coin(int[] arr) {
        // code here
        int n=arr.length;
        if(n==0) return 0;
        if(n==1) return arr[0];
        int i=0, j=n-1;
        
        while(i <j){
            if(arr[i]>=arr[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return arr[j];
    }
}
