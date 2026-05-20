import java.util.HashSet;

public class equalToProduct {
    public boolean isProduct(int[] arr, long target) {

        HashSet<Long> set = new HashSet<>();

        for (int num : arr) {

            long curr = num;

            if (curr == 0) {

                if (target == 0 && !set.isEmpty()) {
                    return true;
                }

            } else {

                if (target % curr == 0) {

                    long needed = target / curr;

                    if (set.contains(needed)) {
                        return true;
                    }
                }
            }

            set.add(curr);
        }
        return false;
    }
}
