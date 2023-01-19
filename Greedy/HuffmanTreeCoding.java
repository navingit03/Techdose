import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class HuffmanTreeCoding
{
    static class Node{
        int data;
        char c;
        Node left;
        Node right;
        Node(int data,char ch,Node left,Node right)
        {
            this.data=data;
            this.c=ch;
            this.left=left;
            this.right=right;
        }
    }
    public static void preorder(Node root,String temp,List<String> ans)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            ans.add(temp);
        }
        preorder(root.left, temp+"0", ans);
        preorder(root.right, temp+"1", ans);
    }
    public static void huffmanCode(String s,int []freq,int N)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.data-b.data); //sorting in ascending order
        for(int i=0;i<N;i++)
        {
            pq.add(new Node(freq[i],s.charAt(i),null,null));
        }
        while(pq.size()>1)
        {
            Node a=pq.poll();
            Node b=pq.poll();
            int newData=a.data+b.data;
            Node newNode=new Node(newData,'-', a, b);
            pq.add(newNode);
        }
        ArrayList<String> ans=new ArrayList<>();
        Node root=pq.poll();
        preorder(root,"",ans);
        System.out.print(ans); //[0, 100, 101, 11]
    }
    public static void main(String[] args) {
        String s="ABCD";
        int freq[]={50,40,5,5};
        huffmanCode(s,freq,s.length());
    }
}
