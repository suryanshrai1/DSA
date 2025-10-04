import java.util.*;

public class ExpressionAddOperators {

    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> result = new ArrayList<>();
        backtrack(result, "", s, target, 0, 0, 0);
        Collections.sort(result);
        return result;
    }

    private void backtrack(ArrayList<String> result, String path, String s, int target, int idx, long eval, long prev) {
        if (idx == s.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            // Avoid operands with leading zeros
            if (i != idx && s.charAt(idx) == '0') break;

            String currStr = s.substring(idx, i + 1);
            long currNum = Long.parseLong(currStr);

            if (idx == 0) {
                // First operand, just take it without operator
                backtrack(result, currStr, s, target, i + 1, currNum, currNum);
            } else {
                // Try '+'
                backtrack(result, path + "+" + currStr, s, target, i + 1, eval + currNum, currNum);

                // Try '-'
                backtrack(result, path + "-" + currStr, s, target, i + 1, eval - currNum, -currNum);

                // Try '*'
                backtrack(result, path + "*" + currStr, s, target, i + 1, eval - prev + prev * currNum, prev * currNum);
            }
        }
    }

    public static void main(String[] args) {
        ExpressionAddOperators solver = new ExpressionAddOperators();

        String s1 = "124";
        int target1 = 9;
        System.out.println("Input: s = \"" + s1 + "\", target = " + target1);
        System.out.println("Output: " + solver.findExpr(s1, target1));

        String s2 = "125";
        int target2 = 7;
        System.out.println("Input: s = \"" + s2 + "\", target = " + target2);
        System.out.println("Output: " + solver.findExpr(s2, target2));

        String s3 = "12";
        int target3 = 12;
        System.out.println("Input: s = \"" + s3 + "\", target = " + target3);
        System.out.println("Output: " + solver.findExpr(s3, target3));

        String s4 = "987612";
        int target4 = 200;
        System.out.println("Input: s = \"" + s4 + "\", target = " + target4);
        System.out.println("Output: " + solver.findExpr(s4, target4));
    }
}
