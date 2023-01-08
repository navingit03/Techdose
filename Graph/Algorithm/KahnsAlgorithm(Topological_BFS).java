//Topological sort using KahnsAlgorithm BFS
package GraphAlgo;
import java.util.*;
public class KahnsAlgorithm {
    public static boolean kahnsalgo(List<List<Integer>> adjList,int []indegree,int []ans){
        Queue<Integer> q=new LinkedList<>(); //queue
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0) //adding v with 0 indegree
            {
                q.offer(i);
            }
        }
        int ind=0; //to store ans
        while(!q.isEmpty())
        {
            int curr=q.poll(); //polling indegree (removing curr node from graph)
            for(int i=0;i<adjList.get(curr).size();i++){
                int adj=adjList.get(curr).get(i); //adj node
                indegree[adj]--; //decreasing indegree of neighbors of curr node
                if(indegree[adj]==0) //if adj's indegree =0 add it to queue
                {
                    q.offer(adj);
                }
            }
            ans[ind++]=curr; //topological order
        }
        if(ind!=ans.length) //if there is a cycle return false
        {
            return false;
        }
        return true; //return true
    }
    public static void main(String[] args) {
        int n=5;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adjList.add(new ArrayList<>());
        }
        int indegree[]=new int[n+1]; //indegree array to find no of indegree of each nodes
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(2);
        adjList.get(4).add(1);
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        for(int i=0;i<=n;i++){
            for(int j=0;j<adjList.get(i).size();j++){
                indegree[adjList.get(i).get(j)]++;
            }
        }
        int ans[]=new int[n+1]; //to store toposort ans
        if(kahnsalgo(adjList,indegree,ans)==true){
            System.out.println(Arrays.toString(ans)); //if toposort found
        }else{
            System.out.println("Cycle Found"); //if cycle detected
        }
        
    }
}
