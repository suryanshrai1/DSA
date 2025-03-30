#include <stdio.h>
#define size 5

int Queue[size];
int front = -1;
int rear = -1;

void enqueue(int val) {
    if ((rear + 1) % size == front) {
        printf("Queue is already full!\n");
        return;
    }
    if (front == -1) {
        front = 0; // Initialize front when the first element is added
    }
    rear = (rear + 1) % size; // Circular increment
    Queue[rear] = val;
    printf("Inserted %d\n", val);
}

void dequeue() {
    if (front == -1) {
        printf("Queue is already empty!\n");
        return;
    }
    printf("Removed %d\n", Queue[front]);
    if (front == rear) {
        front = -1; // Queue is now empty
        rear = -1;
    } else {
        front = (front + 1) % size; // Circular increment
    }
}

void display() {
    if (front == -1) {
        printf("Queue is empty!\n");
        return;
    }
    printf("Queue elements: ");
    for (int i = front; i != rear; i = (i + 1) % size) {
        printf("%d ", Queue[i]);
    }
    printf("%d\n", Queue[rear]); // Print the last element
}

int main() {
    enqueue(10);
    enqueue(20);
    enqueue(30);
    display();
    dequeue();
    display();
    enqueue(40);
    enqueue(50);
    enqueue(60); // This should show that the queue is full
    display();
    dequeue();
    display();
    return 0;
}