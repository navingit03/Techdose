package GraphAlgo;
import java.util.*;
class node{
    int parent;
    int rank;
    node(int p,int r){
        parent=p;
        rank=r;
    }
}

public class CycleDetectionInUndirectedGraphByPathCompressionAndRank {
    public static node dsuf[];
    public static int find(int v){
        if(dsuf[v].parent==-1) //if -1 then v will be AP
        {
            return v;
        }
        return dsuf[v].parent=find(dsuf[v].parent); //path compression
    }
    public static void union(int fromParent,int toParent){
        if(dsuf[fromParent].rank>dsuf[toParent].rank) //if fromP has higher rank then make toP point to fromP
        {
            dsuf[toParent].parent=fromParent;
        }
        else if(dsuf[fromParent].rank<dsuf[toParent].rank) //if toP has higher rank then make fromP point to toP
        {
            dsuf[fromParent].parent=toParent;
        }else //if both have same then make anyone point any one and increase toP.rank by 1
        {
            dsuf[fromParent].parent=toParent;
            dsuf[toParent].rank+=1;
        }
    }
    public static boolean isCycle(int [][]edges,int n)
    {
        for(int i=0;i<n;i++) //traversing all edges
        {
            int from=edges[i][0]; //from
            int to=edges[i][1]; //to
            int fromParent=find(from); //finding parent of from
            int toParent=find(to); //finding parent of to
            if(fromParent==toParent) return true; //cycle found if they are in same set
            union(fromParent,toParent); //else bring them into same set
        }
        return false;
    }
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
        int E=sc.nextInt(); //getting e undirected edges - 5
        int V=sc.nextInt(); //total vertex - 5
        dsuf=new node[V]; //parent array
        for(int i=0;i<V;i++)//filling all by -1 parent and 0 rank(as all will be disjoint initially)
        {
            dsuf[i]=new node(-1, 0);
        }
        int edges[][]={{0,1},{2,3},{1,2},{0,4},{4,3}}; //edges of given graph
        if(isCycle(edges,E))
        {
            System.out.println("Cycle Found");
        }
        else
        {
            System.out.println("Cycle not Found");
        }
        sc.close();
   } 
}
