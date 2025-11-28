import java.util.*;

public class SubsetXORFinder {

    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        int mod = n % 4;

        if (mod == 0) {
            for (int i = 1; i <= n; i++) ans.add(i);
            return ans;
        }

        int remove = -1;

        if (mod == 1) {
            remove = (1 ^ n); // S(n) = 1 → missing = 1 ^ n
            if (remove == 0 || remove > n) {
                // corner case n = 1
                ans.add(1);
                return ans;
            }
        } else if (mod == 2) {
            remove = 1;
        } else { // mod == 3
            remove = n;
        }

        for (int i = 1; i <= n; i++) {
            if (i != remove) ans.add(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> result = subsetXOR(n);

        // Print result in standard format: [a, b, c]
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
