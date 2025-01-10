#include <stdio.h>

int j;
void insertionSort(int arr[], int N) {
    for(int i = 1; i < N; i++) {
        int key = arr[i];
        j = i - 1;
        while(j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

int main() {
    int arr[5] = {5, 8, 4, 3, 9};
    int N = sizeof(arr) / sizeof(arr[0]);
    insertionSort(arr, N);
    for(int i = 0; i < N; i++) {
        printf("%d ", arr[i]);
    }
    return 0;
}