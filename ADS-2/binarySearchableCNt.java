import java.util.ArrayDeque;

public class binarySearchableCNt {
        static class Node {
        int l, r;
        long low, high;

        Node(int l, int r, long low, long high) {
            this.l = l;
            this.r = r;
            this.low = low;
            this.high = high;
        }
    }

    public int binarySearchable(int[] arr) {
        int n = arr.length;
        int count = 0;

        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.push(new Node(0, n - 1, Long.MIN_VALUE, Long.MAX_VALUE));

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            if (cur.l > cur.r) continue;

            int mid = (cur.l + cur.r) / 2;
            int val = arr[mid];

            if (val > cur.low && val < cur.high) {
                count++;
            }

            stack.push(new Node(cur.l, mid - 1, cur.low, Math.min(cur.high, val)));
            stack.push(new Node(mid + 1, cur.r, Math.max(cur.low, val), cur.high));
        }
        return count;
    }
}
