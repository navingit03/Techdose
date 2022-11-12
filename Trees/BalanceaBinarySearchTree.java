//Leetcode 1382. Balance a Binary Search Tree
class Solution {
    ArrayList<TreeNode> list =new ArrayList<>();
    public TreeNode buildBalanceBST(int low,int high)
    {
        if(low>high) return null; //invalid condition
        int mid=low+(high-low)/2; //finding mid which will be our root
        TreeNode root=list.get(mid); //root=list.get(mid)
        root.left=buildBalanceBST(low,mid-1); //till mid will be on left subtree
        root.right=buildBalanceBST(mid+1,high); //from mid to high will be on the right subtree
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        list.add(root); //adding inorder in list
        inorder(root.right);
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root); //adding inorder in list
        return buildBalanceBST(0,list.size()-1);
    }
}
