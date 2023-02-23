class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //TC: O(log(mn))
        int r=matrix.length;
        int c=matrix[0].length;
        int low=0,high=r*c-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(matrix[mid/c][mid%c]==target){
                return true;
            }
            if(matrix[mid/c][mid%c]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
        /* TC: O(m+n) (worst case on bottom left);
        int r=matrix.length;
        int c=matrix[0].length;
        int row=0,col=c-1; //like bst with matrix[0][c-1] as root
        while(row<r&&col>=0){
            int curr=matrix[row][col];
            if(curr==target) return true;
            if(curr<target){
                row++;
            }else{
                col--;
            }
        }
        return false;*/
    }
}
