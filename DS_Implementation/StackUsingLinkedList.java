package BuildDS;

public class StackUsingLinkedList {
    static ListNode front=null;
    static class ListNode
    {
        int data;
        ListNode next;
        ListNode(int val)
        {
            data=val;
        }
    }
    public static void push(int val)
    {
        ListNode curr=new ListNode(val);
        if(front==null)
        {
            front=curr;
        }else
        {
            curr.next=front;
            front=curr;
        }
    }
    public static int pop()
    {
        if(front==null)
        {
            throw new IndexOutOfBoundsException("Stack is Empty");
        }else{
            int val=front.data;
            front=front.next;
            return val;
        }
    }
    public static boolean isEmpty()
    {
        return front==null;
    }
    public static int peek()
    {
        if(front==null)
        {
            throw new IndexOutOfBoundsException("Stack is Empty");
        }else{
            int val=front.data;
            return val;
        }
    }
    public static void main(String[] args) {
        push(7);
        push(8);
        push(5);
        System.out.println( pop() );
        System.out.println( peek() );
        System.out.println( isEmpty() );
        System.out.println( pop() );
        System.out.println( peek() );
        System.out.println( isEmpty() );
        System.out.println( pop() );
        System.out.println( peek() );
        System.out.println( isEmpty() );
    }
}
