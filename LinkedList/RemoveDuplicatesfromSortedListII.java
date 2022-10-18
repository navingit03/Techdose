//Leetcode 82. Remove Duplicates from Sorted List II
//Using Sentinel Head(dummy head)
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0,head); //adding a dummy node before head(Sentinel Head)
        ListNode prev=dummy; //making the dummy as prev
        ListNode curr=head;
        while(curr!=null) //while the node is not null
        {
            if(curr.next!=null&&curr.val==curr.next.val) //checking if curr and next val are same, if yes the moving curr till all the duplicates
            {
                while(curr.next!=null&&curr.val==curr.next.val) //checking all duplicates
                {
                    curr=curr.next; //moving curr
                }
                prev.next=curr.next; //connecting prev and next distinct number
            }
            else
            {
                prev=prev.next;
            }
            curr=curr.next; //moving curr by one for all iteration
        }
        return dummy.next; //returning dummy.next(head)
    }
}
