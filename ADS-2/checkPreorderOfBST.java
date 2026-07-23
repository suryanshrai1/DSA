import java.util.List;
import java.util.Stack;

public class checkPreorderOfBST {
        public boolean canRepresentBST(List<Integer> arr) {
        // code here
        Stack<Integer> st = new Stack<>();
        int root= Integer.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            int curr= arr.get(i);
            if(curr < root){
                return false;
            }
            while (!st.isEmpty() && st.peek() <curr) {
                root=st.pop();
            }
            st.push(curr);
        }
        return true;
    }
}
