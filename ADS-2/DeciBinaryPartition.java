public class DeciBinaryPartition {

    public int minPartitions(String n) {
        int maxDigit = 0;

        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
        }
        return maxDigit;
    }

    public static void main(String[] args) {
        DeciBinaryPartition solution = new DeciBinaryPartition();

        String input = "82734";  // Example input
        int result = solution.minPartitions(input);

        System.out.println("Minimum number of deci-binary partitions: " + result);
    }
}