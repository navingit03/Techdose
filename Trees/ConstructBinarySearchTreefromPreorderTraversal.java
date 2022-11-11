//Leetcode 1008. Construct Binary Search Tree from Preorder Traversal
//TC : O(n^2)
class Solution {
    public TreeNode buildbst(TreeNode root,int val){
        if(root==null){
            return root=new TreeNode(val);
        }
        if(root.val>val){
            root.left=buildbst(root.left,val);
        }
        else{
            root.right=buildbst(root.right,val);
        }
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
      TreeNode root=null;
      for(int element:preorder){
        root=buildbst(root,element);
      }  
      return root;
    }
}

//TC : O(n log n)
class Solution {
    public void buildBST(TreeNode root,int data){
        if(root.val>data){
            if(root.left==null){
                root.left=new TreeNode(data);
            }else{
                buildBST(root.left,data);
            }
        }
        else{
            if(root.right==null){
                root.right=new TreeNode(data);
            }else{
                buildBST(root.right,data);
            }
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            buildBST(root,preorder[i]);
        }
        return root;
    }
}

//TC : O(n)
class Solution {
    int index=0;
    public TreeNode buildBST(int[] preorder,int bound){
        if(index==preorder.length||preorder[index]>bound){
            return null;
        }
        TreeNode root=new TreeNode(preorder[index++]);
        root.left=buildBST(preorder,root.val); //left of tree should be lower than root.val so it(root.val) is sent as bound
        root.right=buildBST(preorder,bound); //right can be upto bound
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MAX_VALUE);
    }
}
