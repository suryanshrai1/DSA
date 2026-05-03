import java.util.ArrayList;

public class sortBySetBitCnt {
    ArrayList<Integer> sortBySetBitCount(int[] arr){
        ArrayList<Integer> list =  new ArrayList<>();
        for(int num : arr){
            list.add(num);
        }
        list.sort((a, b) -> Integer.compare(Integer.bitCount(b), Integer.bitCount(a)));

        return list;
    }
}
