public class FinalValueCalculator {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String str : operations) {
            if (str.charAt(1) == '+')
                x++;
            else
                x--;
        }
        return x;
    }

    public static void main(String[] args) {
        FinalValueCalculator calculator = new FinalValueCalculator();
        String[] operations = { "++X", "X++", "--X", "X--" };
        int result = calculator.finalValueAfterOperations(operations);
        System.out.println("Final value: " + result);
    }
}
