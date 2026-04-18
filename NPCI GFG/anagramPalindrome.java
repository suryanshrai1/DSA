import java.util.Set;
import java.util.HashSet;

public class anagramPalindrome {
    boolean canFormPalindrome(String s) {
        // code here
        Set<Character> st = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(st.contains(ch)){
                st.remove(ch);
            }
            else{
                st.add(ch);
            }
        }
        return st.size() <= 1 ? true : false;
    }
}