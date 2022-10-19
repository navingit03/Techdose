//Given n(number of nodes) and m(position to be deleted)
import java.util.*;
class Josephus{
    public static class LinkedList //creating a node
    {
        int val;
        LinkedList next;
        LinkedList(int data){
            val=data;
        }
    }
    static int getJosephusNode(int n,int m){
        LinkedList head=new LinkedList(1); //creating first node
        LinkedList node=head;
        for(int i=2;i<=n;i++){
            node.next=new LinkedList(i); //creating other nodes
            node=node.next;
        }
        node.next=head; //last node connecting to head(to make circular linkedlist)
        LinkedList ptr1=head;
        LinkedList prev=head;
        while(ptr1.next!=ptr1)
        {
            int count=1; //finding mth node
            while(count!=m){
                prev=ptr1;
                ptr1=ptr1.next;
                count++;
            }
            prev.next=ptr1.next; //skiping m th node
            ptr1=prev.next;
        }
        return ptr1.val; //returning last remaining node
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        System.out.print(getJosephusNode(n,m));
    }
}
