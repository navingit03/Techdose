//leetcode 56. Merge Intervals
//TC: O(n log n(sorting)+ n(iteration))
class Solution {
    public int[][] merge(int[][] mat) {
        ArrayList<int[]> list=new ArrayList<>();
        if(mat.length<=1)
            return mat;
        Arrays.sort(mat,(a,b)->(a[0]-b[0]));
        int st=mat[0][0];
        int end=mat[0][1];
        for(int[] i:mat){
            if(i[0]<=end){
                end=Math.max(end,i[1]);
            }else{
                list.add(new int[]{st,end});
                st=i[0];
                end=i[1];
            }
        }
        list.add(new int[]{st,end});
        return list.toArray(new int[0][]);
    }
}
