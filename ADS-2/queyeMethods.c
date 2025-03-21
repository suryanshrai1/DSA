#include<stdio.h>
#define size 5

int Queue[size];
int front = -1;
int rear = -1;
void enqueue(int val){
    if(rear == size-1){
        printf("queue is already full!");
    }
    if (front == -1)
    {
        front++;
        Queue[++rear] = val;

    }
}
void dequeue(){
    if((front == -1) || (front > rear)){
        printf("Queue is already empty !")
    }
    front++;
}

void display(){
    for(int i = front; i<)
}