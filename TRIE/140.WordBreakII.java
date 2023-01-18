class Solution {
    TrieNode root;
    class TrieNode
    {
        TrieNode[] next=new TrieNode[26]; //child nodes
        int wordend; //to check if a word end at curr node
    }
    public void insert(String s)
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a'; //finding index of curr char
            if(temp.next[index]==null) //if null create a node
            {
                temp.next[index]=new TrieNode();
            }
            temp=temp.next[index];
        }
        temp.wordend++; //add last make we++
    }
    public boolean search(String s)
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(temp.next[index]==null) //if curr char is not present return false
            {
                return false;
            }
            temp=temp.next[index];
        }
        return temp.wordend>=1; //at last find any word end there
    }
    List<String> list=new ArrayList<>();
    public void solve(String s,String curr,int pos)
    {
        if(pos==s.length()) //if end is reached add curr string in list
        {
            list.add(curr);
            return;
        }
        curr+=" "; //adding space
        for(int i=pos;i<s.length();i++)
        {
            if(search(s.substring(pos,i+1))) //if pos->i+1 substring is found 
            {
                solve(s,curr+s.substring(pos,i+1),i+1); //method call from next index 
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        root=new TrieNode();
        for(int i=0;i<wordDict.size();i++)
        {
            insert(wordDict.get(i));
        }
        for(int i=0;i<s.length();i++)
        {
            if(search(s.substring(0,i+1))) //if 0->i+1 substring is found 
            {
                solve(s,s.substring(0,i+1),i+1); //method call from next index
            }
        }
        return list;
    }
}
