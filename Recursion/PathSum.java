//Leetcode 112. Path Sum
class Solution 
{
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        if(root==null) return false; //if curr node is null return false to break so that it will not check further
        if(root.right==null&&root.left==null&&root.val==sum) return true; //if curr node is leaf node and root.val==sum return true
        return (hasPathSum(root.left,sum-root.val))||(hasPathSum(root.right,sum-root.val)); //recursion call by sending sum-root.val and root.right||root.left
    }
}
