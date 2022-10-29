//Leetcode 451. Sort Characters By Frequency
//printing character based on high frequency
class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freq=new HashMap<>(); //creating hashmap to find frequency
        for(int i=0;i<s.length();i++)
        {
            freq.put(s.charAt(i),freq.getOrDefault(s.charAt(i),0)+1); //increasing freq for character key
        }
        PriorityQueue<Character> maxheap=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a)); //maxheap based on high frequency
        maxheap.addAll(freq.keySet()); //adding all character based on high frequency
        String res="";
        while(!maxheap.isEmpty()){
            char ch=maxheap.poll(); //getting freq of ch and adding it to res
            for(int i=0;i<freq.get(ch);i++){
                res+=ch;
            }
        }
        return res;
    }
}
/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.
Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
