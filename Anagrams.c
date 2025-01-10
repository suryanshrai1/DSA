
#include <stdio.h>
#include <string.h>
#define CH_COUNT 256

int Anagrams(const char* s1, const char* s2) {
    int c1[CH_COUNT] = {0};
    int c2[CH_COUNT] = {0};

    if (strlen(s1) != strlen(s2)) {
        return 0;
    }

    for (int i = 0; s1[i] != '\0'; i++) {
        c1[(unsigned char)s1[i]]++;
    }

    for (int i = 0; s2[i] != '\0'; i++) {
        c2[(unsigned char)s2[i]]++;
    }

    for (int i = 0; i < CH_COUNT; i++) {
        if (c1[i] != c2[i]) {
            return 0;
        }
    }
    return 1;
}

int main() {
    int num;
    scanf("%d", &num);

    for (int i = 0; i < num; i++) {
        char s1[100001];
        char s2[100001];

        scanf("%s", s1);
        scanf("%s", s2);

        if (Anagrams(s1, s2)) {
            printf("True\n");
        } else {
            printf("False\n");
        }
    }

    return 0;
}
