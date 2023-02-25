package BuildDS;
public class QueueUsingLinkedList {
    static ListNode head=null,tail=null;
    static class ListNode
    {
        int data;
        ListNode next;
        ListNode(int val)
        {
            data=val;
        }
    }
    public static void enqueue(int val)
    {
        ListNode curr=new ListNode(val);
        if(head==null)
        {
            head=curr;
            tail=curr;
        }else
        {
            tail.next=curr;
            tail=curr;
        }
    }
    public static int dequeue()
    {
        if(head==null)
        {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        int delete=head.data;
        head=head.next;
        if(head==null) //if only one element is present
        {
            tail=null;
        }
        return delete;

    }
    public static boolean isEmpty()
    {
        return head==null;
    }
    public static int peek()
    {
        if(head==null)
        {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return head.data;
    }
    public static void main(String[] args) {
        enqueue(7);
        enqueue(8);
        enqueue(9);
        enqueue(10);
        enqueue(11);
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(dequeue());
        System.out.println(isEmpty());
        System.out.println(peek());

    }
}
