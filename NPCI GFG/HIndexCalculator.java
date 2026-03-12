import java.util.Arrays;

public class HIndexCalculator {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= (n - i)) {
                return n - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndexCalculator calculator = new HIndexCalculator();
        
        // Example input
        int[] citations = {3, 0, 6, 1, 5};
        
        int hIndex = calculator.hIndex(citations);
        System.out.println("H-Index: " + hIndex);  // Output: H-Index: 3
    }
}