/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int res[][]=new int[n][n];
        int ctr=1;
        int dir=0,top=0,left=0,right=n-1,bottom=n-1;
        while(top<=bottom && left<=right){
            if(dir==0){
                for(int i=left;i<=right;i++){
                    res[top][i]=ctr++;
                }
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=bottom;i++){
                    res[i][right]=ctr++;
                }
                right--;
            }
            else if(dir==2){
                for(int i=right;i>=left;i--){
                    res[bottom][i]=ctr++;
                }
                bottom--;
            }
            else{
                for(int i=bottom;i>=top;i--){
                    res[i][left]=ctr++;
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return res;
    }
}
