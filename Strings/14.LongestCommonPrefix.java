class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s="";
        if(strs[0].length()==0) return ""; //if first string is empty return ""
        for(int i=0;i<strs[0].length();i++){
            char ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++) //comparing first string with next strings in array
            {
                if((i>strs[j].length()-1)||(ch!=strs[j].charAt(i))) return s; 
                //if j'th string is smaller than length i return s || checking if i'th character is present in all the string ,if not then do not add any futher character return s. if all string has i'th character add it to s(ans) and contiune checking other ith charater's. 
         }
            s+=strs[0].charAt(i);
        }
        return s;
    }
}
