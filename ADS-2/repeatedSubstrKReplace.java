import java.util.HashMap;
import java.util.Map;

public class repeatedSubstrKReplace {
    public boolean kSubstr(String s, int k) {
        // code here
        int n= s.length();
        if(n%k!= 0) return false;
        Map<String, Integer> mp = new HashMap<>();
        
        for (int i = 0; i <n; i++) {
            mp.put(s.substring(i, i+k), mp.getOrDefault(s.substring(i,i+k), 0)+1);    
        }
        if(mp.size()==1) return true;
        if(mp.size() != 2) return false;

        for(int i : mp.values()){
            if(i==1 || i== (n/k-1)){
                return true;
            }
        }
        return false;
    }
}
