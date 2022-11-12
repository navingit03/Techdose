//Leetcode 105. Construct Binary Tree from Preorder and Inorder Traversal
class Solution {
    public TreeNode buildBT(int []preorder,int preStart,int preEnd,int inorder[],int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd||inStart>inEnd) return null; //if invaild index return null
        TreeNode root=new TreeNode(preorder[preStart]); //creating a node of curr preorder[preStart]
        int inRoot=map.get(preorder[preStart]); //find preorder[preStart] in map to get inroot(index) of root in inorder array
        int rootsOnLeft=inRoot-inStart; //no of nodes on left of curr root in inorder array
        root.left=buildBT(preorder,preStart+1,preStart+rootsOnLeft,inorder,inStart,inRoot-1,map); //from instart to inroot will be on left side of root
        root.right=buildBT(preorder,preStart+rootsOnLeft+1,preEnd,inorder,inRoot+1,inEnd,map);//from inroot to inend will be on right side of root
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=buildBT(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map); //method call
        return root;

    }
}
