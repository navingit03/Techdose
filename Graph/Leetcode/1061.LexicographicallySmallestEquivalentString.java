//Using Disjoint set union find
class Solution {
    int arr[]=new int[26];
    public int find(int index){
        if(arr[index]==index){
            return index;
        }
        return arr[index]=find(arr[index]); //path compression
    }
    public void union(int index1,int index2){
        index1=find(index1);
        index2=find(index2);
        if(index1==index2){
            return;
        }
        if(index1<index2){
            arr[index2]=index1;
        }else{
            arr[index1]=index2;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i=0;i<26;i++){
            arr[i]=i; //character pointing itself
        }
        for(int i=0;i<s1.length();i++){
            //int index1=s1.charAt(i)-'a';
            //int index2=s2.charAt(i)-'a';
            union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        String ans="";
        for (char c : baseStr.toCharArray()) {
            ans += (char)(find(c - 'a') + 'a');
        }
        return ans;
    }
}
