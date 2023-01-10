//connecting vertex and finding all possible edgeWeight using given formula
//find MST and sum cost using primsMST algorithm

class Solution {
    int ans=0; //finding ans
    public int selectMinCost(int []cost,boolean setMST[],int v)
    {
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
    public void findMST(int [][]edgeWeight,int v){
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
            ans+=(edgeWeight[parent[i]][i]);
        }
    } 
    public int minCostConnectPoints(int[][] points) {
        int v=points.length; //total no of points
        int edgeWeight[][]=new int[v][v]; //creating a edgeWeight between them
        for(int i=0;i<v;i++) 
        {
            for(int j=i+1;j<v;j++)
            {
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                int dis=Math.abs(x1-x2)+Math.abs(y1-y2); //creating edge weight betweent i and j using formula
                edgeWeight[i][j]=dis; //undirected graph
                edgeWeight[j][i]=dis;
            }
        }
        findMST(edgeWeight,v); //finding primsMST algorithm
        return ans; //returning min cost
    }
}
