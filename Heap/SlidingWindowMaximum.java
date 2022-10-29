//Leetcode 239. Sliding Window Maximum
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len=nums.length; //finding length of nums
        int result[] = new int[len+1-k]; //creating an result array which will be size of len+1-k
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b)->(nums[b]-nums[a])); //reversing the pq of index as nums[b]-nums[a]
        int index = 0;
        for (int i = 0; i < len; i++) 
        {
            maxheap.add(i); //adding element into pq
            while(!maxheap.isEmpty()&&maxheap.peek()<=i-k) //if peek(max value in current maxheap) is not present in the current window then remove its index again and again
            {
                maxheap.remove();
            }
            if(i>=k-1) //if window size is >= k then we need to add max value in result
            {
                result[index++]=nums[maxheap.peek()]; //maxheap.peek() will have max values index so we need to add nums[maxheap.peek()];
            }
        }
        return result;
    }
}
/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
*/
