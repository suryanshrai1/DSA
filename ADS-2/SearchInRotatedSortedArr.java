public class SearchInRotatedSortedArr {
    public boolean check(int [] nums){
        int n=nums.length;
        if(n==0) return false;
        if(n==1) return true;
        int breakPoint =0;
        for(int i=0;i<n;i++){
            if(nums[i] > nums[(i+1)%n]){
                breakPoint++;
            }
        }
        return breakPoint <=1;
    }
}
