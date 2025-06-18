// Problem:
// Implement a queue using two stacks.

import java.util.Stack;

public class QueueUsing2Stack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        peek(); // Ensure stack2 has current elements
        return stack2.pop();
    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method to test the queue
    public static void main(String[] args) {
        QueueUsing2Stack queue = new QueueUsing2Stack();

        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Front element is: " + queue.peek()); // Should print 10
        System.out.println("Removed element: " + queue.pop());   // Should remove 10
        System.out.println("Front element is now: " + queue.peek()); // Should print 20
        System.out.println("Is queue empty? " + queue.empty());  // Should print false

        queue.pop();
        queue.pop();

        System.out.println("Is queue empty after removing all elements? " + queue.empty()); // Should print true
    }
}
