import java.util.*;

public class oppPairReduce {
    public ArrayList<Integer> reducePairs(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int current : arr) {
            boolean currentDestroyed = false;

            while (!stack.isEmpty() && isOpposite(stack.peek(), current)) {
                int top = stack.peek();
                int absTop = Math.abs(top);
                int absCurr = Math.abs(current);

                if (absTop < absCurr) {
                    stack.pop();
                } else if (absTop == absCurr) {
                    stack.pop();
                    currentDestroyed = true;
                    break;
                } else {
                    currentDestroyed = true;
                    break;
                }
            }

            if (!currentDestroyed) {
                stack.push(current);
            }
        }
        return new ArrayList<>(stack);
    }

    private boolean isOpposite(int a, int b) {
        return (a > 0 && b < 0) || (a < 0 && b > 0);
    }
}
