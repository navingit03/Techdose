//leetcode 802. Find Eventual Safe States using kahns algorithm by reversing direction of edges and find all node which has indegree 0 at end
class Solution {
    //kahns algorithm by reversing direction of edges
    //another method with dfs color in submissiom=n
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        List<List<Integer>> adjRev=new ArrayList<>();
        int indegree[]=new int[v];
        for(int i=0;i<v;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                int p=graph[i][j];
                adjRev.get(p).add(i);
                indegree[i]++;
            }
        }
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>(); //queue
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0) //adding v with 0 indegree
            {
                q.offer(i);
                System.out.println(i);
            }
        }
        while(!q.isEmpty())
        {
            int curr=q.poll(); //polling indegree (removing curr node from graph)
            ans.add(curr);
            for(int i=0;i<adjRev.get(curr).size();i++){
                int adj=adjRev.get(curr).get(i); //adj node
                indegree[adj]--; //decreasing indegree of neighbors of curr node
                if(indegree[adj]==0) //if adj's indegree =0 add it to queue
                {
                    q.offer(adj);
                }
            }
            
        }
        Collections.sort(ans);
        return ans;
    }
}
