//Leetcode 113. Path Sum II
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    public void helper(TreeNode root,int targetSum,int currsum,List< Integer> temp)
    {
        currsum+=root.val; //currsum+=root.val
        temp.add(root.val); //adding root.val to temp(list)
        if(root.left==null&&root.right==null) //if curr node is leaf we need to check if path sum is equal=target
        {
            if(currsum==targetSum) //if equal then we need to add the path to result
            {
                result.add(new ArrayList<>(temp)); //temp is added as new ArrayList so that further change in temp will not affect other temp list as same temp list will be passed for all the recursion call
                temp.remove(temp.size()-1); //removing leaf node to find other paths
                return;
            }
            else
            {
                temp.remove(temp.size()-1); //removing leaf node to find other paths as currsum!=target
                return;
            }
        }
        if(root.left!=null) //if there is left node to curr node
        {
            helper(root.left,targetSum,currsum,temp);
        }
        if(root.right!=null) //if there is right node to curr node
        {
        helper(root.right,targetSum,currsum,temp);
        }
        temp.remove(temp.size()-1); //removing node which is added at starting of the method (ex if leafnodes are removed then we need to remove parent of leaf node to find other paths)
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result=new ArrayList<>(); //creating list<list<Integer>> to find path==sum and add as list
        if(root==null) return result;
        helper(root,targetSum,0,new ArrayList<>()); //dfs method with currsum=0
        return result;
    }
}
