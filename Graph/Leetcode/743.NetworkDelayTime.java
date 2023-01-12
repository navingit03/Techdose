//Dijkstra Algo BFS
class Solution {
    //Dijkstra Algo BFS
    public int bfs(List<List<Pair<Integer,Integer>>> list, int n,int k){
        int maxcost=0;
        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0; //source dist-0
        Queue<Integer> q=new LinkedList<>();
        q.add(k);
        while(!q.isEmpty()){
            int u=q.poll();
            for(int i=0;i<list.get(u).size();i++){
                Pair<Integer,Integer> p=list.get(u).get(i);
                int v=p.getKey();
                int wt=p.getValue();
                if(distance[u]+wt<distance[v]){
                    distance[v]=distance[u]+wt;
                    q.add(v);
                }
            }
        }
        for(int i=1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE) //not able to visit i th vertex;
            {
                return -1;
            }
            if(maxcost<distance[i]){
                maxcost=distance[i];
            }
        }
        return maxcost;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer,Integer>>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        } 
        for(int i=0;i<times.length;i++){
            list.get(times[i][0]).add(new Pair<>(times[i][1],times[i][2]));
        }
        return bfs(list,n,k);
    }
}
