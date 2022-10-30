//Leetcode 49. Group Anagrams
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0) return new ArrayList<>(); //if input is null return empty list
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char []arr=s.toCharArray(); //string is converted into arr to sort
            Arrays.sort(arr); //sorting the array
            String key=String.valueOf(arr); //again converting it string as key for hashmap
            if(!map.containsKey(key)) //if key is not present create a new list for key
            {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s); //adding the string[i] in the key of hashmap
        }
        return new ArrayList<>(map.values()); //returned as arraylist
    }
}

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
*/
