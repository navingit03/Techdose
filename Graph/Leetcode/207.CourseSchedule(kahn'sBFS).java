//207. Course Schedule using kahn'sAlgorithm_BFS.java
class Solution {
    //cycle detection using kahn's algo BFS
    public static boolean kahnsalgo(List<List<Integer>> adjList,int []indegree,int n){
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
            ind++;
        }
        if(ind!=n) //if there is a cycle return false
        {
            return false;
        }
        return true;
    }
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        int indegree[]=new int[n];
        for(int i=0;i<p.length;i++){
            list.get(p[i][0]).add(p[i][1]);
            indegree[p[i][1]]++;
        }
        return kahnsalgo(list,indegree,n);
    }
}
