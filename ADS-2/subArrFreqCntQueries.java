import java.util.*;

public class subArrFreqCntQueries {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
        int n= arr.length;
        Map<Integer, ArrayList<Integer>> posMap = new HashMap<>();

        for(int i=0;i<n;i++){
            posMap.computeIfAbsent(arr[i], k-> new ArrayList<>()).add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for(int [] query : queries){
            int l = query[0];
            int r= query[1];
            int x= query[2];
            if(!posMap.containsKey(x)){
                ans.add(0);
                continue;
            }
            ArrayList<Integer> pos= posMap.get(x);

            int left= lowerBound(pos, l);
            int right = upperBound(pos, r);

            ans.add(right-left);

        }
        return ans;
    }
    private int lowerBound(ArrayList<Integer> list, int t ){
        int low=0;
        int hi= list.size();
        while(low<hi){
            int mid= low+(hi-low)/2;
            if(list.get(mid) < t){
                low=mid+1;
            }
            else{
                hi=mid;
            }
        }
        return low;
    }
    private int upperBound(ArrayList<Integer> list, int t){
        int low= 0;
        int hi=list.size();

        while(low < hi){
            int mid=low+(hi-low)/2;
            if(list.get(mid) <= t){
                low= mid+1;
            }
            else{
                hi=mid;
            }
        }
        return low;
    }
}