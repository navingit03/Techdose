//creating a tree of array and printing in inorder,preorder,postorder
public class TreeTraversal {
    Node root=null;
    static class Node //node structure
    {
        int val;
        Node left,right;
        Node(int val) //constructor
        {
            this.val=val;
        }
    }
    public static TreeTraversal.Node buildTree(int arr[],int index)
    {
        Node root=null;
        if(index<arr.length){
            root=new Node(arr[index]);
            root.left=buildTree(arr, 2*index);
            root.right=buildTree(arr, 2*index+1);
        }
        return root;
    }
    public static void inorder(Node root) {
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    public static void preorder(Node root) {
        if(root!=null){
            System.out.print(root.val+" ");
            inorder(root.left);
            inorder(root.right);
        }
    }
    public static void postorder(Node root) {
        if(root!=null){
            inorder(root.left);
            inorder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String[] args) {
        TreeTraversal tree=new TreeTraversal();
        int arr[]={0,1,2,3,4,5};
        tree.root=buildTree(arr,1);
        inorder(tree.root);
        System.out.println();
        preorder(tree.root);
        System.out.println();
        postorder(tree.root);
        /*
        4 2 5 1 3 inorder
        1 4 2 5 3 preorder
        4 2 5 3 1 postorder
        */
    }
}
