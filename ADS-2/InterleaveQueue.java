import java.util.*;

public class InterleaveQueue {

    public static void rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        if (n % 2 != 0) return; // queue size must be even

        int half = n / 2;
        Queue<Integer> firstHalf = new LinkedList<>();

        // Store first half of the queue
        for (int i = 0; i < half; i++) {
            firstHalf.add(q.poll());
        }

        // Interleave first half with second half
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.poll());
            q.add(q.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Example input
        q.add(2);
        q.add(4);
        q.add(3);
        q.add(1);

        System.out.println("Original Queue: " + q);

        rearrangeQueue(q);

        System.out.println("Interleaved Queue: " + q);
    }
}
