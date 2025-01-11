#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void selection(int arr[], int N) {
    for(int i = 0; i < N - 1; i++) {
        int minIdx = i;
        for(int j = i + 1; j < N; j++) {
            if(arr[j] < arr[minIdx]) {
                minIdx = j;
            }
        }
        swap(&arr[i], &arr[minIdx]);
    }
}

int main() {
    int arr[5] = {67, 29, 12, 22, 13};
    int N = sizeof(arr) / sizeof(arr[0]);
    selection(arr, N);
    for(int i = 0; i < N; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}
