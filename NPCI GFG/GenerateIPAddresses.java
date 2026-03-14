// import java.util.ArrayList;

// public class GenerateIPAddresses {

//     public ArrayList<String> generateIp(String s) {
//         ArrayList<String> result = new ArrayList<>();
//         if (s == null || s.length() < 4 || s.length() > 12) {
//             return result;
//         }
//         backtrack(s, 0, 0, "", result);
//         return result;
//     }

//     private void backtrack(String s, int index, int segment, String currentIp, ArrayList<String> result) {
//         if (index == s.length() && segment == 4) {
//             result.add(currentIp.substring(0, currentIp.length() - 1)); // Remove trailing dot
//             return;
//         }

//         if (index == s.length() || segment == 4) {
//             return;
//         }

//         for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
//             String sub = s.substring(index, index + len);
//             if (isValid(sub)) {
//                 backtrack(s, index + len, segment + 1, currentIp + sub + ".", result);
//             }
//         }
//     }

//     private boolean isValid(String s) {
//         if (s.length() > 1 && s.charAt(0) == '0') {
//             return false;
//         }

//         if (s.length() > 3) {
//             return false;
//         }

//         int num = Integer.parseInt(s);
//         return num >= 0 && num <= 255;
//     }

//     public static void main(String[] args) {
//         GenerateIPAddresses obj = new GenerateIPAddresses();

//         String input = "25525511135";
//         ArrayList<String> result = obj.generateIp(input);

//         System.out.println("Possible IP Addresses:");
//         for (String ip : result) {
//             System.out.println(ip);
//         }
//     }
// }

class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<SimpleEntry<Node, Integer>> q = new LinkedList<>();
        q.add(new SimpleEntry<>(root, 0));
        while (!q.isEmpty()) {
            SimpleEntry<Node, Integer> current = q.poll();
            Node currentNode = current.getKey();
            int hd = current.getValue();
            if (!map.containsKey(hd)) {
                map.put(hd, currentNode.data);
            }
            if (currentNode.left != null) {
                q.add(new SimpleEntry<>(currentNode.left, hd - 1));
            }
            if (currentNode.right != null) {
                q.add(new SimpleEntry<>(currentNode.right, hd + 1));
            }
        }
        for (int value : map.values()) {
            res.add(value);
        }
        return res;
    }
}