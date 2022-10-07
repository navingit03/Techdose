//Leetcode 454. 4Sum II
//Using hashmap
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hash=new HashMap<>();
        int count=0;
        for(int i:nums1){
            for(int j:nums2){
                hash.put(i+j,hash.getOrDefault(i+j,0)+1);
            }
        }
        for(int k:nums3){
            for(int l:nums4){
                count+=hash.getOrDefault(-(k+l),0);
            }
        }
        return count;
    }
}
