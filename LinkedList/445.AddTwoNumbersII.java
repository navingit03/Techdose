/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverse(ListNode head)
    {
        if(head==null)
        {
            return null;
        }
        ListNode newHead=head;
        if(head.next!=null)
        {
            newHead=reverse(head.next);
            head.next.next=head;
        }
        head.next=null;
        return newHead;
    }
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode l1=reverse(a); //reverse the given two linked lists
        ListNode l2=reverse(b);
        //add two numbers represented as numbers 
        ListNode dummy=new ListNode(0); 
        ListNode temp=dummy;
        int sum=0;
        while(l1!=null || l2!=null)
        {
            if(l1!=null)
            {
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum+=l2.val;
                l2=l2.next;
            }
            temp.next=new ListNode(sum%10);
            sum/=10;
            temp=temp.next;
        }
        if(sum>0)
        {
            temp.next=new ListNode(sum);
        }
        return reverse(dummy.next); //reverse the final as of add two numbers(reverse linked list)
    }
}
