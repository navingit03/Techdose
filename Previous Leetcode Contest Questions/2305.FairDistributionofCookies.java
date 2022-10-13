//Leetcode 2305. Fair Distribution of Cookies
//Using DFS
class Solution {
    public int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        dfs(cookies,k,new int[k],0);
        return ans;
    }
    public void dfs(int []cookies,int k,int[] distribution,int curr){
        if(curr==cookies.length){
            int max=0;
            // Now we will go through in each child and look into it which child got maximum
            for(int cookie: distribution){
                max=Math.max(max,cookie);
            }
            //Now we check our answer with already achieved answer in order to find a better answer
            ans=Math.min(max,ans);
            return;
        }
        for(int i=0;i<k;i++){
            //at this particular index "curr" we have an option to give this cookies of bag to the child from 0 to k-1
            // One by one we are giving and checking in which case we get minimum unfairness
            distribution[i]+=cookies[curr];
          
            //Now call the function again for the another bag of cookies and distribute it
            dfs(cookies,k,distribution,curr+1);
          
            // Since it is a backtracking
            // Currently we are at index "curr" in cookies of bag and this bag we have already 
            //distributed to the child which is at position "i" and we got our minimum answer
            // and we are looking if we distribute this bag to another child then whether we 
            // can achieve a better answer or not i.e. minimum possible unfairness
            distribution[i]-=cookies[curr];
        }
    }
}
/*
You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag.
You are also given an integer k that denotes the number of children to distribute all the bags of cookies to.
All the cookies in the same bag must go to the same child and cannot be split up.
The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
Return the minimum unfairness of all distributions.
Example 1:
Input: cookies = [8,15,10,20,8], k = 2
Output: 31
Explanation: One optimal distribution is [8,15,8] and [10,20]
- The 1st child receives [8,15,8] which has a total of 8 + 15 + 8 = 31 cookies.
- The 2nd child receives [10,20] which has a total of 10 + 20 = 30 cookies.
The unfairness of the distribution is max(31,30) = 31.
It can be shown that there is no distribution with an unfairness less than 31.
*/
