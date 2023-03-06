class Trie {
    TrieNode root;
    class TrieNode
    {
        char ch;
        int we,pre;
        TrieNode next[]=new TrieNode[26];
        TrieNode(char ch)
        {
            this.ch=ch;
            we=0;
            pre=0;
            for(int i=0;i<26;i++)
            {
                next[i]=null;
            }
        }
    }
    public Trie() {
        root=new TrieNode('/');
    }
    
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.next[index]==null)
            {
                curr.next[index]=new TrieNode(word.charAt(i));
            }
            curr=curr.next[index];
            curr.pre++;
        }
        curr.we++;
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.next[index]==null)
            {
                return false;
            }
            curr=curr.next[index];
        }
        return curr.we>0;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            int index=prefix.charAt(i)-'a';
            if(curr.next[index]==null)
            {
                return false;
            }
            curr=curr.next[index];
        }
        return curr.pre>0;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
