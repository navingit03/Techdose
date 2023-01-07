//210. Course Schedule II using topological sort 
//if cycle found return empty arr
class Solution {
    int index; //to store ans at correct index of array
    public boolean isCycle(List<List<Integer>> adjList,int []color,int curr) //if cycle is present or not
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
    public void dfs(List<List<Integer>> adjList,boolean []visited,int curr,int []ans){
        if(visited[curr]){
            return;
        }
        visited[curr]=true;
        for(int i=0;i<adjList.get(curr).size();i++){
            int adj=adjList.get(curr).get(i);
            if(!visited[adj]){
                dfs(adjList,visited,adj,ans);
            }
        }
        ans[index--]=curr; //topological order storing the ans
    }
    public int[] findOrder(int numCourses, int[][] pre) {
        index=numCourses-1; //to store from last as toplogical order
        int ans[]=new int[numCourses]; //ans array
        List<List<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adjList.get(pre[i][1]).add(pre[i][0]); //adding edges
        }
        int color[]=new int[numCourses]; //color array to detect cycle
        for(int i=0;i<numCourses;i++)
        {
            if(isCycle(adjList,color,i))
            {
                return new int[]{}; //if cycle found return empty arr
            }
        }
        boolean visited[]=new boolean[numCourses]; //visited array
        for(int i=0;i<numCourses;i++){
            if(!visited[i])
            {
                dfs(adjList,visited,i,ans); //simple dfs call
            }
        }
        
        return ans;
    }
}
