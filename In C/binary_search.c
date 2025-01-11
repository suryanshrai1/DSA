#include <stdio.h>

int binarySearch(int arr[], int key, int beg, int end)
{
    while (beg <= end)
    {
        int mid = beg + (end - beg) / 2;
        if (key == arr[mid])
        {
            return mid;
        }
        else if (key > arr[mid])
        {
            beg = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
    return -1;
}

int main(void)
{
    int beg, end, mid, key, i, n;

    int arr[4] = {2,5,8,9};
    n = sizeof(arr) / sizeof(arr[0]);
    beg = 0;
    end = n - 1;
    key = 9;

    int result = binarySearch(arr, key, beg, end);
    if (result != -1)
    {
        printf("Element found at index %d\n", result);
    }
    else
    {
        printf("Element not found\n");
    }

    return 0;
}
