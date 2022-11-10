//Leetcode 103. Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>(); //creating list of list for result
        Queue<TreeNode> q=new LinkedList<>(); //queue is used for level order traversal
        if(root==null) return list;
        q.add(root); //adding root to queue
        int c=0;
        while(!q.isEmpty()){
            int size=q.size(); //finding size of curr level 
            List<Integer> lvl=new ArrayList<>(); //list to store elements of curr level
            c++;
            for(int i=0;i<size;i++){
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
            if(c%2==0){
                Collections.reverse(lvl); //if odd level reverse the list
            }
            list.add(lvl);
        }
        return list;
    }
}
