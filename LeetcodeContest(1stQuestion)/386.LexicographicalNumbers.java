//Leetcode 386. Lexicographical Numbers
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        Collections.sort(list,(a,b)->(Integer.toString(a).compareTo(Integer.toString(b))));
        return list;
    }
}
/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.
You must write an algorithm that runs in O(n) time and uses O(1) extra space. 
Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
*/
