public class longestConsecPathInBT {
    
    // BRUTFORCE
    // // helper method to find longest path
    // private int findLongestConsec(Node root) {
    // if (root == null) {
    // return 0;
    // }
    // int leftLen = 0;
    // int rightLen = 0;
    // if (root.left != null && root.left.data == root.data + 1) {
    // leftLen = findLongestConsec(root.left);
    // }
    // if (root.right != null && root.right.data == root.data + 1) {
    // rightLen = findLongestConsec(root.right);
    // }

    // return 1 + Math.max(leftLen, rightLen);
    // }

    // public int longestConsecutive(Node root) {
    // // code here
    // if (root == null) {
    // return - 1;
    // }
    // int currAns = findLongestConsec(root);

    // int leftAns = longestConsecutive(root.left);
    // int rightAns = longestConsecutive(root.right);

    // int res = Math.max(currAns, Math.max(rightAns, leftAns));

    // return (res == 1 ? -1: res);
    // }

    // OPTIMAL

    // helper Method
    private void dfs(Node root, Node parent , int curr, int [] longest){
        if(root==null){
            return;
        }
        if(parent != null && root.data == parent.data+1){
            curr++;
        }
        else{
            curr=1;
        }
        longest[0]= Math.max(curr, longest[0]);
        dfs(root.left, root, curr, longest);
        dfs(root.right, root, curr, longest);

    }
    public int longestConsecutive(Node root) {
        if(root== null){
            return -1;
        }
        int [] longest = {0};
        dfs(root, null, 0, longest);

        return (longest[0]== 1 ? -1:longest[0]);
    }
}
