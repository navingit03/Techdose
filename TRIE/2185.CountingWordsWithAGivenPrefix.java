class Solution {
    TrieNode root;
    class TrieNode
    {
        TrieNode next[]=new TrieNode[26];
        int prefixctr;
    }
    public void insert(String s) //insert string in trie
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(temp.next[index]==null)
            {
                temp.next[index]=new TrieNode();
            }
            temp=temp.next[index];
            temp.prefixctr++; //for every char increase prefixctr++
        }
    }
    public int prefixcount(String pre)
    {
        TrieNode temp=root;
        for(int i=0;i<pre.length();i++)
        {
            int index=pre.charAt(i)-'a';
            if(temp.next[index]==null) return 0;
            temp=temp.next[index];
        }
        return temp.prefixctr; //return prefixctr value
    }

    public int prefixCount(String[] words, String pref) {
        root=new TrieNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i]);
        }
        return prefixcount(pref); //finding words with pref
    }
}
