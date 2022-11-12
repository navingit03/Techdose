//Leetcode 98. Validate Binary Search Tree
class Solution {
    public boolean inRange(TreeNode root,int min,int max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max) //curr root value is not in range then false
        {
            return false;
        }
        return inRange(root.left,min,root.val)&&inRange(root.right,root.val,max); //checking for left and right subtree
    }
    public boolean isValidBST(TreeNode root) {
        return inRange(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
