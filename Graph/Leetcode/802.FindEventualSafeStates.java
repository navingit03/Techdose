//directed cycle detection 3 color method where nodes with visited==2 will have terminal node (which has no cycle)
class Solution {
    
    public static boolean dfs(int[][] adjList,int visited[],int curr){
        if(visited[curr]==2)//already processed
        {
            return false;
        }
        if(visited[curr]==1) //if its already visited of curr dfs call
        {
            return true;
        }
        visited[curr]=1;
        for(int i=0;i<adjList[curr].length;i++){
            int adj=adjList[curr][i];
            if(dfs(adjList, visited, adj)==true){
                return true;
            }
        }
        visited[curr]=2;//processed
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int visited[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(visited[i]!=2){
                dfs(graph,visited,i);
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++){
            if(visited[i]==2) //finding nodes which are not in cycle which will have terminal node
            {
                list.add(i);
            }
        }
        return list;
    }
}
