package BuildDS;
public class LinkedList {
    static ListNode head=null;
    static ListNode tail=null;
    static class ListNode
    {
        int val;
        ListNode next;
        ListNode(int data)
        {
            val=data;
            next=null;
        }
    }
    public void display()
    {
        ListNode temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println();
    }
    public void insertAtBegining(int data)
    {
        ListNode curr=new ListNode(data);
        if(head==null)
        {
            head=curr;
            tail=curr;
        }
        else
        {
            curr.next=head;
            head=curr;
        }
    }
    public void insertAtEnd(int data)
    {
        ListNode curr=new ListNode(data);
        if(head==null)
        {
            head=curr;
            tail=curr;
        }
        else
        {
            tail.next=curr;
            tail=tail.next;
        }

    }
    public void insertAtposition(int pos,int val)
    {
        ListNode curr=new ListNode(val);
        if(pos==1)
        {
            curr.next=head;
            head=curr;
        }
        else
        {
            ListNode temp=head;
            for(int i=1;i<pos-1;i++)
            {
                temp=temp.next;
            }
            if(temp.next==null)
            {
                insertAtEnd(curr.val);
            }else
            {
                curr.next=temp.next;
                temp.next=curr;
            }
        }
    }
    public void deleteAtBegin()
    {
        if(head!=null)
        {
            head=head.next;
        }
        else
        {
            System.out.println("Empty list");
        }
    }
    public void deleteAtPosition(int pos)
    {
        if(pos==1)
        {
            head=head.next;
        }
        else
        {
            ListNode temp=head;
            for(int i=1;i<pos;i++)
            {
                temp=temp.next;
            }
            temp.val=temp.next.val;
            temp.next=temp.next.next;
        }
    }
    public void reverseList()
    { 
         ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        
    }
    public void deleteAtEnd()
    {
        ListNode curr=head;
        if(head==null)
        {
            System.out.println("Empty");
        }else if(head.next==null)
        {
            head=null;
        }
        else{
            while(curr.next.next!=null)
            {
                curr=curr.next;
            }
            curr.next=null;
        }
    }
    public static void main(String[] args) {
        LinkedList l=new LinkedList();
        l.insertAtEnd(10);
        l.insertAtEnd(20);
        l.insertAtEnd(30);
        l.insertAtEnd(40);
        l.display();
        l.insertAtBegining(5);
        l.insertAtBegining(7);
        l.display();
        l.insertAtposition(2,9);
        l.insertAtposition(3,12);
        l.display();
        l.deleteAtBegin();
        l.display();
        l.deleteAtPosition(2);
        l.display();
        l.deleteAtEnd();
        l.display();
        l.reverseList();
        l.display();
        
    }
}
