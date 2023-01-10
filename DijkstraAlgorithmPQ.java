//TC-O(V log E) by using PQ
package GraphAlgo;
import java.util.*;
public class DijkstraAlgorithmPQ {
    public static void dijkstra(PriorityQueue<int[]> pq,int [][]edges,int v){
        int distance[]=new int[v]; //creating distance array
        boolean processed[]=new boolean[v];
        int parent[]=new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=0;
        parent[0]=-1;
        pq.add(new int[]{0,0}); //vertex-0 distance-0
        for(int i=0;i<v-1;i++){
            int u=pq.remove()[0]; //mindistance index
            processed[u]=true;
            for(int j=0;j<v;j++){
                if(edges[u][j]!=0&&processed[j]==false&&(edges[u][j]+distance[u])<distance[j]){
                    distance[j]=edges[u][j]+distance[u]; //update
                    parent[j]=u;
                    pq.add(new int[]{j,distance[j]});
                }
            }

        }
        for(int i=1;i<v;i++){
            System.out.println("u->v: "+parent[i]+"->"+i+" wt: "+distance[i]);
        }
    }
    public static void main(String[] args) {
        int edges[][]={{ 0, 9, 6, 5, 3, 0, 0, 8, 0 },
                            { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                            { 0, 2, 0, 4, 0, 0, 0, 0, 0 },
			                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };//input edge matrix
                            PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]); //to find min distance which is not processed
                            dijkstra(pq,edges,edges.length);
    }
}
