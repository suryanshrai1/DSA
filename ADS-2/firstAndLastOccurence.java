import java.util.*;

class firstAndLastOccurence {
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int first = findFirst(arr, x);
        int last = findLast(arr, x);
        res.add(first);
        res.add(last);
        return res;
    }

    int findFirst(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    int findLast(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        firstAndLastOccurence finder = new firstAndLastOccurence();

        // Example input
        int[] arr = { 1, 2, 2, 2, 3, 4, 5 };
        int x = 2;

        ArrayList<Integer> result = finder.find(arr, x);

        System.out.println("First Occurrence of " + x + ": " + result.get(0));
        System.out.println("Last Occurrence of " + x + ": " + result.get(1));
    }

}
