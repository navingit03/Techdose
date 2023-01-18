class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>(); //for return answer
        if(p.length()>s.length()) return new ArrayList<>(); //if p string len is high than s then return
        int len=p.length();
        int sHash[]=new int[26]; //creating frequency array
        int pHash[]=new int[26];
        for(int i=0;i<len;i++){
            sHash[s.charAt(i)-'a']++; //from 0 to p.len()-1 freq array is updated
            pHash[p.charAt(i)-'a']++; //from 0 to p.len()-1 freq array is updated
        }
        if(Arrays.equals(sHash,pHash)){
                list.add(0); //if index 0 to p.len()-1 of s has same freq of string p add start inde 0
            }
        int start=0; //increasing start to decrease freq[s.charAt(start)]-- 
        int end=len; ////increasing end to increase freq[s.charAt(end)]++
        while(end<s.length()){
            sHash[s.charAt(start++)-'a']--; //removing start index freq
            sHash[s.charAt(end++)-'a']++; //increasing end index freq
            if(Arrays.equals(sHash,pHash)) //if freq are same anagram is found
            {
                list.add(start); //adding start index of anagram
            }
        }
        return list;
    }
}
