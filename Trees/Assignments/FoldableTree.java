package Trees;
public class FoldableTree {
    static class Node{
        int val;
        Node left,right;
        Node(int data){
            val=data;
        }
    }
    static boolean isFoldableTree(Node root){
        if(root==null){
            return true;
        }
        return isFoldable(root.left, root.right); //sending left and right side of root
    }
    static boolean isFoldable(Node node1,Node node2){
        if(node1==null&&node2==null) //if both are null return true
        {
            return true;
        }
        if(node1==null||node2==null) //if any one is null return false
        {
            return false;
        }
        return isFoldable(node1.left,node2.right)&&isFoldable(node1.right,node2.left);
    }
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(15);
        root.left.right=new Node(9);
        root.right.left=new Node(11);
        root.right.right=new Node(12);
        root.left.left=new Node(11);
        System.out.print(isFoldableTree(root));
    }
}
