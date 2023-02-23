class Solution {
    public int[][] transpose(int[][] matrix) {
        //its not always n*n matrix
        int newrow=matrix[0].length;
        int newcol=matrix.length;
        int ans[][]=new int[newrow][newcol];
        for(int i=0;i<newrow;i++){
            for(int j=0;j<newcol;j++){
                ans[i][j]=matrix[j][i]; //tarnspose condition
            }
        }
        return ans;
    }
}
