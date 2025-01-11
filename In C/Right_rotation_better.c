#include<stdio.h>

void reverse(int arr[], int start, int end) {
    int temp;
    while (start < end) {
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}

int main() {
    int i, n = 6, k = 2;
    int arr[] = {1, 2, 3, 4, 5, 6};

    // Normalize k if it's greater than n
    k = k % n;

    // Reverse the first part
    reverse(arr, 0, n - k - 1);
    // Reverse the second part
    reverse(arr, n - k, n - 1);
    // Reverse the entire array
    reverse(arr, 0, n - 1);

    printf("The rotated array is: ");
    for(i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}
