import java.util.ArrayList;

public class BinaryStringGenerator {
    
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateBinaryStrings(n, "", result);
        return result;
    }

    private void generateBinaryStrings(int n, String current, ArrayList<String> result) {
        // Base case: when length of current string is equal to n
        if (current.length() == n) {
            result.add(current);
            return;
        }

        // Recurse by adding '0' and then '1'
        generateBinaryStrings(n, current + "0", result);
        generateBinaryStrings(n, current + "1", result);
    }

    public static void main(String[] args) {
        BinaryStringGenerator generator = new BinaryStringGenerator();
        int n = 3; // Example: generate all binary strings of length 3
        ArrayList<String> binaryStrings = generator.binstr(n);

        System.out.println("Binary strings of length " + n + ":");
        for (String s : binaryStrings) {
            System.out.println(s);
        }
    }
}
