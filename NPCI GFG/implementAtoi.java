public class implementAtoi {
    int helper(String s, int i, long num, int sign) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            num = num * sign;
            if (num > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (num < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            return (int) num;
        }

        int digit = s.charAt(i) - '0';
        long next = num * 10 + digit;
        if (sign == 1 && next > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (sign == -1 && next < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return helper(s, i + 1, next, sign);
    }

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }
        return helper(s, i, 0L, sign);
    }
}