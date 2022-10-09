//Leetcode 828. Count Unique Characters of All Substrings of a Given String
//Using list of list
class Solution {
    public int uniqueLetterString(String s) {
       int len=s.length(),res=0;
       List<List<Integer>> list=new ArrayList<>(); //list of list for all 26 characters(A-Z)
       for(int i=0;i<26;i++){
           list.add(new ArrayList<>()); //creating list for all the characters
           list.get(i).add(-1); //initially adding -1 to the character's list to find left window of the particular character
       }
       for(int i=0;i<len;i++){
           list.get(s.charAt(i)-'A').add(i); //adding index of the string's character in character's list 
       }
       for(int i=0;i<26;i++){
           list.get(i).add(len); //adding len in the character's list to get right window of last occuring character
       }
       for(int i=0;i<26;i++){
           for(int j=1;j<list.get(i).size()-1;j++){
               int left=list.get(i).get(j)-list.get(i).get(j-1); //calculating left window of the particular character till that character on left side or -1(if not in leftside)
               int right=list.get(i).get(j+1)-list.get(i).get(j); //calculating right window of the particular character till that character on right side or len(if not in rightside
               res+=(left*right); //multiplying len of right window and len of left window
           }
       }
       return res;
    }
}
