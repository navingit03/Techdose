package Trees;
public class InorderSuccessor {
    static TreeNode root;
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data){
            val=data;
        }
    }
    public static void inordersuccessor(TreeNode root,TreeNode p){
        TreeNode successor=null;
        while(root!=null){
            if(root.val<=p.val) //if root.val<= p.val
            {
                root=root.right; //moving root to right to find greater 
            }else{
                successor=root; //storing root before going left as left will have lesser
                root=root.left;
            }
        }
        System.out.println(successor.val); //12 is next greater number of 10 in tree 
        
    }
    public static void inorderpredecessor(TreeNode root,TreeNode p){
        TreeNode predecessor=null;
        while(root!=null){
            if(root.val<p.val){ //if root.val< p.val
                predecessor=root; //storing root before going right as right will have greater
                root=root.right;
            }else{
                root=root.left; //moving root to left to find lesser
            }
        }
        System.out.println(predecessor.val); //8 is next lesser number of 10 in tree
    }
    public static void main(String[] args) {
        root = new TreeNode(20);//inserting values;
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right=new TreeNode(22);
        inordersuccessor(root,root.left.right.left); //sending root and 10 to find successor
        inorderpredecessor(root,root.left.right.left); //sending root and 10 to find predecessor
    }
}
