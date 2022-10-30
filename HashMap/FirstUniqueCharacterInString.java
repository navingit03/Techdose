//Leetcode 387. First Unique Character in a String
class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1);
        }
        int index=0,flag=0;
        for(int i=0;i<s.length();i++){
            if(freq.get(s.charAt(i))==1){
                index=i;
                flag=1;
                break;
            }
        }
        return flag==1?index:-1;
    }
}
/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
*/
