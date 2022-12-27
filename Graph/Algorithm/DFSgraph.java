//TC: O(v+E) -> all vertex and its edges
package GraphAlgo;
import java.util.*;
public class DFS {
    public static void dfs(List<List<Integer>> adjList,boolean visited[],int curr){
        visited[curr]=true; //making curr = true
        System.out.print(curr+" "); //printing dfs order
        for(int i=0;i<adjList.get(curr).size();i++)
        {
            if(visited[adjList.get(curr).get(i)]==false) //if adjNode not visited then calling recurrsion call
            {
                dfs(adjList, visited, adjList.get(curr).get(i));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>()); //creating a list of list(adjList)
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
        dfs(adjList,new boolean[n+1],0); //dfs call
    }
}
