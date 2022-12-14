//Topological Sort Using DFS+Stack
package GraphAlgo;
import java.util.*;
public class TopologicalSortUsingDFS {
    public static boolean isCycle(List<List<Integer>> adjList,int []color,int curr) //if cycle is present or not
    {
        if(color[curr]==2)//already processed
        {
            return false;
        }
        if(color[curr]==1) //if its already visited of curr dfs call
        {
            return true;
        }
        color[curr]=1;
        for(int i=0;i<adjList.get(curr).size();i++){
            int adj=adjList.get(curr).get(i);
            if(isCycle(adjList,color,adj)==true){
                return true;
            }
        }
        color[curr]=2; //making it processed
        return false;
    }
    public static void dfs(List<List<Integer>> adjList,int curr,boolean []visited,Stack st){
        visited[curr]=true;
        for(int i=0;i<adjList.get(curr).size();i++){
            int adj=adjList.get(curr).get(i);
            if(!visited[adj]){
                dfs(adjList, adj, visited, st);
            }
        }
        st.push(curr);
        return; //topological order storing curr in stack
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
        int color[]=new int[n+1]; //color array to detect cycle
        for(int i=0;i<n+1;i++)
        {
            if(isCycle(adjList,color,i))
            {
                System.out.println("Cycle found"); //if cycle found return empty arr
                return;
            }
        }
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
