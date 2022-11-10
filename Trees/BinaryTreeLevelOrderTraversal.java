//Leetcode 102. Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> list=new ArrayList<>(); //creating list of list for result
       if(root==null) return list; //if input is null return list
       Queue<TreeNode> q=new LinkedList<>(); //queue is used for level order traversal
       q.add(root); //adding root to queue
       while(!q.isEmpty())
       {
           int size=q.size(); //finding size of curr level 
           List<Integer> lvl=new ArrayList<>(); //list to store elements of curr level
           for(int i=0;i<size;i++)
           {
               if(q.peek().left!=null) //adding if q.peek() has left for next level
               {
                   q.add(q.peek().left);
               }
               if(q.peek().right!=null) //adding if q.peek() has right for next level
               {
                   q.add(q.peek().right);
               }
               lvl.add(q.poll().val); //polling curr level elements
           }
           list.add(lvl); //adding lvl to list
       }
       return list;
    }
}
