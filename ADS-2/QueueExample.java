import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueExample {
    Queue<Integer> q = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        QueueExample example = new QueueExample();
        example.push(4); // Pass the value of n here
    }

    public void push(int n) {
        for (int i = 0; i < n; i++) { 
            System.out.print("Enter a number: ");
            int x = sc.nextInt();
            q.add(x);
            System.out.println("Queue after adding " + x + ": " + q);
            for (int j = 0; j < n; j++) {
                q.add(q.remove());
                System.err.println("Queue after rotating: " + q);
            }
        }
        sc.close(); 
    }
}