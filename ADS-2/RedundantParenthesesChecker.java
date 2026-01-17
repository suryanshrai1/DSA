import java.util.Stack;

public class RedundantParenthesesChecker {

    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch != ')') {
                stack.push(ch);
            } else {
                boolean hasOperator = false;

                // Check characters inside the parentheses
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        hasOperator = true;
                    }
                }

                // Remove the opening '('
                stack.pop();

                // If no operator was found, parentheses are redundant
                if (!hasOperator) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "((a+b))";
        String s2 = "(a+(b)/c)";
        String s3 = "(a+b*(c-d))";

        System.out.println(s1 + " -> " + checkRedundancy(s1)); // true
        System.out.println(s2 + " -> " + checkRedundancy(s2)); // true
        System.out.println(s3 + " -> " + checkRedundancy(s3)); // false
    }
}
