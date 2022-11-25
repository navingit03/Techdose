package Trees;

import java.util.*;

public class IterationTraversal {
    static TreeNode root;
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data){
            val=data;
        }
    }
    public static void inorder(TreeNode root){
        TreeNode curr=root;
        Stack<TreeNode> st=new Stack<>();
        while(curr!=null||!st.empty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left; //pushing till left reach null
            }
            curr=st.pop(); //poping top
            System.out.print(curr.val+" ");
            curr=curr.right; //after printing left calling right
        }
    }
    public static void preorder(TreeNode root){
        Stack<TreeNode> st=new Stack<>();
        st.push(root); //pushing root
        while(!st.empty()){
            TreeNode top=st.pop(); //poping top
            System.out.print(top.val+" "); //print top.val
            if(top.right!=null) //pushing right first
            {
                st.push(top.right);
            }
            if(top.left!=null) //pushing left next as it need to be in st top
            {
                st.push(top.left);
            }
        }
    }
    public static void postorder(TreeNode root){
        Stack<TreeNode> st1=new Stack<>(); //stack to push left and right
        Stack<TreeNode> st2=new Stack<>(); //to store output in LIFO order
        st1.push(root); //pushing root to st1
        while(!st1.isEmpty()){
            TreeNode top=st1.pop(); //poping st1
            st2.push(top); //pushing it st2
            if(top.left!=null) //pushing top.left in st1
            {
                st1.push(top.left);
            }
            if(top.right!=null) //pushing top.right in st1
            {
                st1.push(top.right);
            }
        }
        while(!st2.empty()){
            System.out.print(st2.pop().val+" "); //print output in st2
        }
    }
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.left.right.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }
}
