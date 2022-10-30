//Leetcode 438. Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>(); //for return answer
        if(p.length()>s.length()) return new ArrayList<>(); //if p string len is high than s then return
        int len=p.length();
        int sHash[]=new int[26]; //creating frequency array
        int pHash[]=new int[26];
        for(int i=0;i<len;i++){
            sHash[s.charAt(i)-'a']++; //from 0 to p.len()-1 freq array is updated
            pHash[p.charAt(i)-'a']++; //from 0 to p.len()-1 freq array is updated
        }
        if(Arrays.equals(sHash,pHash)){
                list.add(0); //if index 0 to p.len()-1 of s has same freq of string p add start inde 0
            }
        int start=0; //increasing start to decrease freq[s.charAt(start)]-- 
        int end=len; ////increasing end to increase freq[s.charAt(end)]++
        while(end<s.length()){
            sHash[s.charAt(start++)-'a']--; //removing start index freq
            sHash[s.charAt(end++)-'a']++; //increasing end index freq
            if(Arrays.equals(sHash,pHash)) //if freq are same anagram is found
            {
                list.add(start); //adding start index of anagram
            }
        }
        return list;
    }
}

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
