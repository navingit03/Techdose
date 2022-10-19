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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
        ListNode ptr=dummy;
        while(ptr!=null){
            ListNode temp=ptr;
            for(int i=0;i<k&&temp!=null;i++){
                temp=temp.next;
            }
            if(temp==null) break;
            ListNode prev=null,curr=ptr.next,next=ptr.next.next;
            for(int i=0;i<k;i++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            ListNode tail=ptr.next;
            tail.next=curr;
            ptr.next=prev;
            ptr=tail;
        }
        return dummy.next;
    }
}
