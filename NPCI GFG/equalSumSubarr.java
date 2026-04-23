public class equalSumSubarr {
    public boolean canSplit(int arr[]) {
        // code here
        int sum=0;
        for(int a : arr){
            sum += a;
        }
        if(sum %2 != 0) return false;
        int tar = sum/2;
        int curr=0;
        for(int i=0; i<arr.length;i++){
            curr += arr[i];
            
            if(curr==tar && i <arr.length-1){
                return true;
            }
        }
        return false;
    }
}