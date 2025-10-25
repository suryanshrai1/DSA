import java.util.PriorityQueue;

public class MinimizeArraySumOperations {

    public int minOperations(int[] arr) {
        double currentSum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b, a));

        // Calculate total sum and add all elements to the max heap
        for (int num : arr) {
            currentSum += num;
            maxHeap.add((double) num);
        }

        double targetSum = currentSum / 2.0;
        int operations = 0;

        // Keep halving the largest element until the sum is reduced by half
        while (currentSum > targetSum) {
            double largest = maxHeap.poll();
            double halved = largest / 2.0;
            currentSum = currentSum - largest + halved;
            maxHeap.add(halved);
            operations++;
        }

        return operations;
    }

    // Main method to test the function
    public static void main(String[] args) {
        MinimizeArraySumOperations solution = new MinimizeArraySumOperations();

        int[] arr = {5, 19, 8, 1};
        int result = solution.minOperations(arr);

        System.out.println("Minimum number of operations: " + result);
    }
}
