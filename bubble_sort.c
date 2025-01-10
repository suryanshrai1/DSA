#include<stdio.h>
void bubble_sort(int arr[], int n){
    int temp;
    for(int k = 0; k<n-1; k++){
        // n-k-1 for modified bubble sort, iterating 1 less iteration after every pass
        for(int i =0; i< n-k-1; i++){
            if(arr[0]> arr[i]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            printf("The sorted array is: %d", )
        }
    }
}