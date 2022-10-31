//Leetcode 3. Longest Substring Without Repeating Characters

//TC : O(n) using hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>(); //map to find index of characters
        int len=s.length();
        int ans=0; //to find max length of substring without duplicates
        int left=0,right=0; //left and right pointer for range of substring
        while(right<len)
        {
            char ch=s.charAt(right);
            if(map.containsKey(ch)) //character is already present left is updated to (index of last occurance)+1 to avoid last occurance 
            {
                left=Math.max(left,map.get(ch)+1); //left is updated
            }
            map.put(ch,right); //char and index is add/ if already present then we need to update to current char index
            ans=Math.max(ans,right-left+1); //finding max len
            right++;
        }
        return ans;
    }
}

//TC : O(n^2) as it has two while loops
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>(); //creating hashmap for frequency
        int left=0; //left pointer
        int right=0; //right pointer
        int res=0; //res is length of substring without repeated character
        while(right<s.length())
        {
            char ch=s.charAt(right); //curr character is char at index right
            map.put(ch,map.getOrDefault(ch,0)+1); //increasing frequency of the char at right
            while(map.get(ch)>1) //while right char freq is >1 we need to remove freq of char at left
            {
                char leftmost=s.charAt(left); //getting char at left to reduce its freq it will done till freq of char at right becomes 1
                map.put(leftmost,map.get(leftmost)-1);
                left++;
            }
            res=Math.max(res,right-left+1); //finding max length
            right++;
        }
        return res;
    }
}

/*
Given a string s, find the length of the longest 
substring
 without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
