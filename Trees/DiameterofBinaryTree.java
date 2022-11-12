//Leetcode 543. Diameter of Binary Tree
class Solution {
    int max=0;
    public int findmax(TreeNode root){
        if(root==null) return 0;
        int left=findmax(root.left);
        int right=findmax(root.right);
        max=Math.max(max,left+right); //height=left+right
        return 1+Math.max(left,right); //for curr node 1+ max(left,right)
    }
    public int diameterOfBinaryTree(TreeNode root) {
        findmax(root);
        return max;
    }
}
