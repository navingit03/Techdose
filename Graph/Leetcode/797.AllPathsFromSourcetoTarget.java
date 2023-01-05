//797. All Paths From Source to Target by dfs
class Solution {
        List<List<Integer>> res=new ArrayList<>();
        int len;
    public void dfs(List<List<Integer>> list,int curr,List<Integer> currList)
    {
        if(curr==len-1) //if end is reached add it to res as list
        {
            res.add(new ArrayList<>(currList));
        }else
        {
            for(int i=0;i<list.get(curr).size();i++){
                currList.add(list.get(curr).get(i)); //adding curr node to currList
                dfs(list,list.get(curr).get(i),currList);
                currList.remove(currList.size()-1); //while backtracking remove it
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        len=graph.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++) //creating adjList
        {
            list.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++)
            {
                list.get(i).add(graph[i][j]); //adding val to adjList
            }
        }
        List<Integer> currList=new ArrayList<>();
        currList.add(0); //source
        dfs(list,0,currList); //dfs call
        return res;
    }
}
