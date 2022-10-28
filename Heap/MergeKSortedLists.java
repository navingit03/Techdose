//Leetcode 23. Merge k Sorted Lists
//adding elements into minheap and adding pq.poll() into linkedlist
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
    public ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<Integer> minheap=new PriorityQueue<>(); //creating a min haep
        for(ListNode elem:lists)
        {
            while(elem!=null){
                minheap.add(elem.val); //adding all the elements in list to minheap
                elem=elem.next; 
            }
        }
        if(minheap.size()==0) return null; //if input is null then out put is also null
        ListNode head=new ListNode(minheap.poll(),null); //head.val=min of all element in input
        ListNode dummy=head; //creating dummy node and point it to head
        while(minheap.size()!=0){
            dummy.next=new ListNode(minheap.poll()); //dummy.next.val=next min value in minheap by poll
            dummy=dummy.next; //moving dummy to create new node after current dummy
        }
        return head; //returning head of linkedlist
    }
}
/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
*/
