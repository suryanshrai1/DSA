public class CountLessEqualInRotatedArray {

    static int countInSorted(int[] arr, int left, int right, int x) {
        int l = left, r = right, res = left - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res - left + 1;
    }

    // Find index of smallest element (pivot)
    static int findPivot(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // Count elements <= x in rotated sorted array
    static int countLessEqual(int[] arr, int x) {
        int pivot = findPivot(arr);
        int count1 = countInSorted(arr, 0, pivot - 1, x);
        int count2 = countInSorted(arr, pivot, arr.length - 1, x);
        return count1 + count2;
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {6, 10, 12, 15, 2, 4, 5};
        int x = 14;

        int result = countLessEqual(arr, x);
        System.out.println(result); // Expected output: 6
    }
}
