import java.util.HashMap;
import java.util.Map;

public class palindromicPair {

    public boolean palindromePair(String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            
            for (int j = 0; j <= s.length(); j++) {
                String str1 = s.substring(0, j);
                String str2 = s.substring(j);

                if (isPalindrome(str1)) {
                    String revStr2 = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(revStr2) && map.get(revStr2) != i) {
                        return true;
                    }
                }

                if (j < s.length() && isPalindrome(str2)) {
                    String revStr1 = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(revStr1) && map.get(revStr1) != i) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

}
