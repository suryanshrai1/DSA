public class nextSmallestPalindrome {
    static int[] nextPalindrome(int[] num) {
        int n = num.length;

        //Check if all 9s
        boolean all9 = true;
        for (int d : num) {
            if (d != 9) {
                all9 = false;
                break;
            }
        }
        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] result = num.clone();

        int mid = n / 2;
        int i = mid - 1;
        int j = (n % 2 == 0) ? mid : mid + 1;

        //Check if left < right
        boolean leftSmaller = false;
        while (i >= 0 && result[i] == result[j]) {
            i--;
            j++;
        }

        if (i < 0 || result[i] < result[j]) {
            leftSmaller = true;
        }

        // Step 3: Mirror left to right
        while (i >= 0) {
            result[j] = result[i];
            i--;
            j++;
        }

        // Handle carry if needed
        if (leftSmaller) {
            int carry = 1;

            i = mid - 1;

            if (n % 2 == 1) {
                result[mid] += carry;
                carry = result[mid] / 10;
                result[mid] %= 10;
                j = mid + 1;
            } else {
                j = mid;
            }

            while (i >= 0 && carry > 0) {
                result[i] += carry;
                carry = result[i] / 10;
                result[i] %= 10;
                result[j] = result[i];
                i--;
                j++;
            }
        }
        return result;
    }
}