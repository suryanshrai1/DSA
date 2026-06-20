public class lastDigAPowB {
        public int getLastDigit(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenB == 1 && b.charAt(0) == '0') return 1;
        
        int base = a.charAt(lenA - 1) - '0';
        
        int exp;
        if (lenB == 1) {
            exp = (b.charAt(0) - '0') % 4;
        } else {
            exp = ((b.charAt(lenB - 2) - '0') * 10 + (b.charAt(lenB - 1) - '0')) % 4;
        }
        
        if (exp == 0) exp = 4;
        
        int res = (int)Math.pow(base, exp);
        return res % 10;
    }
}
