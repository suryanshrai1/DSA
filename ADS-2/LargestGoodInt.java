public class LargestGoodInt {
    public static String largestGoodInteger(String num) {
        for (int i = 9; i >= 0; i--) {
            String str = String.valueOf(i).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String test = "2244355577799";
        String res = largestGoodInteger(test);
        System.out.println(res);

    }
}
