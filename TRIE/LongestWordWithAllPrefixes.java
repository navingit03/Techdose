public class LongestWordWithAllPrefixes {
    static TrieNode root;
    class TrieNode
    {
        TrieNode next[]=new TrieNode[26];
        boolean wordend;
    }
    public static void insert(String s)
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(temp.next[index]==null)
            {
                LongestWordWithAllPrefixes obj=new LongestWordWithAllPrefixes();
                temp.next[index]=obj.new TrieNode();
            }
            temp=temp.next[index];
        }
        temp.wordend=true;
    }
    public static boolean containsallsubstring(String s)
    {
        TrieNode temp=root;
        for(int i=0;i<s.length();i++)
        {
            int index=s.charAt(i)-'a';
            if(temp.next[index]==null||temp.next[index].wordend==false){
                return false;
            }
            temp=temp.next[index];
        }
        return true;
    }
    public static void main(String[] args) {
        String str[]={"n","ninja","ninj","ni","nin","ninga"};
        LongestWordWithAllPrefixes obj=new LongestWordWithAllPrefixes();
        root=obj.new TrieNode();
        String res="";
        for(int i=0;i<str.length;i++)
        {
            insert(str[i]);
        }
        for(int i=0;i<str.length;i++)
        {
            if(str[i].length()>res.length())
            {
                if(containsallsubstring(str[i]))
                {
                    res=str[i];
                }
            }
        }
        System.out.print(res);
    }
}

