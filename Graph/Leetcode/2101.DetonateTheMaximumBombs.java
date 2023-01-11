class Solution {
    public boolean inRange(int [][]bombs,int curr,int i){
        long x1=bombs[curr][0];
        long y1=bombs[curr][1];
        long r=bombs[curr][2];
        long x2=bombs[i][0];
        long y2=bombs[i][1];
        long d=((x1-x2)*(x1-x2)) + ((y1-y2)*(y1-y2));
        return (Math.sqrt(d)<=(r)); //in range of curr-r
                    
    }
    public int BFS(int [][]bombs,int source,boolean []visited){
        Queue<Integer> q=new LinkedList<>();
        visited[source]=true;
        q.add(source); //adding source to q
        int cnt=1; //at source there is a bomb;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<bombs.length;i++){
                if(!visited[i]&&inRange(bombs,curr,i)) //if adj Node(bomb) is in range of curr bomb
                {
                    visited[i]=true;
                    cnt++; //increase count
                    q.add(i);
                }
            }
        }
        return cnt;
    }
    public int maximumDetonation(int[][] bombs) {
        int max=0;
        for(int i=0;i<bombs.length;i++){
            max=Math.max(max,BFS(bombs,i,new boolean[bombs.length])); //checking bfs of all nodes 
        }
        return max;
    }
}
