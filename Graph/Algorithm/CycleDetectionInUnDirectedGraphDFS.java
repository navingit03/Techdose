//Cycle Detection In UnDirected Graph using DFS
package GraphAlgo;
import java.util.*;
public class CycleDetectionInUnDirectedGraphDFS {
    public static boolean dfs(boolean visited[],List<List<Integer>> adjList,int curr,int parent){
        visited[curr]=true; //making it visited
        for(int i=0;i<adjList.get(curr).size();i++)
        {
            int adjNode=adjList.get(curr).get(i); //getting adjNode
            if(visited[adjNode]==false) //if adjNode not visited 
            {
                if(dfs(visited, adjList, adjNode, curr)) //call dfs
                {
                    return true;
                }
            }
            else if(adjNode!=parent) //adjNode already visited and its not parent then cycle found
            {
                return true;
            }
        }
        return false; //no cycle
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //7
        sc.close();
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>()); //creating adjList for all nodes
        }
        //undirected graph one component connections
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(1);
        adjList.get(2).add(5);
        adjList.get(3).add(1);
        adjList.get(3).add(4);
        adjList.get(3).add(6);
        adjList.get(4).add(3);
        adjList.get(5).add(2);
        adjList.get(5).add(7);
        adjList.get(6).add(3);
        adjList.get(6).add(7);
        adjList.get(7).add(5);
        adjList.get(7).add(6);
        
        //undirected graph multiple component connections
        /*adjList.get(1).add(2);
        adjList.get(2).add(1);
        adjList.get(2).add(4);
        adjList.get(4).add(2);
        adjList.get(1).add(3);
        adjList.get(3).add(1);
        adjList.get(5).add(6);
        adjList.get(6).add(5);
        adjList.get(7).add(8);
        adjList.get(8).add(7);
        adjList.get(7).add(9);
        adjList.get(9).add(7);
        adjList.get(8).add(9);
        adjList.get(9).add(8);*/
        boolean visited[]=new boolean[n+1]; //boolean visited array
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==false) //if this component is not visited then call dfs
            {
                if(dfs(visited,adjList,i,-1)) //-1 parent
                {
                    System.out.println("Cycle Found");
                    System.exit(0);
                }
            }
        }
        System.out.println("Cycle not Found");
    }
}
