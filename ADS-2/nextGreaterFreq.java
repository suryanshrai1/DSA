import java.util.*;

class nextGreaterFreq {
    public static ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && freq.get(arr[i]) > freq.get(arr[st.peek()])) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        // Converting array to ArrayList and return
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : res) {
            result.add(x);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 1, 3, 2, 1 };
        ArrayList<Integer> result = nextFreqGreater(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}