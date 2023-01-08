//Kruskal Algorithm MST using DSUF (rank and path compression)
package GraphAlgo;
import java.util.*;
class node{
    int parent;
    int rank;
    node(int p,int r) //constructor
    {
        parent=p;
        rank=r;
    }
}
public class KruskalAlgorithmMST {
    static node dsuf[];
    public static int find(int v){
        if(dsuf[v].parent==-1) //if -1 return v
        {
            return v;
        }
        return dsuf[v].parent=find(dsuf[v].parent); //path compression
    }
    public static void union(int fromParent,int toParent){
        if(dsuf[fromParent].rank==dsuf[toParent].rank) //if both has same rank
        {
            dsuf[fromParent].parent=toParent; //make fromP -> toP
            dsuf[toParent].rank+=1; //increase rank of toP by 1
        }else if(dsuf[fromParent].rank<dsuf[toParent].rank) //if toP has high rank fromP -> toP
        {
            dsuf[fromParent].parent=toParent;
        }else
        {
            dsuf[toParent].parent=fromParent; //if fromP has high rank toP -> fromP
        }
    }
    private static void kruskals(int[][] edges, int v, int e) {
        int minWeight=0; //total weight
        List<int[]> mstEdge=new ArrayList<>(); //to store mst edges
        int i=0,j=0; //i to find v-1 edges and j <e
        while(i<v-1&& j<e){
            int fromParent=find(edges[j][0]); //from parent
            int toParent=find(edges[j][1]); //to parent
            if(fromParent==toParent) //if cycle found then not add it in mst
            {
                continue;
            }else{
                union(fromParent,toParent); //joining both the parent
                mstEdge.add(new int[]{edges[j][0],edges[j][1],edges[j][2]}); //adding edge with no cycle
                i++; //increasing mst edges (i<v-1)
                minWeight+=edges[j][2]; //total weight to build mst
            }
            j++; //processing e edges
        }
        for(i=0;i<mstEdge.size();i++){
            System.out.println("U-V: "+mstEdge.get(i)[0]+"->"+mstEdge.get(i)[1]+" w:"+mstEdge.get(i)[2]);
        }
        System.out.println("minWeight : "+minWeight);
    }
    public static void main(String[] args) {
        int v=6;
        int e=9;
        int edges[][]={{0,1,4},{0,2,6},{1,4,4},{1,2,6},{1,3,3},{2,3,1},{4,3,2},{4,5,7},{3,5,3}}; //edge + weight
        dsuf=new node[v];
        for(int i=0;i<v;i++){
            dsuf[i]=new node(-1, 0); //initally parent=-1,rank=0
        }
        Arrays.sort(edges,(a,b)->a[2]-b[2]); //sorting based on weight
        kruskals(edges,v,e); //function call
    }
    
}
