import java.util.ArrayList;
import java.util.Collections;

public class listUsingXor {
        public ArrayList<Integer> constructList(int[][] queries) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentXor = 0;
        int q = queries.length;

        // Process queries backwards
        for (int i = q - 1; i >= 0; i--) {
            int type = queries[i][0];
            int val = queries[i][1];

            if (type == 1) {
                // Accumulate the XOR value for all elements existing before this query
                currentXor ^= val;
            } else {
                // For a type 0 query, the element's final value is (val ^ currentXor)
                result.add(val ^ currentXor);
            }
        }

        // Add the initial 0 which is also affected by all type-1 queries
        result.add(0 ^ currentXor);

        Collections.sort(result);
        return result;
    }
}
