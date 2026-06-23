public class maxNoOfPeopleDefeated {
        int maxPeopleDefeated(int p) {
        // code here
        int cnt=0;
        long curr=1;
        while(p>=curr*curr){
            p-= curr*curr;
            cnt++;
            curr++;
        }
        return cnt;
    }
}
