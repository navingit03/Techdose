//TC(V*V)
package GraphAlgo;
import java.util.*;
public class DijkstraAlgorithm {
    public static int FindMinWeight(int []distance,boolean processed[]){
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(processed[i]==false && distance[i]<min) //finding min weight which is not processed
            {
                min=distance[i];
                index=i;
            }
        }
        return index;
    }
    public static void dijkstra(int [][]edges,int v,int source){
        int distance[]=new int[v]; //to store min dis from source to all vertex
        boolean processed[]=new boolean[v]; //if vertex already relaxed
        int parent[]=new int[v]; //to find parent 
        Arrays.fill(distance, Integer.MAX_VALUE); //initially infinite
        distance[source]=0; //directly reach source (source=0)
        parent[source]=-1; //source has no parent
        for(int i=0;i<v-1;i++) //to process v-1 edges
        {
            int u=FindMinWeight(distance,processed); //finding min weight which is not processed
            processed[u]=true; //make it processed
            for(int j=0;j<v;j++){
                //if there is edge from u to j
                //j is not processed
                //edges[u][j]+distance[u] < distance[j] make edge from u to j
                if(edges[u][j]!=0 && processed[j]==false && (edges[u][j]+distance[u])<distance[j])
                {
                    distance[j]=(edges[u][j]+distance[u]); //updating new min distance from u to j
                    parent[j]=u; //making u as parent of j
                }
            } 
        }
        for(int i=0;i<v;i++)
        {
            System.out.println("U->V: "+parent[i]+"->"+i+" wt:"+distance[i]);
        }
        
    }
    public static void main(String[] args) {
        int v=9;
        int edges[][]={{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 }}; //edge matrix
        dijkstra(edges,v,0); //method call
    }
}
