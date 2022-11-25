package Trees;
import java.util.*;
public class BinarySearchTree {
    static Node root=null;
    public static class Node{
        int val;
        Node left,right;
        Node(int data){
            val=data;
        }
    }
    public static void buildBST(Node root,int data){
        if(root.val>data){
            if(root.left==null){
                root.left=new Node(data);
            }
            else{
                buildBST(root.left,data);
            }
        }
        else
        {
            if(root.right==null){
                root.right=new Node(data);
            }
            else{
                buildBST(root.right, data);
            }
        }
    }
    public static void preorder(Node root){
        if(root!=null){
            System.out.print(root.val+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.val+" ");
            inorder(root.right);
        }
    }
    public static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        root=new Node(arr[0]);
        for(int i=1;i<n;i++){
            buildBST(root,arr[i]);
        }
        System.out.println("Original Array "+Arrays.toString(arr));
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        sc.close();
    }
}
