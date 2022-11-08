//Leetcode 139. Word Break
//Recursion with memoization approach
class Solution {
    public boolean helper(String s,HashSet<String> wordDict,int start,Boolean []memo)
    {
        if(start==s.length()) //if end of the word is reached return true
        {
            return true;
        }
        if(memo[start]!=null) //if memo of start is already found in Boolean array then return memo[start]
        {
            return memo[start];
        }
        for(int end=start+1;end<=s.length();end++)
        {
            if(wordDict.contains(s.substring(start,end))) //if wordDict contains String of s from st to end-1
            {
                if(helper(s,wordDict,end,memo)) //recursion call for next position which is end as st to end-1 is already in wordDict
                {
                    return memo[start]=true; //return true if found
                }
            }
        }
        return memo[start]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(s,new HashSet<>(wordDict),0,new Boolean[s.length()]); //Boolean object because all the values are null when created
    }
}
