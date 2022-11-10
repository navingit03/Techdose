//Continous Tree in which the abs diff between root and its child should be 1
package Trees;
public class ContinousTree {
    static class Node{
        int val;
        Node left,right;
        Node(int data){
            val=data;
            right=left=null;
        }
    }
    static boolean isContinous(Node root){
        if(root==null) return true; //if given root is null return true
        if(root.left==null&&root.right==null) return true; //if it is child node return true
        else if(root.left==null) //if only right child is present
        {
            return (Math.abs(root.val-root.right.val)==1)&&isContinous(root.right);
        }
        else if(root.right==null) //if only left child is present
        {
            return (Math.abs(root.val-root.left.val)==1)&&isContinous(root.left);
        }
        else //if both left and right child is present
        {
            return (Math.abs(root.val-root.right.val)==1)&&(Math.abs(root.val-root.left.val)==1)&&isContinous(root.left)&&isContinous(root.right);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(7);
        root.left=new Node(5);
        root.right=new Node(8);
        root.left.left=new Node(6);
        root.left.right=new Node(4);
        root.right.left=new Node(10);
        System.out.print(isContinous(root));
    }
}
