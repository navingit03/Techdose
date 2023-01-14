//dfs
class Solution {
    int max=1;
    int dist[]=new int[100000];
    public void dfs(int src,List<List<Integer>> list,String s){
        dist[src]=1;
        for(int i=0;i<list.get(src).size();i++){
            int adj=list.get(src).get(i);
            dfs(adj,list,s);
            if(s.charAt(src)!=s.charAt(adj)) //if adj char is != src char
            {
                max=Math.max(max,dist[src]+dist[adj]); //max= subtree dist + src dist(already present path from source of high alternate sequence)
                dist[src]=Math.max(dist[src],dist[adj]+1); //updating src if any subtree has higher dist value
            }
        }
    }
    public int longestPath(int[] parent, String s) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(new ArrayList<>());
        }
        for(int i=1;i<parent.length;i++){
            list.get(parent[i]).add(i);
        }
        dfs(0,list,s);
        return max;

    }
}
