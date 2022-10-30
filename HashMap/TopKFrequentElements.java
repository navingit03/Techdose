//Leetcode 347. Top K Frequent Elements
//we need to return k elements which have high frequency
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1); //frequency of nums[i] in hashmap
        }
        PriorityQueue<Integer> maxfreqHeap=new PriorityQueue<>((a,b)-> freq.get(b)-freq.get(a)); //pq is arranged based on most freq element
        for(int element:freq.keySet()) //adding key of hashmap in heap(it will be arraged as high freq element at top of heap tree as (a,b)-> freq.get(b)-freq.get(a))
        {
            maxfreqHeap.add(element); //to add all key we also use : maxfreqHeap.addAll(freq.keySet());
        }
        int res[]=new int[k]; //output most freq k elements
        for(int i=0;i<k;i++)
        {
            res[i]=maxfreqHeap.poll(); //polling all high freq element
        }
        return res;
    }
}
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
*/
