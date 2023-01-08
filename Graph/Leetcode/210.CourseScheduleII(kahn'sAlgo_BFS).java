//leetcode 210.Course Schedule II topological sort using kahn's algorithm
class Solution {
    //topological sort using kahn's algorithm
    public boolean kahnsAlgo(List<List<Integer>> adjList,int []ans,int []indegree){
        Queue<Integer> q=new LinkedList<>(); //queue
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0) //adding v with 0 indegree
            {
                q.offer(i);
            }
        }
        int ind=0; //to store ans
        while(!q.isEmpty())
        {
            int curr=q.poll(); //polling indegree (removing curr node from graph)
            for(int i=0;i<adjList.get(curr).size();i++){
                int adj=adjList.get(curr).get(i); //adj node
                indegree[adj]--; //decreasing indegree of neighbors of curr node
                if(indegree[adj]==0) //if adj's indegree =0 add it to queue
                {
                    q.offer(adj);
                }
            }
            ans[ind++]=curr; //topological order
        }
        if(ind!=ans.length) //if there is a cycle return false
        {
            return false;
        }
        return true; //return true
    }
    public int[] findOrder(int numCourses, int[][] p) {
        List<List<Integer>> adjList=new ArrayList<>();
        int indegree[]=new int[numCourses]; //to calculate indegree of all nodes
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<p.length;i++){
            int v=p[i][1]; //vetrex
            int n=p[i][0]; //neighbors
            indegree[n]++; //indegree of n ++
            adjList.get(v).add(n); //edges
        }
        int ans[]=new int[numCourses]; //ans to store topological order
        if(kahnsAlgo(adjList,ans,indegree)==true)
        {
            return ans;
        }
        return new int[]{}; //if cycle found return false
    }
}
