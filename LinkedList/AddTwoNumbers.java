//Leetcode 2. Add Two Numbers
//using sentinel node(dummy node)
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0); //creating a dummy node(sentinel)
        ListNode temp=dummy; //making temp = dummy
        int sum=0;
        while(l1!=null||l2!=null)
        {
            if(l1!=null){
                sum+=l1.val; //adding value of nodes of first LL
                l1=l1.next; //moving the node by 1
            }
            if(l2!=null){
                sum+=l2.val; //adding value of nodes of second LL
                l2=l2.next; //moving the node by 1
            }
            temp.next=new ListNode(sum%10); //creating a node and adding the sum%10 value
            sum/=10;
            temp=temp.next; //making temp to temp.next
        }
        if(sum>0){
            temp.next=new ListNode(sum);
        }
        return dummy.next; //returning nodes after dummy node
    }
}
