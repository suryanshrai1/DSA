class KQueues {
    int n, k;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;

    // Constructor to initialize k queues
    KQueues(int n, int k) {
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        free = 0;

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // Initialize free list
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    // Method to enqueue an element into queue i
    void enqueue(int x, int i) {
        if (isFull()) {
            System.out.println("Queue is full.");
            return;
        }

        int index = free;
        free = next[index];
        arr[index] = x;

        if (isEmpty(i)) {
            front[i] = index;
        } else {
            next[rear[i]] = index;
        }
        rear[i] = index;
        next[index] = -1;
    }

    // Method to dequeue an element from queue i
    int dequeue(int i) {
        if (isEmpty(i)) {
            System.out.println("Queue " + i + " is empty.");
            return -1;
        }

        int index = front[i];
        front[i] = next[index];

        next[index] = free;
        free = index;

        return arr[index];
    }

    // Check if queue i is empty
    boolean isEmpty(int i) {
        return front[i] == -1;
    }

    // Check if any queue is full
    boolean isFull() {
        return free == -1;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        KQueues kQueues = new KQueues(10, 3); // 10 elements, 3 queues

        // Enqueue elements in different queues
        kQueues.enqueue(10, 0); // Enqueue 10 in queue 0
        kQueues.enqueue(20, 1); // Enqueue 20 in queue 1
        kQueues.enqueue(30, 2); // Enqueue 30 in queue 2

        // Dequeue elements from different queues
        System.out.println("Dequeued from queue 0: " + kQueues.dequeue(0)); // Dequeued 10
        System.out.println("Dequeued from queue 1: " + kQueues.dequeue(1)); // Dequeued 20
        System.out.println("Dequeued from queue 2: " + kQueues.dequeue(2)); // Dequeued 30

        // Try to dequeue from empty queue
        System.out.println("Dequeued from queue 1 (empty): " + kQueues.dequeue(1)); // Queue is empty
    }
}
