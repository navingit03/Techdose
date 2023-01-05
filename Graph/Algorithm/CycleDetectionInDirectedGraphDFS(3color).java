package GraphAlgo;
import java.util.*;
public class CycleDetectionInDirectedGraphDFS3color {
    public static boolean dfs(List<List<Integer>> adjList,int visited[],int curr){
        if(visited[curr]==2)//already processed
        {
            return false;
        }
        if(visited[curr]==1) //if its already visited of curr dfs call
        {
            return true;
        }
        visited[curr]=1;
        for(int i=0;i<adjList.get(curr).size();i++){
            int adj=adjList.get(curr).get(i);
            if(dfs(adjList, visited, adj)==true){
                return true;
            }
        }
        visited[curr]=2;//processed
        return false;
    }
    public static void isCycle(int n,List<List<Integer>> adjList){
        int visited[]=new int[n+1];
        for(int i=0;i<=n;i++){
            if(dfs(adjList,visited,i)){
                System.out.println("Cycle Detected");
                return;
            }
        }
        System.out.println("Cycle Not Found");
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
        adjList.get(5).add(2); //cycle connection
        isCycle(n,adjList);
    }
}
