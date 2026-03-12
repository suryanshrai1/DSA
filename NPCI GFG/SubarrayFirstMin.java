import java.util.*;

public class SubarrayFirstMin {

    public static int countSubarrays(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            int nextSmaller = stack.isEmpty() ? n : stack.peek();

            ans += nextSmaller - i;

            stack.push(i);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = countSubarrays(arr);
        System.out.println(result);

        sc.close();
    }
}