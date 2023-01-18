class Solution {
    TrieNode root;
    class TrieNode
    {
        TrieNode []next=new TrieNode[26];
        int wordEnd;
    }
    public void insert(String s)
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
        }
        temp.wordEnd++;
    }
    public boolean find(String s)
    {
        Queue<Integer> q=new LinkedList<>();
        int len=s.length();
        boolean visited[]=new boolean[len]; //to mark visited
        q.add(0); //starting index(base)
        outter:
        while(!q.isEmpty())
        {
            int st=q.poll(); //polling st index
            if(visited[st]==true) continue; //if already visited continue
            visited[st]=true; //make it visited
            TrieNode temp=root;
            for(int i=st;i<len;i++)
            {
                int index=s.charAt(i)-'a';
                temp=temp.next[index];
                if(temp==null) continue outter; //if not found st from while
                if(temp.wordEnd>0&&i<len-1) q.add(i+1); //check if word end here and add next index in queue
            }
            if(temp.wordEnd>=1) return true; //if all substrings are present
        }
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        root=new TrieNode();
        for(int i=0;i<wordDict.size();i++)
        {
            insert(wordDict.get(i));
        }
        return find(s); //find if s is present in trie as substrings
    }
}
