public class DeleteColumnsToMakeSorted {

    public static int minDeletionSize(String[] strs) {
        int count = 0;
        int rows = strs.length;
        int cols = strs[0].length();

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                if (strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};
        int result = minDeletionSize(strs);
        System.out.println("Minimum columns to delete: " + result);
    }
}
