//Leetcode 2311. Longest Binary Subsequence Less Than or Equal to K
//Input "00101001", k = 1 -> Longest subsequence is "000001" - size(6)
class Solution {
    public int longestSubsequence(String s, int k) {
        char []arr=s.toCharArray();
        int zerocount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zerocount++; //counting the number of zero so that we add it in the front
            }
        }
        int one=0;
        int val=0;
        int digit=0;
        for(int i=s.length()-1;i>=0;i--){
            int x=(int)(val+Math.pow(2,digit)*(arr[i]-'0')); //converting into decimal to check with k
            if(x<=k) if x<=k the find longest possible out x
            {
                val+=Math.pow(2,digit++)*(arr[i]-'0');
                if(s.charAt(i)=='1'){
                    one++; // one count
                }
            }
            else //if x>k then break
            {
                break;
            }
        }
        return one+zerocount;
    }
}
/*
You are given a binary string s and a positive integer k.
Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
Note:
The subsequence can contain leading zeroes.
The empty string is considered to be equal to 0.
A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.
Example 1:
Input: s = "1001010", k = 5
Output: 5
Explanation: The longest subsequence of s that makes up a binary number less than or equal to 5 is "00010", as this number is equal to 2 in decimal.
Note that "00100" and "00101" are also possible, which are equal to 4 and 5 in decimal, respectively.
The length of this subsequence is 5, so 5 is returned.
Example 2:
Input: s = "00101001", k = 1
Output: 6
Explanation: "000001" is the longest subsequence of s that makes up a binary number less than or equal to 1, as this number is equal to 1 in decimal.
The length of this subsequence is 6, so 6 is returned.
*/
