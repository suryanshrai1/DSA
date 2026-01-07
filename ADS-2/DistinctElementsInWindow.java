import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementsInWindow {

    static ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Process the first window
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        result.add(map.size());

        // Slide the window
        for (int i = k; i < arr.length; i++) {
            // Remove the element going out of the window
            int outgoingElement = arr[i - k];
            map.put(outgoingElement, map.get(outgoingElement) - 1);
            if (map.get(outgoingElement) == 0) {
                map.remove(outgoingElement);
            }

            // Add the new element entering the window
            int incomingElement = arr[i];
            map.put(incomingElement, map.getOrDefault(incomingElement, 0) + 1);

            // Add the count of distinct elements for the current window
            result.add(map.size());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        ArrayList<Integer> distinctCounts = countDistinct(arr, k);

        System.out.println("Distinct elements in each window of size " + k + ":");
        for (int count : distinctCounts) {
            System.out.print(count + " ");
        }
    }
}
