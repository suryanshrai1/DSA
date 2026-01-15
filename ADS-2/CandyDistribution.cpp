#include <bits/stdc++.h>
using namespace std;

class CandyDistribution {
public:
    static int minimumCandies(vector<int>& arr) {
        int n = arr.size();
        if (n == 0) return 0;

        int total = 1;          // first child gets 1 candy
        int up = 0, down = 0;   // slope lengths
        int peak = 0;           // last peak height

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                up++;
                peak = up;
                down = 0;
                total += 1 + up;
            }
            else if (arr[i] == arr[i - 1]) {
                up = down = peak = 0;
                total += 1;
            }
            else { // arr[i] < arr[i - 1]
                up = 0;
                down++;
                total += 1 + down - (peak >= down ? 1 : 0);
            }
        }
        return total;
    }
};

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << CandyDistribution::minimumCandies(arr) << endl;
    return 0;
}
