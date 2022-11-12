//Leetcode 199. Binary Tree Right Side View

//Recursion - if current level is visited first time in reverse preorder(root right left traversal) we need to add root.val
class Solution {
    ArrayList<Integer> list=new ArrayList();
    public void levelOrderBDF(TreeNode root,int level) //reverse preorder (root,right,left)
    {
        if(root==null) return;
        if(level==list.size()) //if curr level is visited first time by checking list size because at each level we add only one element 
        {
            list.add(root.val); //we need to add root.val
        }
        levelOrderBDF(root.right,level+1); //sending right and level+1
        levelOrderBDF(root.left,level+1); //sending left and level+1
    }
    public List<Integer> rightSideView(TreeNode root) {
        levelOrderBDF(root,0); //sending root and curr level
        return list;
    }
}

//BFS
class Solution {
    ArrayList<Integer> list=new ArrayList();
    Queue<TreeNode> q=new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                if(i==size-1){
                    list.add(q.peek().val); //adding last element of each level
                }
                if(q.peek().left!=null) q.add(q.peek().left);
                if(q.peek().right!=null) q.add(q.peek().right);
                q.poll();
            }
        }
        return list;
    }
}
