import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
        public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int length = 2; length <= 9; length++) {
            for (int start = 1; start <= 10 - length; start++) {
                int num = 0;

                for (int digit = start; digit < start + length; digit++) {
                    num = num * 10 + digit;
                }

                if (low <= num && num <= high) {
                    ans.add(num);
                }
            }
        }

        return ans;
    }
}
