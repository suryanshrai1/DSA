import java.util.Stack;

class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop(); // the index is popped
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        
        return res;
    }

    public static void main(String[] args) {
        // Sample input
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        
        DailyTemperatures solution = new DailyTemperatures();
        
        // Getting the result from the dailyTemperatures function
        int[] result = solution.dailyTemperatures(temperatures);
        
        // Printing the result
        System.out.print("Result: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
