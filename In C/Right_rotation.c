#include<stdio.h>

int main() {
    int i, n, k, j = 0;
    int arr[] = {1, 2, 3, 4, 5, 6};
    n = 6;
    k = 2;
    int arr2[6];

    for(i = n - k; i < n; i++) {
        arr2[j] = arr[i];
        j++;
    }

    for(i = 0; i < n - k; i++) {
        arr2[j] = arr[i];
        j++;
    }

    printf("The rotated array is: ");
    for(i = 0; i < n; i++) {
        printf("%d ", arr2[i]);
    }

    return 0;
}
