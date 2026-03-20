/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
import java.util.ArrayList;

public class BSTPredecessorSuccessor {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        ArrayList<Node> res = new ArrayList<>();
        Node pre=null;
        Node suc=null;
        Node curr=root;
        while(curr!=null){
            if(curr.data < key){
                pre=curr;
                curr= curr.right;
            }
            else if(curr.data >key){
                suc=curr;
                curr= curr.left;
            }
            else{//found
                //max in left subtree -predec
                if(curr.left!=null){
                    Node temp=curr.left;
                    while(temp.right!=null){
                        temp = temp.right;
                    }
                    pre=temp;
                }
                //successor
                if(curr.right!= null){
                    Node temp= curr.right;
                    while(temp.left!=null){
                        temp=temp.left;
                    }
                    suc=temp;
                }
                break;
            }
        }
        res.add(pre);
        res.add(suc);
        return res;
    }
}