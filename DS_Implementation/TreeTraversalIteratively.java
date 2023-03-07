inorder 4 2 6 5 7 8 1 3 9 
preorder 1 2 4 5 6 7 8 3 9
postorder 4 6 8 7 5 2 9 3 1
package BuildDS;

import java.util.Stack;

public class TreeTraversalIteratively {
    static TreeNode root;
    static class TreeNode
    {
        int val;
        TreeNode left,right;
        TreeNode(int val)
        {
            this.val=val;
            left=null;
            right=null;
        }
    }
    public static void inorder(TreeNode root)
    {
        TreeNode curr=root;
        Stack<TreeNode> st=new Stack<>();
        while(curr!=null || !st.isEmpty())
        {
            while(curr!=null)
            {
                st.push(curr);
                curr=curr.left; //going left till it became null
            }
            curr=st.pop();
            System.out.print(curr.val+" ");
            curr=curr.right; //make right call
        }
    }
    public static void preorder(TreeNode root)
    {
        TreeNode curr=root;
        Stack<TreeNode> st=new Stack<>();
        st.push(curr);
        while(!st.isEmpty())
        {
            TreeNode top=st.pop(); //pop the node on top of stack
            System.out.print(top.val+" ");
            if(top.right!=null) //pushing right first so it will not be in top of the stack
            {
                st.push(top.right);
            }
            if(top.left!=null) //pushing left now so that it will be in the top
            {
                st.push(top.left);
            }
        }
    }
    public static void postorder(TreeNode root)
    {
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>(); //stack2 is used to reverse the values
        st1.push(root);
        while(!st1.isEmpty())
        {
            TreeNode top=st1.pop();
            st2.push(top);
            if(top.left!=null)
            {
                st1.push(top.left);
            }
            if(top.right!=null)
            {
                st1.push(top.right);
            }
        }
        while(!st2.isEmpty())
        {
            System.out.print(st2.pop().val+" ");
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
