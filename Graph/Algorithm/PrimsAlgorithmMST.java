package GraphAlgo;
import java.util.*;
public class PrimsAlgorithmMST {
    public static int selectMinCost(int []cost,boolean setMST[],int v){
        int min=Integer.MAX_VALUE;
        int vertex=0;
        for(int i=0;i<v;i++)
        {
            if(setMST[i]==false && cost[i]<min) //if not in mst and less cost
            {
                vertex=i;
                min=cost[i];
            }
        }
        return vertex; //selecting node to relax its edges
    }
    public static void findMST(int [][]edgeWeight,int v){
        int parent[]=new int[v]; //to store parent of curr vertex
        int cost[]=new int[v]; //to find cost from parent to curr vertex
        Arrays.fill(cost, Integer.MAX_VALUE); //initially filling it with infinite
        boolean setMST[]=new boolean[v]; //if setMST=true then it is added in MST
        parent[0]=-1; //source
        cost[0]=0; //source
        for(int i=0;i<v-1;i++)
        {
            //select best vertex with min cost(greedy)
            int u=selectMinCost(cost,setMST,v);
            setMST[u]=true; //included in MST
            for(int j=0;j<v;j++){
                //there should be edge between u and j (!=0)
                //relax adj edges which is not in mst and edgeWeight is less than cost[j]
                if(edgeWeight[u][j]!=0 && setMST[j]==false && edgeWeight[u][j]<cost[j]){
                    cost[j]=edgeWeight[u][j];
                    parent[j]=u;
                }
            }
        }
        //print MST
        for(int i=1;i<v;i++){
            System.out.println("U->V: "+parent[i]+"->"+i+" wt= "+edgeWeight[parent[i]][i]);
        }
    } 
    public static void main(String[] args) {
    int v=6;
    int edgeWeight[][]={{0,4,6,0,0,0},
                        {4,0,6,3,4,0},
                        {6,6,0,1,0,0},
                        {0,3,1,0,2,3},
                        {0,4,0,2,0,7},
                        {0,0,0,3,7,0}};
    findMST(edgeWeight,v);  
    }                    

}
/* MST edge
 U->V: 0->1 wt= 4
U->V: 3->2 wt= 1
U->V: 1->3 wt= 3
U->V: 3->4 wt= 2
U->V: 3->5 wt= 3
*/
