//Leetcode 496. Next Greater Element I
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        int res[]=new int[nums1.length];
        for(int val:nums2){
            while(!stack.empty()&&stack.peek()<val) //if curr val has less value in stack's top
            {
                map.put(stack.pop(),val); // adding small value(key) by poping and next greather(val)
            }
            stack.push(val); //pushing all val in stack
        }
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) //if curr value is in map
            {
                res[i]=map.get(nums1[i]); //getting the next greather val which is in map
            }
            else{
                res[i]=-1; //no greather value
            }
        }
        return res; //returning ans array
    }
}
