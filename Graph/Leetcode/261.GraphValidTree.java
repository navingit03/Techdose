package GraphAlgo;
import java.util.*;
public class GraphValidTree261 {
    public static boolean cycleDFS(List<List<Integer>> adjList,boolean[] visited,int curr,int parent)
    {
        visited[curr]=true; //make it visited
        for(int i=0;i<adjList.get(curr).size();i++)
        {
            int adj=adjList.get(curr).get(i);
            if(visited[adj]==false) //if not visited call dfs
            {
                if(cycleDFS(adjList, visited, adj, curr))
                {
                    return true; //if cycle found
                }
            }
            else if(adj!=parent) //if visited and cycle found
            { 
                return true;
            }
        }
        return false;
    }
    public static boolean isTree(List<List<Integer>> adjList,int v){
        boolean visited[]=new boolean[v];
        if(cycleDFS(adjList,visited,0,-1)==true) //if cycle is found return its not a tree
        {
            return false;
        }
        for(int i=0;i<v;i++) //after dfs call if any vertex not visited then return false
        //multiple component
        {
            if(visited[i]==false) //after dfs not visited the ith vertex
            {
                return false;
            }
        }
        return true; //its a tree
    }
    public static void main(String[] args) {
        int v=5;
        int edges[][]={{0,1},{0,2},{0,3},{1,4}}; //add {1,2} which make it not a tree
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        if(isTree(adjList,v)){
            System.out.println("Given graph is Tree");
        }else{
            System.out.println("Given graph is not a Tree");
        }
    }
}
