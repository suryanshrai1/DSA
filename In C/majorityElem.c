
#include<stdio.h>

int majorityElem(int arr[], int n) {
    int cand = -1, count = 0;
    
    for (int i = 0; i < n; i++) {
        if (count == 0) {
            cand = arr[i];
            count = 1;
        } else if (arr[i] == cand) {
            count++;
        } else {
            count--;
        }
    }
    
    count = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] == cand) {
            count++;
        }
    }
    
    if (count > n / 2) {
        return cand;
    } else {
        return -1;
    }
}

int main() {
    int t;
    scanf("%d", &t);
    
    while (t--) {
        int n;
        scanf("%d", &n);
        int arr[n];
        
        for (int i = 0; i < n; i++) {
            scanf("%d", &arr[i]);
        }
        
        printf("%d\n", majorityElem(arr, n));
    }

    return 0;
}
+
