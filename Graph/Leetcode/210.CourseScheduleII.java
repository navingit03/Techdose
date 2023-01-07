//210. Course Schedule II using topological sort 
//if cycle found return empty arr
class Solution {
    //dfs three color in directed graph to find cycle
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
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            list.get(p[i][0]).add(p[i][1]);
        }
        int visited[]=new int[n];
        for(int i=0;i<n;i++){
            if(dfs(list,visited,i)){
                return false;
            }
        }
        return true;
    }
}
