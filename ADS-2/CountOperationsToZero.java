public class CountOperationsToZero {

    public int countOperations(int num1, int num2) {
        int operations = 0;
        while (num1 > 0 && num2 > 0) {
            operations++;
            if (num1 >= num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        CountOperationsToZero solution = new CountOperationsToZero();
        
        // Example test cases
        int num1 = 10;
        int num2 = 10;
        int result = solution.countOperations(num1, num2);
        System.out.println("Number of operations for (" + num1 + ", " + num2 + "): " + result);

        num1 = 5;
        num2 = 3;
        result = solution.countOperations(num1, num2);
        System.out.println("Number of operations for (" + num1 + ", " + num2 + "): " + result);

        num1 = 0;
        num2 = 5;
        result = solution.countOperations(num1, num2);
        System.out.println("Number of operations for (" + num1 + ", " + num2 + "): " + result);
    }
}
