//anagram is to rearrange a string to make another string
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false; //if different length we can not rearrange s to t
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq1[s.charAt(i)-'a']++;
            freq2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freq1[i]!=freq2[i]) return false; //if freq of any char is different return false;
        }
        return true;
    }
}
