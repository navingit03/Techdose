//Leetcode 392. Is Subsequence
class Solution {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for(int i=0;i<t.length()&&j<s.length();i++){
            if(t.charAt(i)==s.charAt(j)) j++; //increase the pos of j in s
        }
        return j==s.length(); //if all char in s is found in t return true
    }
}
