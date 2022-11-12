//Leetcode 236. Lowest Common Ancestor of a Binary Tree
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) //base case
        {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q); //left call
        TreeNode right=lowestCommonAncestor(root.right,p,q); //right call
        if(left!=null&&right!=null) //if both are found then root is common
        {
            return root; //return root
        }
        return (left==null?right:left); //if anyone of them is found we need to return them
    }
}
