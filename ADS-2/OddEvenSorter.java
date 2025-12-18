import java.util.*;

public class OddEvenSorter {
    
    public void sortIt(int[] arr) {
        // Create lists to store odd and even numbers
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        // Separate the numbers
        for (int num : arr) {
            if (num % 2 != 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        // Sort odd in descending order
        Collections.sort(odd, Collections.reverseOrder());

        // Sort even in ascending order
        Collections.sort(even);

        // Merge back into original array
        int i = 0;
        for (int num : odd) {
            arr[i++] = num;
        }
        for (int num : even) {
            arr[i++] = num;
        }
    }

    public static void main(String[] args) {
        // Example array
        int[] arr = {5, 3, 8, 6, 2, 7, 1, 4};

        // Create instance of OddEvenSorter and sort the array
        OddEvenSorter sorter = new OddEvenSorter();
        sorter.sortIt(arr);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
