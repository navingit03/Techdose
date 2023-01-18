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
    
    public void addWord(String word) { //insert operation
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
        if(index==word.length()) return temp.we>=1; //if end is reached and there is a wordend
        char ch=word.charAt(index); //curr char
        if(ch=='.') //if '.' then check all possible node which is not null
        {
            for(int i=0;i<26;i++)
            {
                if(temp.next[i]!=null && dfs(word,index+1,temp.next[i])) //dfs call of index+1
                {
                    return true;
                }
            }
        }
        else if(temp.next[ch-'a']!=null) //if a char is present at curr index and not null call dfs for index+1
        {
            return dfs(word,index+1,temp.next[ch-'a']);
        }
        return false; //if not found
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
