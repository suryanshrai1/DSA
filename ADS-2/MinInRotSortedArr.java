public class MinInRotSortedArr {
    public int findMin(int[] nums) {
        int n=nums.length;
        int low=0;
        int hi=n-1;
        while(low <hi){
            int mid=low+(hi-low)/2;
            if(nums[mid]> nums[hi]){
                low=mid+1;
            }
            else if(nums[mid]== nums[hi]){
                hi--;
            }
            else{
                hi=mid;
            }
        }
        return nums[low];
    }
}
