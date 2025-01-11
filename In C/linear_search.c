#include <stdio.h>
int main()
{
    int key;
    int arr[4] = {1, 10, 4, 9};
    key = 10;
}
int search(arr, key)
{
    int i; int n;
    for (i = 0; i < n; i++)
    {
        if (key == arr[i])
        {
            return i + 1;
        }

        else
        {
            return -1;
        }
    }
}