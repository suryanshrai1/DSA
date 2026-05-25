import java.util.HashSet;

public class elementsInRange {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        HashSet<Integer> set =  new HashSet<>();
        
        for(int a : arr){
            set.add(a);
        }
        for(int i=start; i<=end;i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}
