//Leetcode 993. Cousins in Binary Tree
class Solution {
    int lvl1=-1;
    int lvl2=-1;
    TreeNode p1=null;
    TreeNode p2=null;
    public void findXY(TreeNode root,int x,int y,int level,TreeNode parent){
        if(root==null) return;
        if(root.val==x) //if x is found updating x level and parent
        {
            lvl1=level;
            p1=parent;
            return;
        }
        if(root.val==y) //if x is found updating x level and parent
        {
            lvl2=level;
            p2=parent;
            return;
        }
        findXY(root.left,x,y,level+1,root); //sending curr root as parent for next level
        findXY(root.right,x,y,level+1,root); //sending curr root as parent for next level
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        findXY(root,x,y,0,null);
        return ((lvl1==lvl2)&&(p1!=p2));
    }
}
