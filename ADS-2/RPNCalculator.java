import java.util.Stack;

class ReversePolishNotationEvaluator {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b + a); // Corrected order for addition
            } else if (s.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a); // Corrected order for multiplication
            } else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a); // Corrected order for division
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a); // Corrected order for subtraction
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}

public class RPNCalculator {
    public static void main(String[] args) {
        ReversePolishNotationEvaluator evaluator = new ReversePolishNotationEvaluator();
        
        // Example input in Reverse Polish Notation
        String[] tokens = {"2", "1", "+", "3", "*"}; // (2 + 1) * 3 = 9
        
        // Evaluate the expression
        int result = evaluator.evalRPN(tokens);
        
        // Print the result
        System.out.println("The result of the RPN expression is: " + result);
    }
}
