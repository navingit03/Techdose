// k th smallest == (r*c-k+1) largest 
//use min heap to find (r*c-k+1) largest 
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        //using k space
        int r=mat.length;
        int c=mat[0].length;
        k=r*c-k+1;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(pq.size()<k || pq.peek()<mat[i][j])
                {
                    pq.add(mat[i][j]);
                }
                if(pq.size()==(k+1))
                {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
}
