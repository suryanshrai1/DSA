// Given a list of strings representing an expression in Reverse Polish Notation, evaluate the expression and return the result.

import java.util.Stack;

public class EvaluateRPN {
    
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                // Push number to stack
                stack.push(Integer.parseInt(token));
            }
        }
        
        // The final result will be the only element left in the stack
        return stack.pop();
    }

    // Helper function to check if a string is an operator
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    // Helper function to apply the operator on two operands
    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b; // Integer division
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result 1: " + evalRPN(tokens1)); // Output: 9
        
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result 2: " + evalRPN(tokens2)); // Output: 6
    }
}
