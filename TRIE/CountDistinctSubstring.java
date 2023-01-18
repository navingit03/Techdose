class countdistinctsubstring
{
    public static TrieNode root=null;
    class TrieNode
    {
        TrieNode next[]=new TrieNode[26];
    }
    public static int result=0;
    
    public static void insert(String s)
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(temp.next[index]==null)
            {
                countdistinctsubstring obj=new countdistinctsubstring();
                temp.next[index]=obj.new TrieNode();
                result++;
            }
            temp=temp.next[index];
        }
    }

    public static void main(String[] args) {
        countdistinctsubstring obj=new countdistinctsubstring();
        root=obj.new TrieNode();
        String s="abc";
        for(int i=0;i<s.length();i++)
        {
            insert(s.substring(i));
        }
        System.out.println("total distinct substring of s is "+(result+1)); //plus one for empty substring
    }
}
