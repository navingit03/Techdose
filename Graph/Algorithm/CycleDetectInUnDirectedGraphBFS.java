//Cycle Detection In UnDirected Graph by using BFS
package GraphAlgo;
import java.util.*;
public class CycleDetectionInUnDirectedGraphBFS {
    public static boolean checkCycleBFS(int curr,List<List<Integer>> adjList,int []visited){
        visited[curr]=1; //making current visited
        Queue<int[]> q=new LinkedList<>(); //queue for bfs
        q.add(new int[]{curr,-1}); //adding curr and -1(as parent)
        while(!q.isEmpty())
        {
            int arr[]=q.poll();
            int node=arr[0]; //finding node
            int parent=arr[1]; //finding its parent
            for(int i=0;i<adjList.get(node).size();i++) //traversing all adj node of node
            {
                if(visited[adjList.get(node).get(i)]==0) //if adj node not visited 
                {
                    visited[adjList.get(node).get(i)]=1; //make it visited
                    q.add(new int[]{adjList.get(node).get(i),node}); //add it to queue with parent(node)
                }
                else if(adjList.get(node).get(i)!=parent) //if visited and not parent(two bfs meeting-means cycle found)
                {
                    return true; //return true
                }
            }
        }
        return false; //return false
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
        /*adjList.get(1).add(2);
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
        adjList.get(7).add(6);*/
        
        //undirected graph multiple component connections
        adjList.get(1).add(2);
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
        adjList.get(9).add(8);
        
        int visited[]=new int[n+1];
        //checking for all components if several component present
        for(int i=1;i<=n;i++)
        {
            if(visited[i]==0) //if current component is not traversed
            {
                if(checkCycleBFS(i,adjList,visited)) //if cycle found then return true
                {
                    System.out.println("Cycle found");
                    return;
                }
            }
        }
        System.out.println("Cycle not found");
    }
}
