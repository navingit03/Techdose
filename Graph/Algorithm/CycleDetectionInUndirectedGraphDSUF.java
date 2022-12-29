//Cycle Detection In Undirected Graph using disjoint set union find method 
package GraphAlgo;
import java.util.*;
public class CycleDetectionInUndirectedGraphDSUF {
    public static int dsuf[];
    public static int find(int v)
    {
        if(dsuf[v]==-1) //edge case
        {
            return v;
        }
        return find(dsuf[v]); //recurrsion call
    }
    public static void unoin(int fromParent,int toParent)
    {
        dsuf[fromParent]=toParent; //making one parent to point to other parent
    }
    public static boolean isCycle(int [][]edges,int n)
    {
        for(int i=0;i<n;i++) //traversing all edges
        {
            int from=edges[i][0]; //from
            int to=edges[i][1]; //to
            int fromParent=find(from); //finding parent of from
            int toParent=find(to); //finding parent of to
            if(fromParent==toParent) return true; //cycle found if they are in same set
            unoin(fromParent,toParent); //else bring them into same set
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int E=sc.nextInt(); //getting e undirected edges - 4
        int V=sc.nextInt(); //total vertex - 4
        dsuf=new int[V]; //parent array
        Arrays.fill(dsuf, -1); //filling all by -1 (as all will be disjoint initially)
        int edges[][]={{0,1},{0,3},{2,3},{1,2}}; //edges of given graph
        if(isCycle(edges,E))
        {
            System.out.println("Cycle Found");
        }
        else
        {
            System.out.println("Cycle not Found");
        }
        sc.close();
    }
}
