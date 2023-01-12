class Solution {
    class Node{
        String key;
        double val;
        Node(String k,double v){
            key=k;
            val=v;
        }
    }
    public double dfs(String src,String des,Map<String,List<Node>> map,Set<String> visited){
        if(!map.containsKey(src)||!map.containsKey(des)) //if src or des not avaiable
        {
            return -1.0;
        }
        if(src.equals(des))
        {
            return 1.0; //self loop
        }
        visited.add(src); //make it visited
        for(Node ng:map.get(src))
        {
            if(!visited.contains(ng.key)) //not visited of des
            {
                double ans=dfs(ng.key,des,map,visited); //ans
                if(ans!=-1.0) //if ans!=-1 then mltiple it with ng.val
                {
                    return ans*ng.val;
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Node>> map=new HashMap<>(); //node contains des and value
        for(int i=0;i<values.length;i++){
            String src=equations.get(i).get(0);
            String des=equations.get(i).get(1);
            if(!map.containsKey(src))
            {
                map.put(src,new ArrayList<>());
            }
            if(!map.containsKey(des))
            {
                map.put(des,new ArrayList<>());
            }
            map.get(src).add(new Node(des,values[i])); //src->des (val)
            map.get(des).add(new Node(src,1/values[i])); //des->src (1/val)-reciprocal
        }
        double[] ans=new double[queries.size()]; //storing ans
        for(int i=0;i<queries.size();i++){
            String src=queries.get(i).get(0);
            String des=queries.get(i).get(1);
            ans[i]=dfs(src,des,map,new HashSet()); //dfs call
        }
        return ans;

    }
}
