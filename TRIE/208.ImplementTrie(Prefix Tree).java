class Trie {
    TrieNode root;
    class TrieNode{
        char ch; //curr character
        TrieNode next[]=new TrieNode[26]; //26 next branches of curr character(child pointers)
        int wordend; //to check if there is a word ending here
        int prefixctr; //if there is a word with prefix
        TrieNode(char ch) //constructor for creating a new child
        {
            this.ch=ch;
            wordend=0;
            prefixctr=0;
            wordend=0;
            for(int i=0;i<26;i++){
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
            if(curr.next[index]==null){
                curr.next[index]=new TrieNode(word.charAt(i));
            }
            curr=curr.next[index];
            curr.prefixctr++;
        }
        curr.wordend++; //increasing we for curr word inserted
    }
    
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            int index=word.charAt(i)-'a';
            if(curr.next[index]==null) return false;
            curr=curr.next[index];
        }
        return curr.wordend>=1; //if the word is present one or more time
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++)
        {
            int index=prefix.charAt(i)-'a';
            if(curr.next[index]==null) return false;
            curr=curr.next[index];
        }
        return curr.prefixctr>=1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
