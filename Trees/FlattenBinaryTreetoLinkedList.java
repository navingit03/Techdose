//Leetcode 114. Flatten Binary Tree to Linked List
//right left root traversal -> building from bottom to up
class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null) return; //if root is null return
        flatten(root.right); //traversal as right left root
        flatten(root.left);
        root.right=prev; //currroot.right=prev
        root.left=null; //left as null
        prev=root; //making prev=currroot
    }
}

//using stack
class Solution {
    Stack<TreeNode> st=new Stack<>();
    public void flatten(TreeNode root) {
        if(root==null) return;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.right!= null){
                st.push(curr.right);
            }
            if(curr.left!= null){
                st.push(curr.left);
            }
            if(!st.isEmpty()){
                curr.right=st.peek();
            }
            curr.left=null;
        }
    }
}
