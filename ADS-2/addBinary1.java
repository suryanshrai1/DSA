public class addBinary1 {
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int bitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int bitB = j >= 0 ? b.charAt(j) - '0' : 0;

            int sum = bitA + bitB + carry;

            result.append(sum % 2);

            carry = sum / 2;

            // Move to the next digits
            i--;
            j--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "d";
        System.out.println(addBinary(a, b));

    }
}
