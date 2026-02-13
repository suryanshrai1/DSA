import java.util.*;

class SGTree {
    int[] seg;

    SGTree(int n) {
        seg = new int[4 * n + 1];
    }

    public void build(int index, int low, int high, int[] arr) {
        if (low == high) {
            seg[index] = arr[low];
            return;
        }

        int mid = low + (high - low) / 2;
        build(2 * index + 1, low, mid, arr);
        build(2 * index + 2, mid + 1, high, arr);

        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }

    public int query(int index, int low, int high, int l, int r) {
        // No Overlap
        if (l > high || r < low)
            return Integer.MAX_VALUE;

        // Complete Overlap
        if (low >= l && high <= r)
            return seg[index];

        // Partial Overlap
        int mid = low + (high - low) / 2;
        int left = query(2 * index + 1, low, mid, l, r);
        int right = query(2 * index + 2, mid + 1, high, l, r);

        return Math.min(left, right);
    }

    public void update(int index, int low, int high, int i, int val) {
        if (low == high) {
            seg[index] = val;
            return;
        }

        int mid = low + (high - low) / 2;

        if (i <= mid)
            update(2 * index + 1, low, mid, i, val);
        else
            update(2 * index + 2, mid + 1, high, i, val);

        seg[index] = Math.min(seg[2 * index + 1], seg[2 * index + 2]);
    }

    public void print() {
        for (int value : seg) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SGTree seg = new SGTree(n);
        seg.build(0, 0, n - 1, arr);

        int q = sc.nextInt();

        while (q-- > 0) {
            int type = sc.nextInt();

            if (type == 1) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                System.out.println(seg.query(0, 0, n - 1, l, r));
            } else {
                int i = sc.nextInt();
                int val = sc.nextInt();
                seg.update(0, 0, n - 1, i, val);
                arr[i] = val;
            }
        }

        sc.close();
    }
}
