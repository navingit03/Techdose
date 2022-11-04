//Leetcode 437. Path Sum III
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
    int count=0; //initially the count=0
    ArrayList<Integer> list=new ArrayList<>(); //arraylist to add root.val of current path
    public void getCount(TreeNode root,int sum)
    {
        if(root==null)
        {
            return;
        }
        list.add(root.val); //adding current root.val in list
        long currSum=0;
        for(int i=list.size()-1;i>=0;i--) //bottom-up approach as list is traversed from last (i.e : from lastest added val to first added element)
        {
            currSum+=(long)list.get(i); //adding value from curr node to top node 
            if(currSum==sum) //if currSum==sum count++;
            {
                count++;
            }
        }
        getCount(root.left,sum); //root.left recursion call
        getCount(root.right,sum); //root.right recursion call
        list.remove(list.size()-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        getCount(root,targetSum); //method call
        return count; //returning count
    }
}
