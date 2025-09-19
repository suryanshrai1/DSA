public class ParenthesesBalancer {
    public int minParentheses(String s) {
        int openCount = 0;
        int closeCount = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else { // c == ')'
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }
        return openCount + closeCount;
    }

    public static void main(String[] args) {
        ParenthesesBalancer balancer = new ParenthesesBalancer();
        
        String input = "(())())";
        int result = balancer.minParentheses(input);
        
        System.out.println("Minimum number of parentheses to balance: " + result);
    }
}
