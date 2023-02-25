class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int row=nums.size();
        int size=(row-1);
        int col=0,total=0;
        for(int i=0;i<row;i++){
            col=Math.max(col,nums.get(i).size());
        }
        size=size+col;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<nums.get(i).size();j++){
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
                total++;
            }
        }
        int ans[]=new int[total];
        int ind=0;
        for(int i=0;i<=size;i++){
            List<Integer> val=map.get(i);
            if(val==null) continue;
            for(int v:val){
                ans[ind++]=v;
            }
        }
        return ans;
    }
}
