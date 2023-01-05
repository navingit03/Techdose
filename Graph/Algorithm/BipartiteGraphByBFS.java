package GraphAlgo;

import java.util.*;

public class BipartiteByBFS {
    public static boolean bfs(int [][]graph,int source,int visited[],int []color){
        Queue<Integer> q=new LinkedList<>(); //crete queue
        q.offer(source); //add k'th node in q
        color[source]=0; //give a color as 0
        visited[source]=1; //make it visited
        while(!q.isEmpty())
        {
            int node=q.poll(); //polling q
            for(int i=0;i<graph[node].length;i++) //finding adj nodes of node
            {
                int adj=graph[node][i]; //adjnode
                visited[adj]=1; //make it visited
                if(color[adj]==-1) //if adjNode is yet not coloured , give oppsite colour of the node
                {
                    color[adj]=(color[node]==0?1:0); //giving alternate color between node and adjnode
                    q.offer(adj); //adding it to q
                }else if(color[adj]==color[node]) //if adj already colored and has same color as node return false
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //int [][]graph={{1,2,3},{0,2},{0,1,3},{0,2}}; //not bipartite graph
        int [][]graph={{1,3},{0,2},{1,3},{0,2}}; //bipartite graph
        int visited[]=new int[graph.length]; //visited array
        int color[]=new int[graph.length]; //coloring array to color with 0's and 1's
        Arrays.fill(color,-1); //initially Filling with -1
        for(int i=0;i<graph.length;i++){
            if(visited[i]==0){
                if(bfs(graph,i,visited,color)==false){
                    System.out.println("It's not bipartite graph");
                    return;
                }
            }
        }
        System.out.println("It's bipartite graph");

    }
}
