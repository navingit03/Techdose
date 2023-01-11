//leetcode 886. Possible Bipartition by BFS
class Solution {
    public static boolean bfs(List<List<Integer>> graph,int source,int visited[],int []color){
        Queue<Integer> q=new LinkedList<>(); //crete queue
        q.offer(source); //add k'th node in q
        color[source]=0; //give a color as 0
        visited[source]=1; //make it visited
        while(!q.isEmpty())
        {
            int node=q.poll(); //polling q
            for(int i=0;i<graph.get(node).size();i++) //finding adj nodes of node
            {
                int adj=graph.get(node).get(i); //adjnode
                visited[adj]=1; //make it visited
                if(color[adj]==-1) //if adjNode is yet not coloured , give oppsite colour of the node
                {
                    color[adj]=(color[node]==0?1:0); //giving alternate color between node and adjnode
                    q.offer(adj); //adding it to q
                }else if(color[adj]==color[node]) //if adj already colored and has same color as node return false
                {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] d) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<d.length;i++){
            list.get(d[i][0]).add(d[i][1]);
            list.get(d[i][1]).add(d[i][0]);
        }
        int visited[]=new int[list.size()]; //visited array
        int color[]=new int[list.size()]; //coloring array to color with 0's and 1's
        Arrays.fill(color,-1); //initially Filling with -1
        for(int k=0;k<list.size();k++){
            if(visited[k]==0)
            {
                color[k]=0;
                if(bfs(list,k,visited,color)==false){
                    return false;
                }
            }
        }
        return true;
    }
}
