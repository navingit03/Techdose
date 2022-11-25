package Trees;
import java.util.*;;
public class BSTtoDoublyLinkedList {
    static TreeNode root;
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int data){
            val=data;
        }
    }
    static node head;
    static class node{
        int val;
        node next,prev;
        node(int data){
            val=data;
        }
    }
    static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        node newnode=new node(root.val);
        if(head==null){
            head=newnode;
            head.next=head;
            head.prev=head;
        }else{
            node temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.prev=temp;
            newnode.next=head;
            head.prev=newnode;
        }
        inorder(root.right);
    }
    static void display(List<Integer> list){
        node temp=head;
        while(temp.next!=head){
        list.add(temp.val);
        temp=temp.next;
        }
        list.add(temp.val);
    }
    public static void main(String[] args) {
        root=new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        inorder(root);
        List<Integer> list=new ArrayList<>();
        display(list);
        System.out.print(list);
    }
}
