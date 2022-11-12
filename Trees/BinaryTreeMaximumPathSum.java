//leetcode 124. Binary Tree Maximum Path Sum
class Solution {
    int maxSum=Integer.MIN_VALUE;
    public int maxpath(TreeNode root){
        if(root==null) return 0; //if null return null
        int left=Math.max(0,maxpath(root.left)); //compare with 0 to avoid negative sum
        int right=Math.max(0,maxpath(root.right)); //compare with 0 to avoid negative sum
        maxSum=Math.max(maxSum,root.val+left+right); //max compare with sum(U shape) of curr root
        return root.val+(Math.max(left,right)); //returning max of left or right pathsum
    }
    public int maxPathSum(TreeNode root) {
        maxpath(root); //method call
        return maxSum;
    }
}
