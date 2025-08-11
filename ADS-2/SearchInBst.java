
// Definition for a binary tree node.
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class SearchInBst {
    // Function to search a node in BST.
    boolean search(Node root, int x) {
        
        while(root != null){
 
            if(root.data == x){
                return true;
            }
            if(root.data < x){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }
        return false;
    }

   public static void main(String[] args) {
    /*
              50
             /  \
           30    70
          / \   / \
        20  40 60  80
    */

    Node root = new Node(50);
    root.left = new Node(30);
    root.right = new Node(70);
    root.left.left = new Node(20);
    root.left.right = new Node(40);
    root.right.left = new Node(60);
    root.right.right = new Node(80);

    // object of SearchInBst
    SearchInBst tree = new SearchInBst();

    int keyToSearch = 60; // Change this to test other values
    boolean found = tree.search(root, keyToSearch);

    if (found) {
        System.out.println(keyToSearch + " found in BST.");
    } else {
        System.out.println(keyToSearch + " not found in BST.");
    }
}

}