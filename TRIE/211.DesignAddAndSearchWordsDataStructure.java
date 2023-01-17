class WordDictionary {
    TrieNode root;
    class TrieNode
    {
        TrieNode next[]=new TrieNode[26];
        int we;
        int prefixctr;
    }
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(temp.next[index]==null)
            {
                temp.next[index]=new TrieNode();
            }
            temp=temp.next[index];
            temp.prefixctr++;
        }
        temp.we++;
    }
    public boolean dfs(String word,int index,TrieNode temp)
    {
        if(index==word.length()) return temp.we>=1;
        char ch=word.charAt(index);
        if(ch=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(temp.next[i]!=null && dfs(word,index+1,temp.next[i]))
                {
                    return true;
                }
            }
        }
        else if(temp.next[ch-'a']!=null)
        {
            return dfs(word,index+1,temp.next[ch-'a']);
        }
        return false;
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
