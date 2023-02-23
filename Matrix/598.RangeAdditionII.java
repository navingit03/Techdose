class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for(int i=0;i<ops.length;i++){
            int x=ops[i][0],y=ops[i][1];
            m=Math.min(m,x); //update new row min
            n=Math.min(n,y); //update new col min 
        }
        return m*n;
    }
}
