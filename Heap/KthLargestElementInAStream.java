//Leetcode 703. Kth Largest Element in a Stream
//we need to find kth largest element in a stream
class KthLargest {
    PriorityQueue<Integer> minHeap; //creating min heap to maintain ascending order
    int k; //int k is declared as global to access in other methods 
    public KthLargest(int k, int[] nums) {
        minHeap=new PriorityQueue<>(); 
        for(int i=0;i<nums.length;i++)
        {
            minHeap.add(nums[i]); adding elements in nums
        }
        this.k=k; //gobal k= method k
    }
    
    public int add(int val){
        minHeap.add(val); //adding new val into minheap
        while(minHeap.size()>k) //polling till the size of minheap became k
        {
            minHeap.poll();
        }
        return minHeap.peek(); //minheap.peek() will have the kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/*
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
Example 1:

Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]

Explanation
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
*/
