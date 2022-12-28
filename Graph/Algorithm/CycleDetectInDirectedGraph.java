//visited true/false method
package GraphAlgo;
import java.util.*;
public class CycleDetectInDirectedGraph {
    public static boolean dfs(List<List<Integer>> adjList,boolean visited[],int curr){
        if(visited[curr]==true) //if already visited then cycle found 
        {
            return true;
        }
        visited[curr]=true; //making it visited = true
        for(int i=0;i<adjList.get(curr).size();i++)
        {
            if(dfs(adjList, visited, adjList.get(curr).get(i))) //recurrsion call for all adj of curr
            {
                return true;
            }
        }
        visited[curr]=false; //backtracking
        return false;
    }
    public static void isCycle(int n,List<List<Integer>> adjList){
        boolean visited[]=new boolean[n+1]; //creating boolean array for each node(start)
        for(int i=0;i<=n;i++) //checking all the nodes 
        {
            if(dfs(adjList,visited,i))
            {
                System.out.print("Cycle Found"); //cycle found
                return;
            }
        }
        System.out.print("Cycle not Found"); //cycle not found
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<List<Integer>> adjList=new ArrayList<>();
        sc.close();
        for(int i=0;i<=n;i++) //creating list of list for 0 to n nodes
        {
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(4);
        adjList.get(2).add(3);
        adjList.get(4).add(5);
        adjList.get(5).add(2);
        isCycle(n,adjList);
    }
}
