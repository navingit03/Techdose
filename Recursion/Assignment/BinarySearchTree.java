import java.util.*;
public class BinaryTreeTraversal {
    static Node root=null;
    static class Node //node is defined
    {
        int data;
        Node left,right;
        Node(int val)
        {
            data=val;
            right=null;
            left=null;
        }
    }
    public static void insert(Node root,int val)
    {
        if(val<root.data) //if val is less than root.data we need to insert in left
        {
            if(root.left!=null) //if there is a left node already then we need to send left and val to insert method
            {
                insert(root.left, val);
            }
            else{
                root.left=new Node(val); //if there is no left then we can create new left node to the root using constructor 
            }
        }
        else //if val is greater than root.data we need to insert in right
        {
            if(root.right!=null)
            {
                insert(root.right, val); //if there is a right node already then we need to send right and val to insert method
            }else{
                root.right=new Node(val); //if there is no right then we can create new left node to the root using constructor
            }
        }
    }
    public static void preorder(Node root)
    {
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void postorder(Node root){
        if(root!=null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        root=new Node(arr[0]); 
        for(int i=1;i<n;i++)
        {
            insert(root,arr[i]); //sending values to insert
        }
        System.out.print("Preorder : ");
        preorder(root);
        System.out.print("\nInorder : ");
        inorder(root);
        System.out.print("\nPostorder : ");
        postorder(root);
        sc.close();
        /*
         6
        34 56 12 89 67 90
        Preorder : 34 12 56 89 67 90 
        Inorder : 12 34 56 67 89 90
        Postorder : 12 67 90 89 56 34
         */
    }
}
