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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null; //base condition
        ListNode newHead=head; //creating newHead to store last node of given LL
        if(head.next!=null) //if next is not null recursion call
        {
            newHead=reverseList(head.next); //newHead store the node of last recursion call
            head.next.next=head; //making head.next node's next to point to head
        }
        head.next=null; //at last make head.next=null
        return newHead; //return newHead
    }
}
