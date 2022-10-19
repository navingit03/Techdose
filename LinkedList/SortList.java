//Leetcode 148. Sort List
//Using Merge sort
//TC: O(n)
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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode slow=head,fast=head; //to find mid we need slow and fast ptr
        ListNode prev=null;
        while(fast!=null&&fast.next!=null)
        {
            prev=slow; //till middle
            slow=slow.next; //slow ptr jumps one jump at a time
            fast=fast.next.next; //fast ptr jumps two jump at a time
        }
        prev.next=null; //breaking the link before mid
        ListNode l1=sortList(head); //recursive call of first half
        ListNode l2=sortList(slow); //recursive call of second half
        return mergeSort(l1,l2); //merge sort call
    }
    public ListNode mergeSort(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0); //sentinel node
        ListNode temp=dummy;
        while(l1!=null&&l2!=null) //sort node method
        {
            if(l1.val<=l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null)
        {
            temp.next=l1;
        }
        if(l2!=null)
        {
            temp.next=l2;
        }
        return dummy.next;
    }
}
