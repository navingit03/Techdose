//Topological Sort Using DFS+Stack
package GraphAlgo;
import java.util.*;
public class TopologicalSortUsingDFS {
    public static void dfs(List<List<Integer>> adjList,int curr,boolean []visited,Stack st){
        visited[curr]=true;
        for(int i=0;i<adjList.get(curr).size();i++){
            int adj=adjList.get(curr).get(i);
            if(!visited[adj]){
                dfs(adjList, adj, visited, st);
            }
        }
        st.push(curr); //topological order storing curr in stack
    }
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        int n=5;
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(2);
        adjList.get(0).add(3);
        adjList.get(3).add(1);
        adjList.get(4).add(2);
        adjList.get(4).add(1);
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        boolean visited[]=new boolean[n+1];
        for(int i=0;i<=n;i++){
            if(!visited[i]){
                dfs(adjList,i,visited,st); //simple dfs
            }
        }
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" "); //topological order printing
        }
    }
}
