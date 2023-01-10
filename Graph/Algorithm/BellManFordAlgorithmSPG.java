//TC-O(VE)
package GraphAlgo;
import java.util.*;
public class BellManFordAlgorithm {
    public static void bellmanford(int [][]edges,int V){
        int parent[]=new int[V]; //to store parent of all vertex
        int value[]=new int[V]; //keeps shortest path value
        Arrays.fill(value, Integer.MAX_VALUE);
        parent[0]=-1; //0-source
        value[0]=0; //source has value-0
        boolean updated=false;
        for(int i=0;i<V-1;i++) //v-1 relaxation
        {
            updated=false;
            for(int j=0;j<edges.length;j++) //each and every edge
            {
                int u=edges[j][0];
                int v=edges[j][1];
                int wt=edges[j][2];
                if(value[u]!=Integer.MAX_VALUE && value[u]+wt<value[v]) //if edge between u->v with wt < value[v]
                {
                    value[v]=value[u]+wt; //updating v value
                    parent[v]=u; //updating v parent
                    updated=true; //updated = true 
                }
            }
            if(updated==false){
                break; //if no update in curr ith relaxation no futher relaxation needed
            }
        }
        for(int j=0;j<edges.length&&updated==true;j++) //if value is updated at v-1 th relaxation then we need to relax one more time to find if there is -ve edge cycle   
        {
            int u=edges[j][0];
            int v=edges[j][1];
            int wt=edges[j][2];
            if(value[u]!=Integer.MAX_VALUE && value[u]+wt<value[v]){
                System.out.println("graph has -ve edge cycle");
                return;
            }
        }
        for(int i=1;i<V;i++) //SPG edges
        {
            System.out.println("u->v: "+parent[i]+"->"+i+" wt: "+value[i]);
        }
    }
    public static void main(String[] args) {
        int v=6;
        int edges[][]=new int[][]{{0,1,4},{0,3,9},{1,2,-1},{2,5,3},{3,2,2},{3,4,-5},{4,5,0}}; //input src-dst-wt
        bellmanford(edges,v);
    }
}
