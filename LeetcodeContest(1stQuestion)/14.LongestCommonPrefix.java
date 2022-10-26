//Leetcode 14. Longest Common Prefix
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        for(int i=0;i<strs[0].length();i++){
            if(strs[0].length()==0) return "";
            for(int j=1;j<strs.length;j++) //comparing with next strings in array
            {
                if((i>strs[j].length()-1)||(strs[0].charAt(i)!=strs[j].charAt(i))) return s; //checking if i'th character is present in all the string ,if not then not add any futher character return s. if all string has i'th character add it to s and contiune checking other ith charater's. if j'th string is smaller than first string return s 
         }
            s+=strs[0].charAt(i);
        }
        return s;
    }
}
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
