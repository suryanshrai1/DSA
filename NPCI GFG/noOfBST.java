import java.util.*;;

public class noOfBST {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();

        //Precompute Catalan numbers up to n
        long[] catalan = new long[n + 1];
        catalan[0] = 1;
        catalan[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Sort the array to easily find counts of smaller/larger elements
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        
        // Map original values to their sorted index (rank)
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rankMap.put(sortedArr[i], i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int val : arr) {
            // The rank of the value in the sorted array gives the count of smaller elements
            int leftCount = rankMap.get(val);
            // The count of larger elements is total - smaller - 1 (for the root itself)
            int rightCount = n - leftCount - 1;
            
            // The number of BSTs is the product of catalan numbers for left and right subtrees
            int bstCount = (int)(catalan[leftCount] * catalan[rightCount]);
            result.add(bstCount);
        }
        return result;
    }
}