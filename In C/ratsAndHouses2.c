#include <stdio.h>
int rat(int *arr, int noh, int r, int unit)
{
    int result = r * unit;
    int sum = 0;
    for (int i = 0; i < noh; i++)
    {
        sum += arr[i];
        if (result <= sum)
        {
            return i + 1;
        }
    }
    return -1;
}

int main()
{
    int houses[9] = {2, 8, 3, 5, 7, 9, 1, 15};
    int noh = 8;
    int r = 7;
    int unit = 2;

    int result = rat(houses, noh, r, unit);
    printf("Minimum number of houses needed: %d\n", result);
    return 0;
}
