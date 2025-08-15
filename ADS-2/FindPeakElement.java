/*
 * You are given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist).
If there are multiple peak elements, Return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
Note: Consider the element before the first element and the element after the last element to be negative infinity.
 */

class FindPeakElement {
    public static int peakElement(int[] arr) {
        
        int n = arr.length;
        int low =0, high = n-1;
        
        while(low <= high){
            int mid = low+(high-low)/2;
            
            
            if((mid==0 || arr[mid-1]<= arr[mid]) && (mid==n-1 || arr[mid+1]<= arr[mid])){
                return mid;
            }
            else if(mid >0 && arr[mid-1] >= arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,4,5,7,8,3};
        System.out.println(peakElement(arr)); // prints the index of the peak
    }
}