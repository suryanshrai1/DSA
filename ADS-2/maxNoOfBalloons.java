import java.util.HashMap;
import java.util.Map;

public class maxNoOfBalloons {
        public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            if(ch=='b'|| ch=='a' || ch=='l'||ch=='o'||ch=='n'){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        int b= map.get('b');
        int a= map.get('a');
        int l= map.get('l')/2;
        int o=map.get('o')/2;
        int n= map.get('n');

        return Math.min(Math.min(b, a), Math.min(Math.min(l, o), n));

    }
}
