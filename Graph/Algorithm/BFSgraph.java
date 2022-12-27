//TC : O(V+E) -> polling v elements + traverse each edges of v
package GraphAlgo;
import java.util.*;
public class BFS {
    public static void bfs(List<List<Integer>> adjList,boolean visited[],int source){
        Queue<Integer> q=new LinkedList<>(); //creating a queue
        q.add(source); //adding start node
        visited[source]=true; //making it visited = true
        while(!q.isEmpty())
        {
            int curr=q.remove(); //polling first element in queue and visiting all  its adj node
            for(int i=0;i<adjList.get(curr).size();i++){
                if(visited[adjList.get(curr).get(i)]==false) //if it is not visited making it true
                {
                    visited[adjList.get(curr).get(i)]=true;
                    q.add(adjList.get(curr).get(i)); //adding in queue
                }
            }
            System.out.print(curr+" "); //printing bfs order
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(); //no of nodes from 0 to n-1 nodes
        sc.close();
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(1).add(4);
        adjList.get(2).add(5);
        adjList.get(3).add(6);
        adjList.get(4).add(7);
        adjList.get(5).add(7);
        adjList.get(6).add(7);
        bfs(adjList,new boolean[n+1],0); //boolean array of size n+1 as we need from 0 to n(no of vertices)
    }
}
