
#include <stdio.h>

void zTraversal(int matrix[500][500], int n) {
    // Top row traversal
    for (int j = 0; j < n; j++) {
        printf("%d ", matrix[0][j]);
    }

    // Diagonal traversal
    for (int i = 1; i < n; i++) {
        printf("%d ", matrix[i][n - 1 - i]);
    }

    // Bottom row traversal
    for (int j = 1; j < n; j++) {
        printf("%d ", matrix[n - 1][j]);
    }
    printf("\n");
}

int main() {
    int T;
    scanf("%d", &T);

    while (T--) {
        int n;
        scanf("%d", &n);

        int matrix[500][500];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &matrix[i][j]);
            }
        }

        zTraversal(matrix, n);
    }

    return 0;
}
