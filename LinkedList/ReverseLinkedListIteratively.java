//Leetcode 206. Reverse Linked List
//Reverse Linked List Iteratively
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
        if(head==null) return head;
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=curr.next;
        while(curr!=null){
            next=curr.next; //storing curr.next in next
            curr.next=prev; //making curr.next pointing to prev
            prev=curr; //updating prev to curr
            curr=next; //updating curr to next
        }
        head=prev; //atlast making head point to last element(prev)
        return head;
    }
}
