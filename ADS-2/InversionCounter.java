import java.util.*;

public class InversionCounter {
    
    public static int inversionCount(int arr[]) {
        if (arr == null || arr.length < 2)
            return 0;
        
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    private static int mergeSort(int arr[], int left, int right) {
        int count = 0;
        
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }
        
        return count;
    }
    
    private static int merge(int arr[], int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int count = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Count inversions
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        // Copy back to original array
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
        
        return count;
    }
    
    // Main method to test the program
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        
        System.out.println("Inversion Count (arr1): " + inversionCount(arr1)); // Expected: 3
        System.out.println("Inversion Count (arr2): " + inversionCount(arr2)); // Expected: 0
    }
}
