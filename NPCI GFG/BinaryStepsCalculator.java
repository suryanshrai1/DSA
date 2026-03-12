class BinaryStepsCalculator {

    public int numSteps(String s) {
        int steps = 0;
        StringBuilder sb = new StringBuilder(s);

        while (!sb.toString().equals("1")) {
            if (sb.charAt(sb.length() - 1) == '0') {
                // If even → divide by 2 (remove last bit)
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // If odd → add 1 (handle carry)
                int i = sb.length() - 1;

                while (i >= 0 && sb.charAt(i) == '1') {
                    sb.setCharAt(i, '0');
                    i--;
                }

                if (i >= 0) {
                    sb.setCharAt(i, '1');
                } else {
                    sb.insert(0, '1');
                }
            }
            steps++;
        }

        return steps;
    }

    public static void main(String[] args) {
        BinaryStepsCalculator calculator = new BinaryStepsCalculator();

        String input = "1101";  // Example input
        int result = calculator.numSteps(input);

        System.out.println("Number of steps to reduce " + input + " to 1: " + result);
    }
}