class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)) //if both are equal there will be no two subsequence which will be uncommon
        {
            return -1;
        }
        return Math.max(a.length(),b.length()); //longest subsequence will be max length of a || b
    }
}
