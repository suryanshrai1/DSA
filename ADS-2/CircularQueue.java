/*
 * Problem Statement:
Design a circular queue of fixed size k. Implement the following operations:

enqueue(x): Add element x to the queue.

dequeue(): Remove and return the front element of the queue.

front(): Get the front element of the queue.

rear(): Get the rear element of the queue.

isFull(): Return true if the queue is full, false otherwise.

isEmpty(): Return true if the queue is empty, false otherwise.
 */

class CircularQueue {
    private int[] queue;
    private int size, front, rear;

    public CircularQueue(int k) {
        size = k + 1; // We need one extra space to differentiate full and empty
        queue = new int[size];
        front = 0;
        rear = 0;
    }

    // Enqueue operation
    public void enqueue(int x) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = x;
        rear = (rear + 1) % size;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % size;
        return value;
    }

    // Front element
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Rear element
    public int rear() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[(rear - 1 + size) % size];
    }

    // Check if the queue is full
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == rear;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);

        System.out.println(circularQueue.dequeue()); // 1
        System.out.println(circularQueue.front());    // 2
        System.out.println(circularQueue.rear());     // 3
        circularQueue.enqueue(4);
        System.out.println(circularQueue.rear());     // 4
    }
}
