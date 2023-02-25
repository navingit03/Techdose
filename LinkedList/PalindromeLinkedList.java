//234. Palindrome Linked List
//Check if a LinkedList is palindrome
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=null;
        while(fast!=null && fast.next!=null)
        {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=temp;
        ListNode curr=slow;
        ListNode next=slow.next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        } 
        while(head!=slow)
        {
            if(head.val!=prev.val)
            {
                return false;
            }
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}
//SC: O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>(); //creating a list to add elements
        ListNode temp=head;
        while(temp!=null) //while temp != null
        {
            list.add(temp.val); // adding node val in the list
            temp=temp.next; //temp pointing to next node
        }
        int left=0,right=list.size()-1;
        while(left<right){
            if(!list.get(left).equals(list.get(right))) // if not equal then it is not a palindrome
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
